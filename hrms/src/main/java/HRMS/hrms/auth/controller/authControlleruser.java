package HRMS.hrms.auth.controller;


import HRMS.hrms.auth.dto.*;
import HRMS.hrms.auth.model.authModelUser;
import HRMS.hrms.auth.service.authServiceUser;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
public class authControlleruser {

    @Autowired
    private authServiceUser userService;


    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(
            @RequestBody authModelUser userModel,
            HttpServletResponse response) throws Exception {
        userService.createUser(userModel,response);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }


//    @PostMapping("/createUserusingEmail/{role}")
//    public ResponseEntity<String> createUserUsingEmail(
//            @RequestBody authUserRequestDto userModel,
//            HttpServletResponse response,
//            @PathVariable("role") roles role
//    ) throws userNotCreated {
//
//        userService.createUserUsingEmail(userModel, response, role);
//
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body("User created successfully");
//    }
//



    @PostMapping("/sendOtp")
    public ResponseEntity<String> SendOtp(
            @RequestBody sendOtpdto otpdata) throws Exception {
        System.out.println(otpdata.getRole());
        System.out.println(otpdata.getEmail());

        userService.sendOtp(otpdata);

        return ResponseEntity.ok("OTP sent successfully");
    }

    @PostMapping("/validateOtp")
    public ResponseEntity<Map<String,String>> validateOtp(
            @RequestBody validateOtpDto request) {

        String result = userService.validateOtp(
                request.getEmail(),
                request.getOtp()
        );

        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message",result));
    }


    @PostMapping("/login")
    public ResponseEntity<Map<String,authModelUser>> login(
            @RequestBody loginDto user,
            HttpServletResponse response
    ){
       authModelUser founduser= userService.login(user,response);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "user",founduser
        ));
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return ResponseEntity.ok("User removed successfully");
    }
}
