package gisty.domain.model

import com.fasterxml.jackson.databind.ObjectMapper
import java.time.LocalDateTime

class SocialProfile(id: Int, userId: Int, uid: String, provider: String, email: String, auth: LinkedHashMap<String, Any>) {
    var id: Int = id
    var userId: Int = userId
    var uid: String = uid
    var provider: String = provider
    var email: String = email
    var auth: String = ObjectMapper().writeValueAsString(auth)
    var updatedDatetime: LocalDateTime = LocalDateTime.now()
    var createdDatetime: LocalDateTime = LocalDateTime.now()
}