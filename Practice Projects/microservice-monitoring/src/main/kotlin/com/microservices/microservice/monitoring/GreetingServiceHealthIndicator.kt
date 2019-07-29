package com.microservices.microservice.monitoring

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.actuate.health.AbstractHealthIndicator
import org.springframework.boot.actuate.health.Health
import org.springframework.stereotype.Component

@Component
class GreetingServiceHealthIndicator: AbstractHealthIndicator() {
    @Autowired
    lateinit var greetingService: GreetingService

    override fun doHealthCheck(builder: Health.Builder) {
        val lastMessage = try {
            val message = greetingService.getGreeting()
            builder.up()
            message
        } catch (exception: Exception) {
            builder.down()
            "ERROR:$exception"
        }
        builder.withDetail("lastMessage", "lastMessage")
    }
}