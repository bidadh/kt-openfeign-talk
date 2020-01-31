package com.ericsson.clc.samples.kt.openfeign.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KtServerApplication

fun main(args: Array<String>) {
	runApplication<KtServerApplication>(*args)
}
