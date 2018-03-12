package com.cat.simkot

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.core.ParameterizedTypeReference
import org.springframework.hateoas.Resources
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringRunner


inline fun <reified T : Any> typeRef(): ParameterizedTypeReference<T> = object : ParameterizedTypeReference<T>() {}

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class SimkotApplicationTests {

    @Autowired
    lateinit var webClient: TestRestTemplate

    @Test
    fun contextLoads() {
        val cats: ResponseEntity<Resources<Cat>> = webClient.getForEntity("/cats", typeRef<Resources<Cat>>())
        assertThat(cats.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(cats.body!!.content.size).isEqualTo(3)
    }

}
