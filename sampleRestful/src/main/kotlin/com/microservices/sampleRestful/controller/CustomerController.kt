package com.microservices.sampleRestful.controller

import com.microservices.sampleRestful.entity.Customer
import com.microservices.sampleRestful.exception.CustomerNotFoundException
import com.microservices.sampleRestful.service.CustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CustomerController {
    @Autowired
    private lateinit var customerService: CustomerService

    @GetMapping(value = "/customer/{id}")
    fun getCustomer(@PathVariable id: Int): ResponseEntity<Customer?> {
        val customer = customerService.getCustomer(id) ?:
            throw CustomerNotFoundException("customer '$id' not found")
        return ResponseEntity(customer, HttpStatus.OK)
    }

    @PostMapping(value = "/customer/")
    fun createCustomer(@RequestBody customer: Customer): ResponseEntity<Unit?> {
        customerService.createCustomer(customer)
        return ResponseEntity<Unit?>(null, HttpStatus.CREATED)
    }

    @GetMapping(value = "/customers")
    fun getCustomers(@RequestParam(required = false, defaultValue = "") nameFilter: String): ResponseEntity<List<Customer?>> {
        val customerList = customerService.searchCustomers(nameFilter)
        val status = if (customerList.isEmpty()) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(customerList, status)
    }


    @DeleteMapping(value = "/customer/{id}")
    fun deleteCustomer(@PathVariable id: Int): ResponseEntity<Unit?> {
        var status = HttpStatus.NOT_FOUND

        if (customerService.getCustomer(id) != null) {
            customerService.deleteCustomer(id)
            status = HttpStatus.OK
        }

        return ResponseEntity<Unit?>(null, status)
    }

    @PutMapping(value = "/customer/{id}")
    fun updateCustomer(@PathVariable id: Int, @RequestBody customer: Customer): ResponseEntity<Unit?> {
        var status = HttpStatus.NOT_FOUND
        if (customerService.getCustomer(id) != null) {
            customerService.updateCustomer(id, customer)
            status = HttpStatus.ACCEPTED
        }
        return ResponseEntity<Unit?>(null, status)
    }
}