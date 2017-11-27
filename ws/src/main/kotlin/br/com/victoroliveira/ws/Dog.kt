package br.com.victoroliveira.ws

import com.fasterxml.jackson.annotation.JsonProperty
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Dog(@Id
               @GeneratedValue
               @JsonProperty(value = "id", access = JsonProperty.Access.READ_ONLY)
               val id: Long = 0L,
               val raca: String,
               val idade: Int) {
    constructor() : this(0L, "", 0)
}