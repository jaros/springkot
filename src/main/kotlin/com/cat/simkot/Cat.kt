package com.cat.simkot

import javax.persistence.*

@Entity
data class Cat(
        @Id @GeneratedValue
        val id: Long,
        @Column(nullable = false)
        val name: String,
        val age: Int?
) {
}