package com.olimpio.taskmanager.domain;

public class tokenReciveRequest {
    private String token;

    public tokenReciveRequest() {
    }

    public tokenReciveRequest(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}