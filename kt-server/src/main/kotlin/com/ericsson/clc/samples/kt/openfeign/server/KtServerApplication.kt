package com.ericsson.clc.samples.kt.openfeign.server

import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.TypeAlias
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.http.MediaType
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class KtServerApplication

fun main(args: Array<String>) {
	runApplication<KtServerApplication>(*args)
}

@RestController
@RequiredArgsConstructor
class PersonController @Autowired constructor(private var repository: PersonRepository) {
	@GetMapping("/all", produces = [MediaType.APPLICATION_JSON_VALUE])
	fun all(): List<Person> = repository.findAll()

	@PostMapping("/save", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
	fun save(@RequestBody person: Person): Person {
		return repository.save(person)
	}
}

@Repository
interface PersonRepository : MongoRepository<Person, String>

@Document
@TypeAlias("person")
data class Person(val name: String, val email: String) {
	@Id
	var id: String? = null
}
