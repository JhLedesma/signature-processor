package com.wenance.signatureprocessor.core.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class Task(val hashId: String, val dni: String, val productEntity: String, val productType: String, val status: TaskStatus, val steps: Set<Step>) {
    lateinit var creationDate: LocalDateTime
    lateinit var updateDate: LocalDateTime
}

enum class TaskStatus(val value: String) {
    PENDING("Pendiente"),
    ERROR("Error"),
    VALID("Valido"),
    DISPATCHED("Enviado"),
    COMPLETED("Completado"),
    INVALID("Invalido");
}

data class TaskInput(
    @JsonProperty("product_entity") val productEntity: String,
    @JsonProperty("product_type") val productType: String,
    @JsonProperty("hash_id") val hashId: String,
    @JsonProperty("dni") val dni: String
)