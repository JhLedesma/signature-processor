package com.wenance.signatureprocessor.repository.domain

import com.wenance.signatureprocessor.core.model.StepTypeName
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("step_type")
data class StepTypeEntity (

    @Column("product_entity")
    val productEntity: String,

    @Column("product_type")
    val productType: String,

    @Column("type_name")
    val stepTypeName: StepTypeName,

    @Id
    @Column("id")
    val id: Long? = null
)