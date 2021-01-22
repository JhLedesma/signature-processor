package com.wenance.signatureprocessor.client

import com.microsoft.azure.storage.CloudStorageAccount
import com.microsoft.azure.storage.StorageException
import com.microsoft.azure.storage.blob.CloudBlockBlob
import java.net.URISyntaxException


class AzureClient(
    val azureBase: String,
    val azureSelfieName: String,
    val azureFirmaName: String,
    val azureDNIName: String,
    val azureDNIBackName: String,
    val azureSelfieHashName: String,
    val containerName: String,
    val cloudStorageAccount: CloudStorageAccount
) {

    fun fetchDni(folderHash: String): String {
        return fetch(folderHash, azureDNIName)
    }

    fun fetchDniBack(folderHash: String): String {
        return fetch(folderHash, azureDNIBackName)
    }

    fun fetchSignature(folderHash: String): String {
        return fetch(folderHash, azureFirmaName)
    }

    fun fetchSelfie(folderHash: String): String {
        return fetch(folderHash, azureSelfieName)
    }

    fun fetchSelfieHash(folderHash: String): String {
        return try {
            getCloudBlockBlob(folderHash, azureSelfieHashName).downloadText()
        } catch (e: Exception) {
            //log.error("ERROR fetch File | File Name $azureSelfieHashName | Container: $azureBase | Directory Name: $folderHash")
            throw e
        }
    }

    private fun fetch(folderHash: String, fileName: String): String {
        return "$azureBase$folderHash/$fileName"
    }

    @Throws(URISyntaxException::class, StorageException::class)
    private fun getCloudBlockBlob(hashId: String?, fileName: String): CloudBlockBlob {
        return cloudStorageAccount.createCloudBlobClient() // Create a blob client.
        .getContainerReference(containerName) // Get a reference to a container. (Name must be lower case.)
        .getDirectoryReference(hashId)
        .getBlockBlobReference(fileName)
    }
}