package com.wenance.signatureprocessor.utils

import org.modelmapper.ModelMapper
import org.modelmapper.config.Configuration
import org.modelmapper.convention.MatchingStrategies

class MapperDto() : ModelMapper() {
    init {
        configuration.matchingStrategy = MatchingStrategies.LOOSE
        configuration.fieldAccessLevel = Configuration.AccessLevel.PRIVATE
        configuration.isFieldMatchingEnabled = true
        configuration.isSkipNullEnabled = true
    }
}

object ModelMapper {
    val mapper = MapperDto()

    inline fun <S, reified T> convert(source: S): T = mapper.map(source, T::class.java)
    inline fun <S, reified T> convert(source: S, destinationType: Class<T>): T = mapper.map(source, destinationType)
}
