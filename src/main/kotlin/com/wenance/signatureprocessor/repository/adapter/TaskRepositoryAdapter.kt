package com.wenance.signatureprocessor.repository.adapter

import com.wenance.signatureprocessor.core.model.Task
import com.wenance.signatureprocessor.repository.TaskRepository
import com.wenance.signatureprocessor.repository.dao.TaskDao
import com.wenance.signatureprocessor.repository.domain.TaskEntity
import com.wenance.signatureprocessor.utils.ModelMapper
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitFirstOrNull

class TaskRepositoryAdapter(val taskDao: TaskDao) : TaskRepository {

    override suspend fun saveTask(task: Task): Task {
        return ModelMapper.convert(task, TaskEntity::class.java)
            .let { taskDao.save(it).awaitFirst() }
            .let { ModelMapper.convert(it, Task::class.java) }
    }

    override suspend fun findByHashId(task: Task): Task? {
        return taskDao.findByHashId(ModelMapper.convert(task, TaskEntity::class.java).hashId!!)
            .map { ModelMapper.convert(it, Task::class.java) }
            .awaitFirstOrNull()
    }
}