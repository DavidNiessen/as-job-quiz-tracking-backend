package dev.skillcode.asjobquiztrackingbackend.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class TrackingEntity(
    @Id
    var eventName: String = "",
    var count: Int = 0,
)
