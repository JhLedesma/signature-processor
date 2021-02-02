package com.wenance.signatureprocessor.core.service

import com.wenance.signatureprocessor.client.AzureClient
import com.wenance.signatureprocessor.core.model.*
import com.wenance.signatureprocessor.repository.domain.StepEntity

class StepFactory(val azureClient: AzureClient) {

    fun createStep(stepTypeName: StepTypeName, hashId: String): Step {
        return when (stepTypeName) {
            StepTypeName.FOTO -> createSelfieStep(hashId)
            StepTypeName.HASH -> createHashStep(hashId)
            StepTypeName.DNI -> createDniStep(hashId)
        }
    }

    fun getStep(stepEntity: StepEntity): Step {
        return when (StepTypeName.valueOf(stepEntity.type)) {
            StepTypeName.FOTO -> getSelfieStep(stepEntity)
            StepTypeName.HASH -> getHashStep(stepEntity)
            StepTypeName.DNI -> getDniStep(stepEntity)
        }
    }

    private fun createSelfieStep(hashId: String): SelfieStep = SelfieStep(StepStatus.CREATED, azureClient.fetchSelfie(hashId), azureClient.fetchDni(hashId))

    private fun createHashStep(hashId: String): HashStep = HashStep(StepStatus.CREATED, azureClient.fetchSelfie(hashId), azureClient.fetchSelfieHash(hashId))

    private fun createDniStep(hashId: String): DniStep = DniStep(StepStatus.CREATED, azureClient.fetchDni(hashId), azureClient.fetchDniBack(hashId))

    private fun getSelfieStep(stepEntity: StepEntity): SelfieStep = SelfieStep(StepStatus.valueOf(stepEntity.status), stepEntity.urlSelfie!!, stepEntity.urlDni!!, stepEntity.id)

    private fun getHashStep(stepEntity: StepEntity): HashStep = HashStep(StepStatus.valueOf(stepEntity.status), stepEntity.urlSelfie!!, stepEntity.hashValue!!, stepEntity.id)

    private fun getDniStep(stepEntity: StepEntity): DniStep = DniStep(StepStatus.valueOf(stepEntity.status), stepEntity.urlDni!!, stepEntity.urlDniBack!!, stepEntity.id)
}