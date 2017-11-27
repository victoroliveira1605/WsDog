package br.com.victoroliveira.ws

import org.springframework.data.repository.CrudRepository

interface DogRepository : CrudRepository<Dog, Long>