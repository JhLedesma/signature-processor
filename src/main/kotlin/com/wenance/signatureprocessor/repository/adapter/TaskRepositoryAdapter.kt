package com.wenance.signatureprocessor.repository.adapter

import com.wenance.signatureprocessor.core.model.Task
import com.wenance.signatureprocessor.repository.StepRepository
import com.wenance.signatureprocessor.repository.TaskRepository
import com.wenance.signatureprocessor.repository.dao.TaskDao
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.toSet
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitFirstOrNull

class TaskRepositoryAdapter(val taskDao: TaskDao, val stepRepository: StepRepository) : TaskRepository {

    override suspend fun saveTask(task: Task): Task {
        task.steps.forEach { step -> stepRepository.save(step, task.hashId) }
        return taskDao.save(task.toTaskEntity()).map { t -> t.toTask(task.steps) }.awaitFirst()
    }

    @FlowPreview
    override suspend fun findByHashId(hashId: String): Task? {
        val steps = stepRepository.findAllByTaskId(hashId).toSet()
        return taskDao.findByHashId(hashId).map { t -> t.toTask(steps) }.awaitFirstOrNull()
    }
}