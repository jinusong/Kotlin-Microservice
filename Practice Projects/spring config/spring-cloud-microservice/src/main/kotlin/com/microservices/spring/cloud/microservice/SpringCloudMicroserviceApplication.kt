package com.microservices.spring.cloud.microservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringCloudMicroserviceApplication

fun main(args: Array<String>) {
	runApplication<SpringCloudMicroserviceApplication>(*args)
}
