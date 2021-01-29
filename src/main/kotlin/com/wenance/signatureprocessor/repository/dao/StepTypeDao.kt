package com.wenance.signatureprocessor.repository.dao

import com.wenance.signatureprocessor.core.model.Step
import com.wenance.signatureprocessor.core.model.StepType
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface StepTypeDao : ReactiveCrudRepository<StepType, Long> {
}