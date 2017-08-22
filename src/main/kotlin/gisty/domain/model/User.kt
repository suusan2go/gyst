package gisty.domain.model

import java.io.Serializable
import java.time.LocalDateTime

class User(id: Int, name: String, email: String): Serializable {
    var id: Int = id
    var name: String = name
    var email: String = email
    var updatedDatetime: LocalDateTime = LocalDateTime.now()
    var createdDatetime: LocalDateTime = LocalDateTime.now()
}