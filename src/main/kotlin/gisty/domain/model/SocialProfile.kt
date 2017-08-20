package gisty.domain.model

import java.time.LocalDateTime

class SocialProfile(id: Int, userId: Int, uid: String, provider: String, email: String) {
    public var id: Int = 0
    public var userId: Int = 0
    public var uid: String = ""
    public var provider: String = ""
    public var email: String = ""
    public var updated_datetime: LocalDateTime = LocalDateTime.now()
    public var created_datetime: LocalDateTime = LocalDateTime.now()
}