package com.wenance.signatureprocessor.repository

import com.wenance.signatureprocessor.core.model.Step

interface StepRepository {

    fun findById(id: String): Step?
}