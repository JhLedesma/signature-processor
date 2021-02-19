package com.wenance.signatureprocessor.application.config

import com.wenance.signatureprocessor.repository.dao.StepDao
import com.wenance.signatureprocessor.repository.dao.TaskDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@ComponentScan(basePackages = ["com.wenance.signatureprocessor"])
@EnableAutoConfiguration
@EnableR2dbcRepositories(basePackages = ["com.wenance.signatureprocessor.repository"])
class SpringConfig(@Autowired val stepDao: StepDao, @Autowired val taskDao: TaskDao) {
}
