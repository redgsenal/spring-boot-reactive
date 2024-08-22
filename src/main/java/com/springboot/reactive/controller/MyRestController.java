package com.springboot.reactive.controller;

import com.springboot.reactive.utils.ReactiveSources;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;

@RestController
public class MyRestController {

    // call 2 mono function immediately executed one after another even though the browser waits to be completed
    @GetMapping("/demo1")
    public Mono<String> getDemo1() {
        return simpleMonoHello()
                .zipWith(anotherMonoHello())
                .map(value -> value.getT1() + " " + value.getT2());
    }

    @GetMapping("/demo2")
    public Flux<String> getDemo2() {
        return ReactiveSources.stringNumbersFlux();
    }

    private Mono<String> simpleMonoHello() {
        System.out.println("simple here");
        return Mono.just("Hello There!")
                .delayElement(Duration.ofSeconds(5));
    }

    private Mono<String> anotherMonoHello() {
        System.out.println("another message here");
        return Mono.just("Greeting!!")
                .delayElement(Duration.ofSeconds(5));
    }
}
