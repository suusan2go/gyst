package gisty.domain.model

import java.time.LocalDateTime

class Document: Entity {
    var id: Int = 0
    var userId: Int = 0
    lateinit var title: String
    lateinit var body: String

    constructor(id: Int, name: String, body: String): this() {
        this.id = id
        this.title = title
        this.body = body
        this.updatedDatetime = LocalDateTime.now()
        this.createdDatetime = LocalDateTime.now()
    }

    private constructor(): super() {}
}