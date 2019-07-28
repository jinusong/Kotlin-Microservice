package com.microservices.microservice.extension

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MicroserviceExtensionApplication

fun main(args: Array<String>) {
	runApplication<MicroserviceExtensionApplication>(*args)
}
