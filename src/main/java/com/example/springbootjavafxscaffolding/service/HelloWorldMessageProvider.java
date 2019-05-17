package com.example.springbootjavafxscaffolding.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HelloWorldMessageProvider implements MessageProvider {

    private final List<String> messagesToShow = Collections.unmodifiableList(
            Arrays.asList(
                    "Hello World Spring!",
                    "Hello World JavaFX!"
            ));

    private String currentMessage = messagesToShow.get(0);

    @Override
    public String getNextMessage() {
        final int currentMessageIndex = messagesToShow.indexOf(currentMessage);
        String nextMessage = messagesToShow.get((currentMessageIndex + 1) % messagesToShow.size());
        currentMessage = nextMessage;
        return nextMessage;
    }
}
