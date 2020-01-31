package com.ericsson.clc.samples.kt.openfeign.client

import org.springframework.boot.runApplication
import org.springframework.cloud.client.SpringCloudApplication

@SpringCloudApplication
class KtClientApplication

fun main(args: Array<String>) {
	runApplication<KtClientApplication>(*args)
}
