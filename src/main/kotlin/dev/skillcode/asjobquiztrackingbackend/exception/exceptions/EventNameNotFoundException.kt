package dev.skillcode.asjobquiztrackingbackend.exception.exceptions

import org.springframework.http.HttpStatus

class EventNameNotFoundException(eventName: String) :
    ApiException("Event $eventName not found", HttpStatus.NOT_FOUND)
