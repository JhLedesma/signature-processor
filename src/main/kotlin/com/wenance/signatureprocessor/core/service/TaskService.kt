package com.wenance.signatureprocessor.core.service

import com.wenance.signatureprocessor.core.model.*
import com.wenance.signatureprocessor.repository.StepTypeRepository
import com.wenance.signatureprocessor.repository.TaskRepository

class TaskService(val taskRepository: TaskRepository, val stepTypeRepository: StepTypeRepository, val stepFactory: StepFactory) {

/*    fun createTask(taskInput: TaskInput): Task =

        createSteps(taskInput)

        taskInput.run { Task(hashId, dni, productEntity, productType, TaskStatus.DISPATCHED, createSteps(this)) }

    private fun createSteps(taskInput: TaskInput): Set<Step> =
        stepTypeRepository
            .findByProductTypeAndProductEntity(taskInput.productType, taskInput.productEntity)
            .orEmpty()
            .map { it.stepTypeName }
            .map { stepFactory.createStep(it, taskInput.hashId) }
            .toSet()*/
}