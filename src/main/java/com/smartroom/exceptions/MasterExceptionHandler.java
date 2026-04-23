package com.smartroom.exceptions;

import com.smartroom.models.ErrorMessage;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class MasterExceptionHandler implements 
    ExceptionMapper<Throwable> { // This is the Global Safety Net (Part 5.4)

    @Override
    public Response toResponse(Throwable ex) {
        if (ex instanceof RoomNotEmptyException) {
            return Response.status(Response.Status.CONFLICT)
                .entity(new ErrorMessage(ex.getMessage(), 409)).build();
        }
        if (ex instanceof LinkedResourceNotFoundException) {
            return Response.status(422)
                .entity(new ErrorMessage(ex.getMessage(), 422)).build();
        }
        if (ex instanceof SensorUnavailableException) {
            return Response.status(Response.Status.FORBIDDEN)
                .entity(new ErrorMessage(ex.getMessage(), 403)).build();
        }
        
        // Catch-all for 500 errors (Safety Net)
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(new ErrorMessage("Internal Server Error: Secure Mode Active.", 500)).build();
    }
}