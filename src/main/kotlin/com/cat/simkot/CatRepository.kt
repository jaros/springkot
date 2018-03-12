package com.cat.simkot

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource(collectionResourceRel = "cats", path = "cats")
interface CatRepository : CrudRepository<Cat, Long> {
    fun findByName(@Param("name") name: String): List<Cat>
    fun findByAge(@Param("age") age: Int): List<Cat>
}