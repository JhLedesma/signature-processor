package com.wenance.signatureprocessor.repository.adapter

import com.wenance.signatureprocessor.core.model.Step
import com.wenance.signatureprocessor.core.model.StepType
import com.wenance.signatureprocessor.repository.StepTypeRepository
import com.wenance.signatureprocessor.repository.dao.StepTypeDao
import org.springframework.data.repository.reactive.ReactiveCrudRepository

class StepTypeRepositoryAdapter(val stepTypeDao: StepTypeDao) : StepTypeRepository {

    override fun findByProductTypeAndProductEntity(productType: String, productEntity: String): Set<StepType>? {
        TODO("Not yet implemented")
    }
}