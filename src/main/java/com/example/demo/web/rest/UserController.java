package com.example.demo.web.rest;

import com.example.demo.data.models.dtos.UserEditPassowrdDto;
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
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    private final AuthService authService;
    private final UserService userService;
    private final ModelMapper modelMapper;
    private final FileService fileService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(AuthService authService, UserService userService, ModelMapper modelMapper, FileService fileService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.authService = authService;
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.fileService = fileService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @GetMapping("/api/user/profile")
    @CrossOrigin
    public UserViewModel userProfile(Principal principal) {
        UserServiceModel user = findUser(principal.getName());

        UserViewModel userViewModel = this.modelMapper.map(user, UserViewModel.class);
        userViewModel.setUsername(principal.getName());
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

   @GetMapping(value = "/api/user/profile/preview")
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

    @DeleteMapping(value = "/api/user/profile/deleteCV")
    @CrossOrigin
    public void deleteCV(Principal principal){
        UserServiceModel user = findUser(principal.getName());

        FileServiceModel file = this.fileService.getFileById(user.getFile().getId());
        this.fileService.deleteFileById(user.getId(), file.getId());

    }

    @PutMapping(value = "/api/user/profile/edit/password")
    @CrossOrigin
    public ResponseEntity<Map<String, String>> editPassword(@RequestBody UserEditPassowrdDto userEditPassowrdDto, Principal principal){

        Map<String,String> result = new HashMap<>();

        UserServiceModel userServiceModel = this.findUser(principal.getName());

        if (!this.bCryptPasswordEncoder.matches(userEditPassowrdDto.getOldPassword(), userServiceModel.getAuth().getPassword())){
            result.put("message", "Текущата парола е грешна");
            return ResponseEntity.badRequest().body(result);
        }else if (!(userEditPassowrdDto.getPassword().equals(userEditPassowrdDto.getConfirmPassword()))){
            result.put("message", "Паролите не съвпадат.");
            return ResponseEntity.badRequest().body(result);
        }

        this.userService.editUserPassword(userServiceModel.getId(), userEditPassowrdDto.getPassword());
        result.put("message", "Успешно променихте вашата парола");
        return ResponseEntity.ok().body(result);

    }

    /*@PostMapping(value = "api/user/profile/edit/name")
    public ResponseEntity editName(@RequestBody @Valid UserEditNameDto userEditNameDto, BindingResult bindingResult, Principal principal){

        if(bindingResult.hasErrors()){
            List<String> errors = bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
            return ResponseEntity.ok(errors);
        }

        UserServiceModel userServiceModel = findUser(principal.getName());
         this.userService.editUserName(userServiceModel.getId(),
                userEditNameDto.getFirstName(), userEditNameDto.getLastName());

         return (ResponseEntity) ResponseEntity.accepted();

    }*/


    private UserServiceModel findUser(String username) {
        AuthServiceModel auth = this.authService.findByUsername(username);

        return this.userService.findUserByAuthId(auth.getId());
    }


}
