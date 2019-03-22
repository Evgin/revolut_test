package com.revolut.test.configuration.interceptors;


import com.revolut.test.configuration.Connections;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.*;
import java.io.IOException;

@Provider
public class RestRequestInterceptor implements ReaderInterceptor, WriterInterceptor {


    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {

//        System.out.println("Start process request");

        return context.proceed();
    }

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {

        context.proceed();

//        System.out.println("Finish process request");

        Connections.closeConnection();
    }
}
