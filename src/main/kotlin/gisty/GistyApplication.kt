package gisty

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class GistyApplication

fun main(args: Array<String>) {
    SpringApplication.run(GistyApplication::class.java, *args)
}
