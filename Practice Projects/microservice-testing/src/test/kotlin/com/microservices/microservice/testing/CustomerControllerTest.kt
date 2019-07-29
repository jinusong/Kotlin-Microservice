package com.microservices.microservice.testing

import org.amshove.kluent.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.*
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.ResultHandler
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.JsonPathResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

class WithKeyword {
    infix fun `jsosn path`(expression: String) = jsonPath("\$" + expression)
}

val With = WithKeyword()

class ThatKeyword {
    infix fun `status is http`(value: Int) = status().`is`(value)
}

val That = ThatKeyword()

infix fun JsonPathResultMatchers.`that the value is`(value: Any) = this.value(value)
infix fun ResultActions.`and expect`(matcher: ResultMatcher) = this.andExpect(matcher)
infix fun ResultActions.`and then do`(handler: ResultHandler) = this.andDo(handler)
infix fun MockMvc.`do a get request to`(uri: String) = this.perform(get(uri))

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var customerService: CustomerService

    @Test
    fun `mock mvc should be configured`() {
    }

    @Test
    fun `we should Get a customer by id`() {
        When calling customerService.getCustomer(1) `it returns`
                Customer(1, "mock customer")

        (mockMvc `do a get request to` "/customer/1"
                `and expect` (That `status is http` 200)
                `and expect` (With `jsosn path` ".id" `that the value is` 1)
                `and expect` (With `jsosn path` ".name" `that the value is` "mock customer")
                `and then do` print())

        Verify on customerService that customerService.getCustomer(1) was called
        `Verify no further interactions` on customerService


        Mockito.reset(customerService)
    }

    @Test
    fun `we should GET a list of customers`() {
        When calling customerService.getAllCustomers() `it returns` listOf(
                Customer(1, "test"), Customer(2, "mocks"))

        (mockMvc `do a get request to` "/customers"
                `and expect` (That `status is http` 200)
                `and expect` (With `jsosn path` "[0].id" `that the value is` 1)
                `and expect` (With `jsosn path` "[0].name" `that the value is` "test")
                `and expect` (With `jsosn path` "[1].id" `that the value is` 2)
                `and expect` (With `jsosn path` "[1].name" `that the value is` "mocks")
                ) `and then do` print()

        Verify on customerService that customerService.getAllCustomers() was called
        `Verify no further interactions` on customerService

        Mockito.reset(customerService)
    }
}