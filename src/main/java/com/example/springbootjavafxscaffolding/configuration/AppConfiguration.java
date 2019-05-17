package com.example.springbootjavafxscaffolding.configuration;

import com.example.springbootjavafxscaffolding.controllers.DemoController;
import com.example.springbootjavafxscaffolding.service.HelloWorldMessageProvider;
import com.example.springbootjavafxscaffolding.service.MessageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    DemoController demoController() {
        return new DemoController();
    }

    @Bean
    MessageProvider messageProvider() {
        return new HelloWorldMessageProvider();
    }
}
