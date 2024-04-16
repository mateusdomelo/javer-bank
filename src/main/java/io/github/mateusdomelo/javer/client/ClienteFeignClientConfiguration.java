package io.github.mateusdomelo.javer.client;

import feign.codec.ErrorDecoder;
import io.github.mateusdomelo.javer.client.decoder.RetrieveErrorDecoder;
import org.springframework.context.annotation.Bean;

public class ClienteFeignClientConfiguration {
    @Bean
    public ErrorDecoder errorDecoder() {
        return new RetrieveErrorDecoder();
    }
}
