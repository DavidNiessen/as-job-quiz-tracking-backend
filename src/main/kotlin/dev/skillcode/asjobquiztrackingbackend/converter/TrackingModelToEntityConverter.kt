package dev.skillcode.asjobquiztrackingbackend.converter

import dev.skillcode.asjobquiztrackingbackend.entity.TrackingEntity
import dev.skillcode.asjobquiztrackingbackend.model.TrackingModel
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class TrackingModelToEntityConverter : Converter<TrackingModel, TrackingEntity> {
    
    override fun convert(source: TrackingModel) = TrackingEntity(source.eventName, source.count)
}
