package com.wenance.signatureprocessor.repository.domain

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
    var status: TaskStatus,

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
)