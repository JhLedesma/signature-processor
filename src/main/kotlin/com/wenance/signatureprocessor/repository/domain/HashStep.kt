package com.wenance.signatureprocessor.repository.domain

import javax.persistence.*

@Entity
@DiscriminatorValue(value="HASH")
open class HashStep : Step() {

    @Column(name = "url_selfie")
    open var urlSelfie: String? = null

    @Column(name = "hash_value")
    open var hashValue: String? = null
}