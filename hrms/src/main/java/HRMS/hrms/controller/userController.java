package HRMS.hrms.controller;


import HRMS.hrms.dto.userDto;
import HRMS.hrms.model.sendOtp;
import HRMS.hrms.model.userModel;
import HRMS.hrms.model.validateOtpModel;
import HRMS.hrms.service.userService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class userController {

    @Autowired
    private userService userService;

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(
            @RequestBody userModel userModel,
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
            @RequestBody userDto user
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
