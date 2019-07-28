package com.microservices.reactive.microservice

class CustomerExistException(override val message: String): Exception(message)