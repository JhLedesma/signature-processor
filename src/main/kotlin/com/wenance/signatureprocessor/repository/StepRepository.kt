package com.wenance.signatureprocessor.repository

import com.wenance.signatureprocessor.core.model.Step
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow

interface StepRepository {

    suspend fun save(step: Step, taskId: String): Step
    suspend fun findById(id: Long): Step?
    @FlowPreview
    fun findAllByTaskId(taskId: String): Flow<Step>
}