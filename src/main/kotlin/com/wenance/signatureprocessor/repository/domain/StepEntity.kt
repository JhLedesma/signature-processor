package com.wenance.signatureprocessor.repository.domain

import com.wenance.signatureprocessor.core.model.Step
import com.wenance.signatureprocessor.core.model.StepStatus
import com.wenance.signatureprocessor.core.model.StepTypeName
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("step")
data class StepEntity (

    @Column("step_status")
    var status: String,

    @Column("task_id")
    val taskId: String,

    @Column("type")
    val type: String,

    @Id
    @Column("id")
    val id: Long? = null,

    @Column("url_selfie")
    val urlSelfie: String? = null,

    @Column("url_dni")
    val urlDni: String? = null,

    @Column("url_dni_back")
    val urlDniBack: String? = null,

    @Column("hash_value")
    val hashValue: String? = null
) {
    fun toStep(): Step = Step(StepStatus.valueOf(status), StepTypeName.valueOf(type), id, urlSelfie, urlDni, urlDniBack, hashValue)
}