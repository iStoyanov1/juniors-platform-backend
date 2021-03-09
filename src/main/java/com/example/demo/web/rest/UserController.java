package com.example.demo.web.rest;

import com.example.demo.data.models.dtos.views.FileViewModel;
import com.example.demo.data.models.dtos.views.UserViewModel;
import com.example.demo.data.models.service.AuthServiceModel;
import com.example.demo.data.models.service.FileServiceModel;
import com.example.demo.data.models.service.UserServiceModel;
import com.example.demo.services.interfaces.AuthService;
import com.example.demo.services.interfaces.FileService;
import com.example.demo.services.interfaces.UserService;
import org.apache.commons.io.FileUtils;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.Objects;

@RestController
public class UserController {

    private final AuthService authService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final FileService fileService;

    public UserController(AuthService authService, UserService userService, ModelMapper modelMapper, FileService fileService) {
        this.authService = authService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.fileService = fileService;
    }


    @GetMapping("/api/user/profile")
    @CrossOrigin
    public UserViewModel userProfile(Principal principal) {
        UserServiceModel user = findUser(principal.getName());

        UserViewModel userViewModel = this.modelMapper.map(user, UserViewModel.class);
        userViewModel.setUsername(principal.getName());
        System.out.println();
        return userViewModel;

    }

    @PostMapping(value = "/api/user/profile/cv")
    public void uploadCV(@RequestParam("file") MultipartFile file, Principal principal) throws IOException {

        FileServiceModel fileServiceModel = this.modelMapper.map(file, FileServiceModel.class);

        System.out.println();
        fileServiceModel = this.fileService.uploadFile(fileServiceModel);


        UserServiceModel user = findUser(principal.getName());

        user.setFile(fileServiceModel);

        this.userService.uploadUserCV(user);
    }

   @GetMapping(value = "/api/user/profile/download")
    public ResponseEntity<Resource> downloadFile(Principal principal) throws IOException {

        UserServiceModel user = findUser(principal.getName());

        FileViewModel fileViewModel = this.modelMapper.map(this.fileService.getFileById(user.getFile().getId())
                , FileViewModel.class);

        //To get Actual PDF content as Bytes
        byte[] pdfBytes = fileViewModel.getBytes();

        String fileName = fileViewModel.getOriginalFileName();
        MediaType mediaType = MediaType.parseMediaType("application/pdf");
        File file = new File(fileName);
        FileUtils.writeByteArrayToFile(file, pdfBytes); //org.apache.commons.io.FileUtils
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                // Content-Disposition
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + file.getName())
                // Content-Type
                .contentType(mediaType)
                // Contet-Length
                .contentLength(file.length()) //
                .body(resource);

    }


    private UserServiceModel findUser(String username) {
        AuthServiceModel auth = this.authService.findByUsername(username);

        return this.userService.findUserByAuthId(auth.getId());
    }
}
