package com.wenance.signatureprocessor.core.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.wenance.signatureprocessor.repository.domain.TaskEntity
import java.time.LocalDateTime

data class Task(
    val hashId: String,
    val dni: String,
    val productEntity: String,
    val productType: String,
    val status: TaskStatus,
    val steps: Set<Step>,
    val creationDate: LocalDateTime?,
    val updateDate: LocalDateTime?
) {

    fun toTaskEntity(): TaskEntity =
        TaskEntity(hashId, dni, status.name, productEntity, productType, steps.map { it.toStepEntity(hashId) }.toSet(), creationDate, updateDate)
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