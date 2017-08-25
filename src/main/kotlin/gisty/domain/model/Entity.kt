package gisty.domain.model

import java.time.LocalDateTime

open class Entity {
    lateinit var updatedDatetime: LocalDateTime
    lateinit var createdDatetime: LocalDateTime
}