package dev.skillcode.asjobquiztrackingbackend.dto

import dev.skillcode.asjobquiztrackingbackend.model.TrackingModel

data class GetTrackingResponse(
    val data: List<TrackingModel>,
)
