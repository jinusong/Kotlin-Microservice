package com.microservices.spring.cloud.microservice

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetinrgsController {
    @Value("\${microservice.example.greetings}")
    private lateinit var greetings: String

    @GetMapping("/greetings")
    fun greetings() = greetings
}