package org.howe.examples.hello.world.rest.filter;


import org.howe.examples.hello.world.rest.filter.annotations.TraceEndpoint;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@TraceEndpoint
@Provider
public class TraceEndpointFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Logger.getLogger(TraceEndpoint.class.getName()).log(Level.INFO, "{0} -> {1}",
                new Object[]{requestContext.getMethod(), requestContext.getUriInfo().getPath()});










    }
}
