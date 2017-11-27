package br.com.victoroliveira.ws

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("dog")
class DogController {

    @Autowired
    lateinit var dogRepository: DogRepository

    @GetMapping
    @ResponseBody
    fun list(): List<Dog> {
        return dogRepository.findAll().toList()
    }

    @PostMapping
    fun add(@RequestBody dog: Dog): ResponseEntity<Unit> {
        try {
            dogRepository.save(dog)
            return ResponseEntity.ok().build()
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dog: Dog): ResponseEntity<Unit> {
        try {
            if (dogRepository.exists(id)) {
                val safeDog = dog.copy(id)
                dogRepository.save(safeDog)
                return ResponseEntity.ok().build()
            } else {
                dogRepository.save(dog)
            }
            return ResponseEntity.ok().build()
        } catch (e: Exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build()
        }
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit> {
        try {
            if (!dogRepository.exists(id)) {
                return ResponseEntity.notFound().build()
            } else {
                dogRepository.delete(id)
            }
            return ResponseEntity.ok().build()
        } catch (e: Exception) {
            return ResponseEntity.notFound().build()
        }
    }
}