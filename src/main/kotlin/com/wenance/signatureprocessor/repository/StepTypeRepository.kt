package com.wenance.signatureprocessor.repository

import com.wenance.signatureprocessor.core.model.StepType

interface StepTypeRepository {

    fun findByProductTypeAndProductEntity(productType: String, productEntity: String): Set<StepType>?
}