package com.wenance.signatureprocessor.core.model

import com.wenance.signatureprocessor.repository.domain.StepEntity

data class Step(
    val status: StepStatus,
    val typeName: StepTypeName,
    val id: Long? = null,
    val urlSelfie: String? = null,
    val urlDni: String? = null,
    val urlDniBack: String? = null,
    val hashValue: String? = null
) {
    fun toStepEntity(taskId: String): StepEntity = StepEntity(status.name, taskId, typeName.name, id, urlSelfie, urlDni, urlDniBack, hashValue)
}


enum class StepTypeName { HASH, FOTO, DNI; }

enum class StepStatus { PENDING, CREATED, PROCESSING, OPERATOR, AUDIT, COMPLETED; }

data class StepType(val productEntity: String, val productType: String, val stepTypeName: StepTypeName)