package dev.skillcode.asjobquiztrackingbackend.exception.exceptions

import org.springframework.http.HttpStatusCode

open class ApiException(override val message: String, val statusCode: HttpStatusCode) : RuntimeException(message)
