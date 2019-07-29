package com.microservices.microservice.monitoring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MicroserviceMonitoringApplication

fun main(args: Array<String>) {
	runApplication<MicroserviceMonitoringApplication>(*args)
}
