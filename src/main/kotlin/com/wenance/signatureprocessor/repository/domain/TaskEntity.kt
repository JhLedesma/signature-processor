package com.wenance.signatureprocessor.repository.domain

import com.wenance.signatureprocessor.core.model.TaskStatus
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "task")
open class TaskEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    open var id: Long? = null

    @Column(name = "hash_id")
    open var hashId: String? = null

    @Column(name = "dni")
    open var dni: String? = null

    @Column(name = "task_status")
    @Enumerated(EnumType.STRING)
    open var status: TaskStatus? = null

    @Column(name = "product_entity")
    open var productEntity: String? = null

    @Column(name = "product_type")
    open var productType: String? = null

    @Column(name = "creation_date")
    @CreationTimestamp
    open var creationDate: LocalDateTime? = null

    @Column(name = "update_date")
    @UpdateTimestamp
    open var updateDate: LocalDateTime? = null

    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "task")
    open var stepEntities: Set<StepEntity> = emptySet()
}