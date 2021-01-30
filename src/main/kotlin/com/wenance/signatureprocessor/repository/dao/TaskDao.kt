package com.wenance.signatureprocessor.repository.dao

import com.wenance.signatureprocessor.core.model.Task
import com.wenance.signatureprocessor.repository.domain.TaskEntity
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface TaskDao : ReactiveCrudRepository<TaskEntity, Long> {

    @Query("select * from task where hash_id = $1")
    fun findByHashId(hasId: String): Mono<TaskEntity>
}