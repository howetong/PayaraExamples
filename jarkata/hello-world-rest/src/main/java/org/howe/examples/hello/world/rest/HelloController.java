package org.howe.examples.hello.world.rest;


import org.howe.examples.hello.world.rest.filter.annotations.TraceEndpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello")
public class HelloController {
    @GET
    @TraceEndpoint
    public String sayHello() {
        return "{\"foo\": \"Hello, World\"}";
    }

    @GET
    @Path("/1")
    public String sayHello1() {
        return "Hello";
    }
}
