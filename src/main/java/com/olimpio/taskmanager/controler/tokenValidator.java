package com.olimpio.taskmanager.controler;

import com.olimpio.taskmanager.domain.tokenReciveRequest;
import com.olimpio.taskmanager.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validator")
public class tokenValidator {

    private String token;
    private final JwtUtil jwtUtil;

    public tokenValidator(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    @CrossOrigin("http://localhost:5173")
    public Claims returnValitator(@RequestBody tokenReciveRequest token){
        return jwtUtil.validarToken(token.getToken());
    }

}
