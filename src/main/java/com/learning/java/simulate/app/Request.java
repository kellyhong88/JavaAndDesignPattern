package com.learning.java.simulate.app;

import lombok.Data;

@Data
public class Request {

    private Integer requestID;

    public Request(Integer requestID) {
        this.requestID = requestID;
    }

    public Integer getRequestID() {
        return requestID;
    }

}
