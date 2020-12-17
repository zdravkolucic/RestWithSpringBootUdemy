package de.zlucic;

import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private final static String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
}
