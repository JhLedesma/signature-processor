package com.wenance.signatureprocessor.repository.adapter

import com.wenance.signatureprocessor.core.model.Step
import com.wenance.signatureprocessor.repository.StepRepository
import com.wenance.signatureprocessor.repository.dao.StepDao

class StepRepositoryAdapter(val stepDao: StepDao) : StepRepository {
    override fun findById(id: String): Step? {
        TODO("Not yet implemented")
    }
}