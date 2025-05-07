package dev.skillcode.asjobquiztrackingbackend.controller

import dev.skillcode.asjobquiztrackingbackend.dto.TrackEventRequest
import dev.skillcode.asjobquiztrackingbackend.model.TrackingModel
import dev.skillcode.asjobquiztrackingbackend.service.TrackingService
import org.springframework.web.bind.annotation.*

@RestController()
@RequestMapping("/api/tracking")
class TrackingRestController(
    private val trackingService: TrackingService,
) {

    @GetMapping
    fun getAllTrackingStats(): List<TrackingModel> {
        return trackingService.getAllTrackingStats()
    }

    @GetMapping(params = ["eventName"])
    fun getTrackingStatsForEvent(
        @RequestParam eventName: String,
    ): TrackingModel {
        return trackingService.getTrackingStatsForEvent(eventName)
    }

    @PostMapping
    fun trackEvent(@RequestBody request: TrackEventRequest) {
        trackingService.trackEvent(request.eventName)
    }
}
