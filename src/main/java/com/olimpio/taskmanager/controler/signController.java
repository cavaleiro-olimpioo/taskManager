package com.olimpio.taskmanager.controler;

import com.olimpio.taskmanager.domain.UserNew;
import com.olimpio.taskmanager.service.LoginService;
import com.olimpio.taskmanager.service.SignService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/sign")
public class signController {

    private SignService signService;

    signController(SignService signService) { this.signService = signService; }

    @PostMapping
    @CrossOrigin("http://localhost:5173")
    public String CreateAccount(@RequestBody UserNew body, HttpServletResponse response) throws IOException {
        try {
            signService.createAccount(body.getEmail(), body.getUsername(), body.getFirstName(), body.getLastName(), body.getPassword());
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Success";
    }
}
