package com.learning.java.simulate.app;

import lombok.Data;

@Data
public class Response {

    private String resultCode;

    private String resultMsg;

    public Response(String resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }
}
