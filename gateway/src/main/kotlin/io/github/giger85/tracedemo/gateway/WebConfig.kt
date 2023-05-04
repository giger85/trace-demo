package io.github.giger85.tracedemo.gateway

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.server.reactive.HttpHandlerDecoratorFactory

@Configuration
class WebConfig {
    @Bean
    fun simpleFilter(): SimpleWebFilter {
        return SimpleWebFilter()
    }

    @Bean
    fun loggingHttpHandlerDecoratorFactory(): HttpHandlerDecoratorFactory {
        return HttpHandlerDecoratorFactory { httpHandler -> LoggingHttpHandlerDecorator(httpHandler) }
    }
}