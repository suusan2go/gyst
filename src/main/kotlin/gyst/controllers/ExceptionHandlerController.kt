package backend.controller.exceptions

import gyst.exceptions.NotFoundException
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime
import java.time.ZoneOffset.UTC

@ControllerAdvice
class ExceptionHandlerController {

    private val logger = LoggerFactory.getLogger(ExceptionHandlerController::class.java)

    // Used for handling Jackson Parsing Exceptions
    @ExceptionHandler(NotFoundException::class)
    fun handle(e: NotFoundException): ResponseEntity<Map<String, String>> {
        val response = mapOf(
                "timestamp" to LocalDateTime.now().toEpochSecond(UTC).toString(),
                "message" to e.message!!
        )
        return ResponseEntity(response, HttpStatus.BAD_REQUEST)
    }
}
