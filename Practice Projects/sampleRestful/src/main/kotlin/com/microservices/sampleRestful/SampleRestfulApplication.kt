package com.microservices.sampleRestful

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SampleRestfulApplication

fun main(args: Array<String>) {
	runApplication<SampleRestfulApplication>(*args)
}
