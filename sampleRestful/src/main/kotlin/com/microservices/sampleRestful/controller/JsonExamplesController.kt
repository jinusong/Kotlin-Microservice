package com.microservices.sampleRestful.controller

import com.microservices.sampleRestful.entity.ComplexObject
import com.microservices.sampleRestful.entity.SimpleObject
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class JsonExamplesController
{
    @GetMapping(value = "/json")
    fun getJson() = ComplexObject(object1 = SimpleObject("hi", "kotlin"))
}