package gisty.domain.model

import com.fasterxml.jackson.databind.ObjectMapper
import java.time.LocalDateTime

class SocialProfile {
    var id: Int = 0
    var userId: Int = 0
    lateinit var uid: String
    lateinit var provider: String
    lateinit var auth: String
    lateinit var updatedDatetime: LocalDateTime
    lateinit var createdDatetime: LocalDateTime

    constructor(id: Int, userId: Int, uid: String, provider: String, auth: LinkedHashMap<String, Any>) {
        this.id = id
        this.userId = userId
        this.uid = uid
        this.provider = provider
        this.auth = ObjectMapper().writeValueAsString(auth)
        this.updatedDatetime = LocalDateTime.now()
        this.createdDatetime = LocalDateTime.now()
    }
    private constructor(): super() {}
}