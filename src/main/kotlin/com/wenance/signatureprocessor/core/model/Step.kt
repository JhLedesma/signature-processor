package com.wenance.signatureprocessor.core.model

sealed class Step(open val status: StepStatus, val typeName: StepTypeName) {
    lateinit var id: String
}

data class SelfieStep(override val status: StepStatus, val urlSelfie: String, val urlDni: String) : Step(status, StepTypeName.FOTO)

data class HashStep(override val status: StepStatus, val urlSelfie: String, val hashValue: String) : Step(status, StepTypeName.HASH)

data class DniStep(override val status: StepStatus, val urlDni: String, val urlDniBack: String) : Step(status, StepTypeName.DNI)

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