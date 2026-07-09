package com.olimpio.taskmanager.service;
import com.olimpio.taskmanager.util.JwtUtil;
import org.springframework.stereotype.Service;


@Service
public class LoginService {





    private final JwtUtil jwtUtil;

    private String allusers[] = { "Pedro", "Guilherme", "Roberto" };
    private String passwd[] = { "pedro123", "guilherme123", "roberto123" };
    private String token;

    public LoginService(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public LoginResponse validarLogin(String nameBody, String passwdBody){
        boolean[] test = new boolean[2];
        for (int i = 0; i < allusers.length; i++) {
            if (allusers[i].equals(nameBody)){
                test[0] = true;
                if(passwd[i].equals(passwdBody)){
                    test[1] = true;
                    token = jwtUtil.gerarToken(nameBody);
                    break;
                } else {
                    test[1] = false;
                    break;
                }
            } else {
                test[0] = false;
            }
        }

        LoginResponse status = new LoginResponse(token, test);
        return status;

    }
}
