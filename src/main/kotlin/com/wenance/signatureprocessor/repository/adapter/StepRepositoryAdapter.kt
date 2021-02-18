package com.wenance.signatureprocessor.repository.adapter

import com.wenance.signatureprocessor.core.model.Step
import com.wenance.signatureprocessor.repository.StepRepository
import com.wenance.signatureprocessor.repository.dao.StepDao
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitSingle
import kotlinx.coroutines.reactive.awaitSingleOrNull

class StepRepositoryAdapter(val stepDao: StepDao) : StepRepository {

    override suspend fun save(step: Step, taskId: String): Step =
        stepDao.save(step.toStepEntity(taskId)).map { it.toStep() }.awaitSingle()

    override suspend fun findById(id: Long): Step? =
        stepDao.findById(id).map { it.toStep() }.awaitSingleOrNull()

    @FlowPreview
    override fun findAllByTaskId(taskId: String): Flow<Step> =
        stepDao.findAllByTaskId(taskId).map { it.toStep() }.asFlow()
}