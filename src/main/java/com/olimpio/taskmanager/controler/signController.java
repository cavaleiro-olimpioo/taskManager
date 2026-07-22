package com.olimpio.taskmanager.controler;

import com.olimpio.taskmanager.domain.UserNew;
import com.olimpio.taskmanager.service.LoginService;
import com.olimpio.taskmanager.service.SignService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/Sign")
public class signController {

    private SignService signService;

    signController(SignService signService) { this.signService = signService; }

    public void CreateAccount(@RequestBody UserNew body, HttpServletResponse response) throws IOException {
        signService.createAccount(body.getEmail(), body.getUsername(), body.getFirstName(), body.getLastName(), body.getPassword());
        response.sendRedirect("/login");
    }
}
