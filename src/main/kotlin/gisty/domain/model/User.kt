package gisty.domain.model

import java.io.Serializable
import java.time.LocalDateTime

class User: Serializable {
    var id: Int = 0
    lateinit var name: String
    lateinit var email: String
    lateinit var updated_datetime: LocalDateTime
    lateinit var created_datetime: LocalDateTime

    constructor(id: Int, name: String, email: String) {
        this.id = id
        this.name = name
        this.email = email
        this.updated_datetime = LocalDateTime.now()
        this.created_datetime = LocalDateTime.now()
    }

    private constructor(): super() {}
}