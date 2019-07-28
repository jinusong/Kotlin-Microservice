package com.microservices.reactive.spring.data

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveSpringDataApplication

fun main(args: Array<String>) {
	runApplication<ReactiveSpringDataApplication>(*args)
}
