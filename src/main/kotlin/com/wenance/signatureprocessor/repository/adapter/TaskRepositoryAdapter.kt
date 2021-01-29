package com.wenance.signatureprocessor.repository.adapter

import com.wenance.signatureprocessor.core.model.Task
import com.wenance.signatureprocessor.repository.TaskRepository
import com.wenance.signatureprocessor.repository.dao.TaskDao

class TaskRepositoryAdapter(val taskDao: TaskDao) : TaskRepository {

    override fun createTask(task: Task): Task {
    }
}