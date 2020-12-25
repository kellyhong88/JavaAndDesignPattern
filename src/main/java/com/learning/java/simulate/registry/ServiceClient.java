package com.learning.java.simulate.registry;

import com.learning.java.simulate.app.Request;
import com.learning.java.simulate.app.Response;

/**
 * API for client to do send the request
 * */
public interface ServiceClient {

    Response service(Request request);

}
