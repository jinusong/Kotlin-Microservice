package com.microservices.spring.cloud.microservice.config.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class SpringCloudMicroserviceConfigServerApplication

fun main(args: Array<String>) {
	runApplication<SpringCloudMicroserviceConfigServerApplication>(*args)
}
