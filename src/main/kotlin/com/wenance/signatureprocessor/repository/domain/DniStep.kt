package com.wenance.signatureprocessor.repository.domain

import javax.persistence.*

@Entity
@DiscriminatorValue(value="DNI")
open class DniStep : Step() {

    @Column(name = "url_dni")
    open var urlDni: String? = null

    @Column(name = "url_dni_back")
    open var urlDniBack: String? = null
}