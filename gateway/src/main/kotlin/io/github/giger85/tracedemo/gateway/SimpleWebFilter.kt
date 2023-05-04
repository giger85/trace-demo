package io.github.giger85.tracedemo.gateway

import mu.KotlinLogging
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

private val logger = KotlinLogging.logger { }

class SimpleWebFilter : WebFilter {
    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {

        val loggingMono = Mono.fromRunnable<Void> {
            logger.info { "Before simple filter. traceId: ${OneAgentUtils.getTraceId()}" }
        }

        return loggingMono
            .then(chain.filter(exchange))
    }
}