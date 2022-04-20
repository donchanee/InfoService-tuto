package com.codestates.week2ass2.handlers;

import com.codestates.week2ass2.models.Job;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class InfoHandler {

    public static Mono<ServerResponse> infoHandling(ServerRequest request){
        String name = request.queryParam("name").orElse("User");

        Mono<Job> infoData = Mono.just(new Job("개발자 " + name));

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(infoData, Job.class);
    }
}
