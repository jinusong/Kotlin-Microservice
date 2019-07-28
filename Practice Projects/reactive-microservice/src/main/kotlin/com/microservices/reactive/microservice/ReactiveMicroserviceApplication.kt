package com.microservices.reactive.microservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveMicroserviceApplication

fun main(args: Array<String>) {
	runApplication<ReactiveMicroserviceApplication>(*args)
}
