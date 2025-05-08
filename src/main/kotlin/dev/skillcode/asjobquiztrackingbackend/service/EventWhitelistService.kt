package dev.skillcode.asjobquiztrackingbackend.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class EventWhitelistService(
    @Value("\${event-whitelist}") private val whitelist: List<String>,
) {

    fun isAllowed(eventName: String) = whitelist.isEmpty() || whitelist.contains(eventName)
}
