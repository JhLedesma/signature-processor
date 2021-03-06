package com.wenance.signatureprocessor.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import java.io.IOException

@SpringBootApplication
@Configuration
@EnableR2dbcRepositories
class SpringRun {

}

fun main(args: Array<String>) {
    runApplication<SpringRun>(*args)
}