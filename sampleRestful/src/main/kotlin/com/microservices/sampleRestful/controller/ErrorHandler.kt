package com.microservices.sampleRestful.controller

import com.microservices.sampleRestful.entity.ErrorResponse
import com.microservices.sampleRestful.exception.CustomerNotFoundException
import org.springframework.boot.json.JsonParseException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest

@ControllerAdvice
class ErrorHandler {
    @ExceptionHandler(JsonParseException::class)
    fun jsonParseExceptionHandler(servletRequest: HttpServletRequest, exception: Exception)
            : ResponseEntity<ErrorResponse> =
            ResponseEntity(ErrorResponse("JSON Error", exception.message ?: "invalid json"), HttpStatus.BAD_REQUEST)

    @ExceptionHandler(CustomerNotFoundException::class)
    fun customerNotFoundExceptionHandler(servletRequest: HttpServletRequest, exception: Exception)
        : ResponseEntity<ErrorResponse> =
            ResponseEntity(ErrorResponse("Customer Not Found", exception.message!!), HttpStatus.NOT_FOUND)
}