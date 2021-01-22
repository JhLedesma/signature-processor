package com.wenance.signatureprocessor.repository.domain

import javax.persistence.Column
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity

@Entity
@DiscriminatorValue(value="SELFIE")
open class SelfieStep : Step() {

    @Column(name = "url_selfie")
    open var urlSelfie: String? = null

    @Column(name = "url_dni")
    open var urlDni: String? = null
}