package com.zup.demo.handler

import com.zup.demo.exception.DeviceAlreadyExistsException
import com.zup.demo.exception.DeviceNotFoundException
import com.zup.demo.exception.ErrorDetails
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ErrorHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [DeviceNotFoundException::class])
    fun deviceNotFound(ex: DeviceNotFoundException) : ResponseEntity<ErrorDetails> {
        val errorDetails = ErrorDetails(ex.message!!)
        return ResponseEntity(errorDetails, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(value = [DeviceAlreadyExistsException::class])
    fun deviceAlreadyExists(ex: DeviceAlreadyExistsException) : ResponseEntity<ErrorDetails> {
        val errorDetails = ErrorDetails(ex.message!!)
        return ResponseEntity(errorDetails, HttpStatus.CONFLICT)
    }

}