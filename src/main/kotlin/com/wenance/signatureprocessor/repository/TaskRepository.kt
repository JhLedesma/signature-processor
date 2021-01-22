package com.wenance.signatureprocessor.repository

import com.wenance.signatureprocessor.core.model.Task

interface TaskRepository {

    fun createTask(task: Task): Unit
}