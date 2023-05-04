package io.github.giger85.tracedemo.gateway

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.cloud.gateway.support.RouteMetadataUtils
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod

@Configuration
class RouteConfig {
    @Bean
    fun routeLocator(builder: RouteLocatorBuilder): RouteLocator {
        return builder.routes()
            .route("trace") { predicateSpec ->
                predicateSpec
                    .path("/trace").and().method(HttpMethod.GET)
                    .filters { filterSpec ->
                        filterSpec
                            .prefixPath("/api")
                    }
                    .metadata(RouteMetadataUtils.RESPONSE_TIMEOUT_ATTR, 1000 * 3)
                    .uri("http://localhost:8902")
            }
            .build()
    }
}