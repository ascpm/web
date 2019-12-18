package com.ascpm.demo.web.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.text.MessageFormat;

@Component
public class DemoHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {
        String requestAddress = request.remoteAddress()
                .map(InetSocketAddress::getAddress)
                .map(InetAddress::getHostAddress)
                .orElse("Empty Host");
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromValue(MessageFormat.format("{0} : Hello, Spring Web!", requestAddress)));
    }

}
