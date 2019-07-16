package com.microservices.reactive.spring.data.service

import com.microservices.reactive.spring.data.entity.Customer
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface CustomerService {
    fun getCustomer(id: Int): Mono<Customer>
    fun createCustomer(customer: Mono<Customer>): Mono<Customer>
    fun deleteCustomer(id: Int): Mono<Boolean>
    fun searchCustomers(nameFilter: String): Flux<Customer>
}