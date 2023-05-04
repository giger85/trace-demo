package io.github.giger85.tracedemo.gateway

import mu.KotlinLogging
import org.springframework.http.server.reactive.HttpHandler
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.http.server.reactive.ServerHttpResponse
import reactor.core.publisher.Mono

private val logger = KotlinLogging.logger { }

class LoggingHttpHandlerDecorator(
    private val delegate: HttpHandler
) : HttpHandler {
    override fun handle(request: ServerHttpRequest, response: ServerHttpResponse): Mono<Void> {
        return Mono.defer {
            logger.info { "HttpHandler started. traceId: ${OneAgentUtils.getTraceId()}"}

            delegate.handle(request, response)
        }
    }
}