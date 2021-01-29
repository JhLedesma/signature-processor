package com.wenance.signatureprocessor.repository.adapter

import com.wenance.signatureprocessor.core.model.Task
import com.wenance.signatureprocessor.repository.TaskRepository
import com.wenance.signatureprocessor.repository.dao.TaskDao
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitSingle

class TaskRepositoryAdapter(val taskDao: TaskDao) : TaskRepository {

    override suspend fun saveTask(task: Task): Task {
        return taskDao.save(task).awaitFirst()
    }
}