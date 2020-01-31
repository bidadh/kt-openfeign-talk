package com.ericsson.clc.samples.kt.openfeign.client.openfeign

import com.ericsson.clc.samples.kt.openfeign.client.model.Person
import feign.auth.BasicAuthRequestInterceptor
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(name = "kt-server", configuration = [PersonClientConfiguration::class])
interface PersonClient {
  @GetMapping("/all")
  fun fetchAll(): List<Person>

  @PostMapping("/save")
  fun save(person: Person): Person
}

class PersonClientConfiguration {
  @Bean
  fun basicAuthRequestInterceptor(): BasicAuthRequestInterceptor {
    return BasicAuthRequestInterceptor("user", "pass")
  }
}