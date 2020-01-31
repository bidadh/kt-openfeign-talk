package com.ericsson.clc.samples.kt.openfeign.client.openfeign

import com.ericsson.clc.samples.kt.openfeign.client.model.Person
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@FeignClient("kt-server")
interface PersonClient {
  @GetMapping("/all")
  fun fetchAll(): List<Person>

  @PostMapping("/save")
  fun save(person: Person): Person
}