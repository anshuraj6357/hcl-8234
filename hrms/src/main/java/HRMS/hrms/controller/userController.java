package HRMS.hrms.controller;


import HRMS.hrms.model.userModel;
import HRMS.hrms.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class userController {

    @Autowired
    private userService userService;

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(
            @RequestBody userModel userModel) {
        userService.createUser(userModel);
        return ResponseEntity.ok("User created successfully");
    }
}
