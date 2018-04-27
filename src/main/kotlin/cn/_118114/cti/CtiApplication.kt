package cn._118114.cti

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@EnableScheduling
class CtiApplication

    fun main(args: Array<String>) {
        runApplication<CtiApplication>(*args)
    }




