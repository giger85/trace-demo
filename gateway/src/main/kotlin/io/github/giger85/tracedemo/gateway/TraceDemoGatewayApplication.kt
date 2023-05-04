package io.github.giger85.tracedemo.gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.ApplicationPidFileWriter
import org.springframework.boot.runApplication

@SpringBootApplication
class TraceDemoGatewayApplication

fun main(args: Array<String>) {
    // Hooks.enableAutomaticContextPropagation()

    runApplication<TraceDemoGatewayApplication>(*args) {
        addListeners(ApplicationPidFileWriter("gateway.pid"))
    }
}