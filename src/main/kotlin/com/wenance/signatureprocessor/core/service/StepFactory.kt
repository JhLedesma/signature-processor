package com.wenance.signatureprocessor.core.service

import com.wenance.signatureprocessor.client.AzureClient
import com.wenance.signatureprocessor.core.model.*

class StepFactory(val azureClient: AzureClient) {

/*    fun createStep(stepTypeName: StepTypeName, hashId: String): Step {
        return when (stepTypeName) {
            StepTypeName.FOTO -> createSelfieStep(hashId)
            StepTypeName.HASH -> createHashStep(hashId)
            StepTypeName.DNI -> createDniStep(hashId)
        }
    }

    private fun createSelfieStep(hashId: String): SelfieStep = SelfieStep(StepStatus.CREATED, azureClient.fetchSelfie(hashId), azureClient.fetchDni(hashId))

    private fun createHashStep(hashId: String): HashStep = HashStep(StepStatus.CREATED, azureClient.fetchSelfie(hashId), azureClient.fetchSelfieHash(hashId))

    private fun createDniStep(hashId: String): DniStep = DniStep(StepStatus.CREATED, azureClient.fetchDni(hashId), azureClient.fetchDniBack(hashId))*/
}