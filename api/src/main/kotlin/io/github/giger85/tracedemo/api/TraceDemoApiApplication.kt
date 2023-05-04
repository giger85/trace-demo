package io.github.giger85.tracedemo.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.ApplicationPidFileWriter
import org.springframework.boot.runApplication

@SpringBootApplication
class TraceDemoApiApplication

fun main(args: Array<String>) {
    runApplication<TraceDemoApiApplication>(*args) {
        addListeners(ApplicationPidFileWriter("api.pid"))
    }
}
