package com.wenance.signatureprocessor.repository.dao

import com.wenance.signatureprocessor.core.model.Step
import com.wenance.signatureprocessor.repository.domain.StepEntity
import com.wenance.signatureprocessor.repository.domain.TaskEntity
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface StepDao : ReactiveCrudRepository<StepEntity, Long> {

    @Query("select * from step where task_id = $1")
    fun findAllByTaskId(taskId: String): Flux<StepEntity>
}