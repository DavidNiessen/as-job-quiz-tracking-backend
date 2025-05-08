package dev.skillcode.asjobquiztrackingbackend.service

import dev.skillcode.asjobquiztrackingbackend.converter.TrackingEntityToModelConverter
import dev.skillcode.asjobquiztrackingbackend.entity.TrackingEntity
import dev.skillcode.asjobquiztrackingbackend.exception.exceptions.EventNameNotAllowedException
import dev.skillcode.asjobquiztrackingbackend.exception.exceptions.EventNameNotFoundException
import dev.skillcode.asjobquiztrackingbackend.model.TrackingModel
import dev.skillcode.asjobquiztrackingbackend.repository.TrackingRepository
import org.springframework.stereotype.Service

@Service
class TrackingService(
    private val trackingRepository: TrackingRepository,
    private val toModelConverter: TrackingEntityToModelConverter,
    private val whitelistService: EventWhitelistService,
) {

    fun getAllTrackingStats(): List<TrackingModel> {
        return trackingRepository.findAll().map {
            toModelConverter.convert(it)
        }
    }

    fun getTrackingStatsForEvent(eventName: String): TrackingModel {
        val entity = trackingRepository.findByEventName(eventName)
            ?: throw EventNameNotFoundException(eventName)

        return toModelConverter.convert(entity)
    }

    fun trackEvent(eventName: String) {
        if (eventName.isBlank() || !whitelistService.isAllowed(eventName)) {
            throw EventNameNotAllowedException(eventName)
        }

        val databaseEntity = trackingRepository.findByEventName(eventName)

        trackingRepository.save(TrackingEntity(eventName, (databaseEntity?.count ?: 0) + 1))
    }

}
