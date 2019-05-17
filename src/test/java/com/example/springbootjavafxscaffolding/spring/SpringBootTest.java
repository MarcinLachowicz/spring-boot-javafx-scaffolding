package com.example.springbootjavafxscaffolding.spring;


import com.example.springbootjavafxscaffolding.configuration.AppConfiguration;
import com.example.springbootjavafxscaffolding.service.MessageProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class SpringBootTest {

    private AnnotationConfigApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        applicationContext.start();
    }

    @AfterEach
    void tearDown() {
        if (applicationContext != null) {
            applicationContext.close();
        }
    }

    @Test
    void givenAppContext_shouldContainMessageProvider() {
        assertThat(applicationContext.getBean(MessageProvider.class))
                .isNotNull();
    }

    @Test
    void givenMessageProvider_shouldReturnNextHelloMessage() {
        // given
        MessageProvider context = applicationContext.getBean(MessageProvider.class);

        // when
        String nextMessage = context.getNextMessage();

        // then
        assertThat(nextMessage)
                .startsWith("Hello");
    }

}
