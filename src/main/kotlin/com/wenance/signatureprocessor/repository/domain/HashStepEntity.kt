package com.wenance.signatureprocessor.repository.domain

import javax.persistence.*

@Entity
@DiscriminatorValue(value="HASH")
open class HashStepEntity : StepEntity() {

    @Column(name = "url_selfie")
    open var urlSelfie: String? = null

    @Column(name = "hash_value")
    open var hashValue: String? = null
}