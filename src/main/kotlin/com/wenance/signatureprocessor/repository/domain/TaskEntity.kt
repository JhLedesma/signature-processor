package com.wenance.signatureprocessor.repository.domain

import com.wenance.signatureprocessor.core.model.Step
import com.wenance.signatureprocessor.core.model.Task
import com.wenance.signatureprocessor.core.model.TaskStatus
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Transient
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

@Table("task")
data class TaskEntity (

    @Id
    @Column("hash_id")
    val hashId: String,

    @Column("dni")
    val dni: String,

    @Column("task_status")
    var status: String,

    @Column("product_entity")
    val productEntity: String,

    @Column("product_type")
    val productType: String,

    @Transient
    val stepEntities: Set<StepEntity>,

    @Column("creation_date")
    var creationDate: LocalDateTime? = null,

    @Column("update_date")
    var updateDate: LocalDateTime? = null
) {

    fun toTask(steps: Set<Step>): Task =
        Task(hashId,
            dni,
            productEntity,
            productType,
            TaskStatus.valueOf(status),
            steps,
            creationDate,
            updateDate
        )
}