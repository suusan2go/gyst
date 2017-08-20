package gisty.domain.model

import java.io.Serializable
import java.time.LocalDateTime

class User(id: Int, name: String): Serializable {
    public var id: Int = 0
    public var name: String = ""
    public var updated_datetime: LocalDateTime = LocalDateTime.now()
    public var created_datetime: LocalDateTime = LocalDateTime.now()
}