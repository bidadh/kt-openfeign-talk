package com.ericsson.clc.samples.kt.openfeign.client

import com.ericsson.clc.samples.kt.openfeign.client.model.Person
import com.ericsson.clc.samples.kt.openfeign.client.openfeign.PersonClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.runApplication
import org.springframework.cloud.client.SpringCloudApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@SpringCloudApplication
@EnableFeignClients
class KtClientApplication

fun main(args: Array<String>) {
	runApplication<KtClientApplication>(*args)
}

@RestController
class PersonController @Autowired constructor(private var personClient: PersonClient) {
	@GetMapping("/all", produces = [MediaType.APPLICATION_JSON_VALUE])
	fun all(): List<Person> = personClient.fetchAll()

	@PostMapping("/save", produces = [MediaType.APPLICATION_JSON_VALUE])
	fun save(@RequestBody person: Person): Person = personClient.save(person)
}
