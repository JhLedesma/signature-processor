package com.wenance.signatureprocessor.repository.domain

import com.wenance.signatureprocessor.core.model.StepStatus
import com.wenance.signatureprocessor.core.model.TaskStatus
import javax.persistence.*

@Entity
@Table(name = "step")
@DiscriminatorColumn(name="type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract class Step {

    @Id
    @GeneratedValue
    @Column(name = "id")
    open var id: Long? = null

    @Column(name = "step_status")
    @Enumerated(EnumType.STRING)
    open var status: StepStatus? = null

    @ManyToOne
    @JoinColumn(name = "tarea_id")
    open var task: Task? = null
}