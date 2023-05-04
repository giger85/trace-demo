package io.github.giger85.tracedemo.api

import jakarta.servlet.http.HttpServletRequest
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger { }

@RestController
@RequestMapping("/api/trace")
class TraceController {
    @GetMapping("")
    fun get(request: HttpServletRequest) : Map<String, Any> {
        logger.info { "trace api started." }
        return request.headerNames.toList().associateWith { request.getHeader(it) }
    }
}