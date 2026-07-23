package com.olimpio.taskmanager.controler;

import com.olimpio.taskmanager.domain.UserNew;
import com.olimpio.taskmanager.service.LoginService;
import com.olimpio.taskmanager.service.SignService;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/sign")
public class signController {

    /*
        Erro geral = 1
        Erro de usuário existente = 2
        Erro de email já registrado = 3
     */


    private SignService signService;

    signController(SignService signService) {
        this.signService = signService;
    }

    @PostMapping
    @CrossOrigin("http://localhost:5173")
    public int CreateAccount(@RequestBody UserNew body, HttpServletResponse response) throws IOException {
        try {
            signService.createAccount(body.getEmail(), body.getUsername(), body.getFirstName(), body.getLastName(), body.getPassword());
            return 0;
        } catch (DataIntegrityViolationException e) {
            ConstraintViolationException ex =
                    (ConstraintViolationException) e.getCause();

            if (ex.getConstraintName().equals("uk_user_username")) {
                return 2;
            } else if (ex.getConstraintName().equals("uk_user_email")) {
                return 3;
            } else {
                System.out.println(ex.getConstraintName());
                return 1;

            }

        } catch (Exception e){
            return 1;
        }
       
    }
}
