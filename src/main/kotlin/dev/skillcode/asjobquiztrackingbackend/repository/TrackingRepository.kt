package dev.skillcode.asjobquiztrackingbackend.repository

import dev.skillcode.asjobquiztrackingbackend.entity.TrackingEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TrackingRepository : JpaRepository<TrackingEntity, String> {

    fun findByEventName(eventName: String): TrackingEntity?

}
