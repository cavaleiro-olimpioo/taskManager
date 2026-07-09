package com.olimpio.taskmanager.service;

public class LoginResponse {

    private String token;
    private boolean[] completeResp;

    public LoginResponse(String token, boolean[] completeResp) {
        this.token = token;
        this.completeResp = completeResp;
    }

    public String getToken() { return token; }
    public boolean[] getCompleteResp() { return completeResp; }
}
