package HRMS.hrms.auth.controller;


import HRMS.hrms.auth.dto.authDto;
import HRMS.hrms.auth.dto.sendOtp;
import HRMS.hrms.auth.model.authModel;
import HRMS.hrms.auth.dto.validateOtpModel;
import HRMS.hrms.auth.service.authService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class authController {

    @Autowired
    private authService userService;

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(
            @RequestBody authModel userModel,
            HttpServletResponse response) throws Exception {
        userService.createUser(userModel,response);
        return ResponseEntity.ok("User created successfully");
    }
    @PostMapping("/sendOtp")
    public ResponseEntity<String> SendOtp(
            @RequestBody sendOtp sp) throws Exception {

        userService.sendOtp(sp.getEmail());

        return ResponseEntity.ok("OTP sent successfully");
    }

    @PostMapping("/validateOtp")
    public ResponseEntity<String> validateOtp(
            @RequestBody validateOtpModel request) {

        String result = userService.validateOtp(
                request.getEmail(),
                request.getOtp()
        );

        return ResponseEntity.ok(result);
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestBody authDto user
    ){
        userService.login(user);
        return ResponseEntity.ok("User successfully logged in");
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {

        userService.deleteUser(id);

        return ResponseEntity.ok("User removed successfully");
    }
}
