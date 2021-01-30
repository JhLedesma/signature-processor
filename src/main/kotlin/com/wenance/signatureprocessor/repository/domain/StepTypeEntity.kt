package com.wenance.signatureprocessor.repository.domain

import com.wenance.signatureprocessor.core.model.StepTypeName
import javax.persistence.*

@Entity
@Table(name = "step_type")
class StepTypeEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    open var id: Long? = null

    @Column(name = "product_entity")
    open var productEntity: String? = null

    @Column(name = "product_type")
    open var productType: String? = null

    @Column(name = "type_name")
    open var stepTypeName: StepTypeName? = null
}