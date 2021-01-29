package com.wenance.signatureprocessor.repository.dao

import com.wenance.signatureprocessor.core.model.Task
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface TaskDao : ReactiveCrudRepository<Task, Long> {
}