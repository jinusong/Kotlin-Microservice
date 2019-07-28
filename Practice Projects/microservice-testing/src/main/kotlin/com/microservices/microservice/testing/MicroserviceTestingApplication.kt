package com.microservices.microservice.testing

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MicroserviceTestingApplication

fun main(args: Array<String>) {
	runApplication<MicroserviceTestingApplication>(*args)
}
