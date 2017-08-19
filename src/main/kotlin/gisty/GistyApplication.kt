package gisty

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@EnableOAuth2Sso
@RestController
class GistyApplication

fun main(args: Array<String>) {
    SpringApplication.run(GistyApplication::class.java, *args)
}

