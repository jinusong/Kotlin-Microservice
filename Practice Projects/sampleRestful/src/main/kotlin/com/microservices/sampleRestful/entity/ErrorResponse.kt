package com.microservices.sampleRestful.entity

data class ErrorResponse(
        val error: String,
        val message: String)