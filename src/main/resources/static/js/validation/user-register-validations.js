$.validator.addMethod("regex",
    function (value, element, regexp) {
        var re = new RegExp(regexp);
        return this.optional(element) || re.test(value);
    }, "Please check your input."
);
$(document).ready(function () {
    $("#submit-form").validate({
        rules: {
            firstName: {
                required: true,
                minlength: 2,
                maxlength: 14,
                regex: "([А-Я][а-я]+)"
            },
            lastName: {
                required: true,
                minlength: 2,
                maxlength: 20,
                regex: "([А-Я][а-я]+)"
            },
            email: {
                required: true,
                regex: "^([\\w\\.\\-]+)@([\\w\\-]+)(\\D(\\.(\\w){2,3})+)$",
            },
            password: {
                required: true,
                regex: "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
            },
            confirmPassword: {
                required: true,
                regex: "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
                equalTo: "#password"
            }
        },
        messages: {
            firstName: {
                required: "Полето е задължително",
                minlength: "Името трябва да започва с главна буква, да е между 2-14 символа и да е на български",
                maxlength: "Името трябва да започва с главна буква, да е между 2-14 символа и да е на български",
                regex: "Името трябва да започва с главна буква, да е между 2-14 символа и да е на български"
            },
            lastName: {
                required: "Полето е задължително",
                minlength: "Фамилилята трябва да започва с главна буква, да е между 2-20 символа и да е на български",
                maxlength: "Фамилилята трябва да започва с главна буква, да е между 2-20 символа и да е на български",
                regex: "Фамилилята трябва да започва с главна буква, да е между 2-20 символа и да е на български"
            },
            email: {
                required: "Полето е задължително",
                regex: "Неправилен имейл адрес"
            },
            password: {
                required: "Полето е задължително",
                regex: "Паролата трябва да съдържа: \nМинимум 8 символа.\n " +
                    "Поне една малка буква.\n" +
                    "Поне една цифра."
            },
            confirmPassword: {
                required: "Полето е задължително",
                regex: "Паролата трябва да съдържа: \nМинимум 8 символа.\n " +
                    "Поне една малка буква.\n" +
                    "Поне една цифра.",
                equalTo: "Паролите не съвпадат"
            }
        },

    });
});