package com.wenance.signatureprocessor.repository.dao

import com.wenance.signatureprocessor.core.model.Step
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface StepDao : ReactiveCrudRepository<Step, Long> {
}