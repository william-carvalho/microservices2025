package br.com.will.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("welcome-service")
public record WelcomeConfiguration(String welcome, String defaultValue) {
}
