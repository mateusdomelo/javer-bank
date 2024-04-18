package io.github.mateusdomelo.javer.client.decoder;

import feign.FeignException;
import feign.Request;
import feign.Response;
import feign.codec.ErrorDecoder;
import io.github.mateusdomelo.javer.exception.NotFoundException;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RetrieveErrorDecoderTest {
    private final RetrieveErrorDecoder retrieveErrorDecoder = new RetrieveErrorDecoder();

    @BeforeEach
    void setUp() {
    }

    @Test
    void decode_WithStatus400_ShouldReturnBadRequestException() {
        Response response = Response.builder()
                .status(400)
                .request(Request.create(Request.HttpMethod.GET, "/test", new HashMap<>(), null, null, null))
                .build();

        Exception result = retrieveErrorDecoder.decode("methodKey", response);

        assertInstanceOf(BadRequestException.class, result);
        assertEquals("Bad Request", result.getMessage());
    }

    @Test
    void decode_WithStatus404_ShouldReturnNotFoundException() {
        Response response = Response.builder()
                .status(404)
                .request(Request.create(Request.HttpMethod.GET, "/test", new HashMap<>(), null, null, null))
                .build();

        Exception result = retrieveErrorDecoder.decode("methodKey", response);

        assertInstanceOf(NotFoundException.class, result);
        assertEquals("Not Found", result.getMessage());
    }

    @Test
    void decode_WithStatus500_ShouldFeignExceptionBadRequest() {
        Response response = Response.builder()
                .status(500)
                .request(Request.create(Request.HttpMethod.GET, "/test", new HashMap<>(), null, null, null))
                .build();

        Exception result = retrieveErrorDecoder.decode("methodKey", response);

        assertInstanceOf(FeignException.BadRequest.class, result);
        assertEquals("Occurred a server-side error", result.getMessage());
    }

    @Test
    void decode_WithNotMappedStatus_ShouldDefaultFeignException() {
        Response response = Response.builder()
                .status(504)
                .request(Request.create(Request.HttpMethod.GET, "/test", new HashMap<>(), null, null, null))
                .build();

        Exception result = retrieveErrorDecoder.decode("methodKey", response);

        assertInstanceOf(FeignException.class, result);
    }
}