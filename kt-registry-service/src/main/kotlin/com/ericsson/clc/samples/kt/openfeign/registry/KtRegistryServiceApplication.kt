package com.ericsson.clc.samples.kt.openfeign.registry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
class KtRegistryServiceApplication

fun main(args: Array<String>) {
	runApplication<KtRegistryServiceApplication>(*args)
}
