package com.wenance.signatureprocessor.core.model

sealed class Step(open val status: StepStatus, val typeName: StepTypeName, open val id: Long? = null)

data class SelfieStep(override val status: StepStatus, val urlSelfie: String, val urlDni: String, override val id: Long? = null) : Step(status, StepTypeName.FOTO, id)

data class HashStep(override val status: StepStatus, val urlSelfie: String, val hashValue: String, override val id: Long? = null) : Step(status, StepTypeName.HASH, id)

data class DniStep(override val status: StepStatus, val urlDni: String, val urlDniBack: String, override val id: Long? = null) : Step(status, StepTypeName.DNI, id)

enum class StepTypeName {
    HASH,
    FOTO,
    DNI;
}

enum class StepStatus {
    PENDING,
    CREATED,
    PROCESSING,
    OPERATOR,
    AUDIT,
    COMPLETED;
}

data class StepType(val productEntity: String, val productType: String, val stepTypeName: StepTypeName)