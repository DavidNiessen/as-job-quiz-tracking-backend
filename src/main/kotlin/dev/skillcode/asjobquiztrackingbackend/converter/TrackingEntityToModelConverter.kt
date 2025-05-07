package dev.skillcode.asjobquiztrackingbackend.converter

import dev.skillcode.asjobquiztrackingbackend.entity.TrackingEntity
import dev.skillcode.asjobquiztrackingbackend.model.TrackingModel
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class TrackingEntityToModelConverter : Converter<TrackingEntity, TrackingModel> {
    
    override fun convert(source: TrackingEntity) = TrackingModel(source.eventName, source.count)
}
