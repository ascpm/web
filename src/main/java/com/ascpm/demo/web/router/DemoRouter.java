package com.ascpm.demo.web.router;

import com.ascpm.demo.web.handler.DemoHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class DemoRouter {

    @Bean
    public RouterFunction<ServerResponse> route(DemoHandler handler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hello")
                        .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::hello);
    }

}
