package dev.skillcode.asjobquiztrackingbackend.exception.exceptions

import org.springframework.http.HttpStatus

class EventNameNotAllowedException(eventName: String) :
    ApiException("Event name \"$eventName\" is either invalid or not whitelisted", HttpStatus.BAD_REQUEST) {
}
