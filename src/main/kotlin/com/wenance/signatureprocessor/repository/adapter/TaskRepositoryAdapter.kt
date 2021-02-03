package com.wenance.signatureprocessor.repository.adapter

import com.wenance.signatureprocessor.core.exception.ResourceNotFound
import com.wenance.signatureprocessor.core.model.Step
import com.wenance.signatureprocessor.core.model.Task
import com.wenance.signatureprocessor.repository.TaskRepository
import com.wenance.signatureprocessor.repository.dao.StepDao
import com.wenance.signatureprocessor.repository.dao.TaskDao
import com.wenance.signatureprocessor.repository.domain.TaskEntity
import com.wenance.signatureprocessor.utils.ModelMapper
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitFirstOrNull
import kotlinx.coroutines.reactive.awaitSingleOrNull

class TaskRepositoryAdapter(val taskDao: TaskDao, val stepDao: StepDao) : TaskRepository {

    override suspend fun saveTask(task: Task): Task {
        return task.toTaskEntity()
            .also { it.stepEntities.map { step -> stepDao.save(step) } }
            .let { taskDao.save(it).map { t -> t.toTask() }.awaitFirst() }
    }

    override suspend fun findByHashId(task: Task): Task? =
            taskDao.findByHashId(task.hashId).map { t -> t.toTask() }.awaitFirstOrNull()?.apply { findSteps(this) }





    private suspend fun findSteps(task: Task): Set<Step> {
        return task.steps
            .map {
                stepDao.findById(it.id!!).map { step -> step.toStep() }.awaitSingleOrNull()
                    ?: throw ResourceNotFound("No existe paso ${it.id} para tarea ${task.hashId}")
            }.toSet()
    }
}