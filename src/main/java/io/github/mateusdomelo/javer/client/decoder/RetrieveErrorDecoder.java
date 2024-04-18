package io.github.mateusdomelo.javer.client.decoder;

import feign.FeignException;
import feign.Response;
import feign.codec.ErrorDecoder;
import io.github.mateusdomelo.javer.exception.NotFoundException;
import org.apache.coyote.BadRequestException;

public class RetrieveErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 400 -> new BadRequestException("Bad Request");
            case 404 -> new NotFoundException("Not Found");
            case 500 -> new FeignException.BadRequest(
                    "Occurred a server-side error",
                    response.request(),
                    response.request().body(),
                    response.headers()
            );
            default -> errorDecoder.decode(methodKey, response);
        };
    }
}
