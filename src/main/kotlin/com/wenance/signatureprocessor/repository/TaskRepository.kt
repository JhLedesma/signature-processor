package com.wenance.signatureprocessor.repository

import com.wenance.signatureprocessor.core.model.Task

interface TaskRepository {

    suspend fun saveTask(task: Task): Task
    suspend fun findByHashId(hashId: String): Task?
}