package com.awsexample.awsimageupload.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/user-registration")
@AllArgsConstructor
public class UserRegistrationController {
    private  UserRegistrationService userRegistrationService;

    @PostMapping
    public String registerUser(@RequestBody UserRegistrationRequest request){
        return  userRegistrationService.registerUser(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return userRegistrationService.confirmToken(token);
    }
}
