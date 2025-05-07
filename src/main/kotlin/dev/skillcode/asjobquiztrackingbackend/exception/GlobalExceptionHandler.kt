package dev.skillcode.asjobquiztrackingbackend.exception

import dev.skillcode.asjobquiztrackingbackend.exception.exceptions.ApiException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.resource.NoResourceFoundException

@RestControllerAdvice
class GlobalExceptionHandler {

    private val logger = LoggerFactory.getLogger(javaClass)

    @ExceptionHandler(ApiException::class)
    fun handleApiException(exception: ApiException) =
        ResponseEntity
            .status(exception.statusCode)
            .body(mapOf("error" to exception.message))

    @ExceptionHandler(NoResourceFoundException::class)
    fun handleResourceNotFound(exception: NoResourceFoundException): ResponseEntity<Map<String, String>> {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(mapOf("error" to "Resource not found"))
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    fun handleResourceNotFound(exception: HttpRequestMethodNotSupportedException): ResponseEntity<Map<String, String>> {
        return ResponseEntity
            .status(HttpStatus.METHOD_NOT_ALLOWED)
            .body(mapOf("error" to "Method not allowed"))
    }

    @ExceptionHandler(Exception::class)
    fun handleGeneric(exception: Exception): ResponseEntity<Map<String, String>> {
        logger.error(exception.message, exception)
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(mapOf("error" to "Unexpected error occurred"))
    }

}
