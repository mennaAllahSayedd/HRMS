package com.example.authService.Controllers;

import com.example.authService.Dto.LoginRequestDto;
import com.example.authService.Dto.RegisterRequestDto;
import com.example.authService.Dto.RegisterResponseDto;
import com.example.authService.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class UserController {

    private  UserService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto request) {

        try{
            boolean valid = authService.login(
                    request.getUsername(),
                    request.getPassword()
            );

            if (valid)
                return ResponseEntity.ok("Login Success");
            else
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Credentials");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error: " + e.getMessage());
        }

    }

    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody RegisterRequestDto requset){
      boolean isAuth=  authService.register(requset.getUsername(),requset.getPassword());
      try {
          if (isAuth) {
              return ResponseEntity.ok("Register Success");
          } else {
              return ResponseEntity.ok("Register Failed");

          }
      }catch (Exception e){
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                  .body("Error: " + e.getMessage());
          }
      }
    }


