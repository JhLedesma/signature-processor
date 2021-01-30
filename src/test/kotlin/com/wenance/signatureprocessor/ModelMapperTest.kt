package com.wenance.signatureprocessor

import com.mapk.kmapper.KMapper
import com.wenance.signatureprocessor.core.model.*
import com.wenance.signatureprocessor.repository.domain.TaskEntity
import com.wenance.signatureprocessor.utils.ModelMapper
import org.junit.Test
import kotlin.test.assertEquals

class ModelMapperTest {

/*    @Test
    fun modelMapperOk() {
        val steps = setOf<Step>(SelfieStep(StepStatus.CREATED, "selfie", "dni"))
        val task = Task("id", "39906845", "Loans", "Mango", TaskStatus.DISPATCHED, steps)

        //val taskEntity = ModelMapper.convert(task, TaskEntity::class.java)
        //val taskEntity = KMapper(::TaskEntity).map(task)

        assertEquals(task.hashId, taskEntity.hashId)
    }*/
}