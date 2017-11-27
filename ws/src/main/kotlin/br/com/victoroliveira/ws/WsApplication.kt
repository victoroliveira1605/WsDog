package br.com.victoroliveira.ws

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class WsApplication

fun main(args: Array<String>) {
    SpringApplication.run(WsApplication::class.java, *args)
}
