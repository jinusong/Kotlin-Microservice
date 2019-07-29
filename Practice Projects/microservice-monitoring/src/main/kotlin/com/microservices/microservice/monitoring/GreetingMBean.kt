package com.microservices.microservice.monitoring

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jmx.export.annotation.ManagedOperation
import org.springframework.jmx.export.annotation.ManagedOperationParameter
import org.springframework.jmx.export.annotation.ManagedOperationParameters
import org.springframework.jmx.export.annotation.ManagedResource
import org.springframework.stereotype.Component

@Component
@ManagedResource(objectName = "com.microservice:type=greeting, name=GetHello",
        description = "Get greeting")
class GreetingMBean {
    @Autowired
    lateinit var greetingService: GreetingService

    @ManagedOperation(description = "Returns a greeting message")
    @ManagedOperationParameters(ManagedOperationParameter(description = "provide a name", name = "name"))
    fun hello(name: String) = try {
        greetingService.getGreeting() + "$name!"
    } catch (exception: Exception) {
        "oh $$name, we get an error: $exception"
    }
}