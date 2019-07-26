package com.microservices.microservice.docker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class MicroserviceDockerApplication

@RestController
class GreetingsController {
	@GetMapping("/greetings")
	fun greetings() = "hello from a Docker"
}

fun main(args: Array<String>) {
	runApplication<MicroserviceDockerApplication>(*args)
}
