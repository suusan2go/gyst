package gisty.domain.model

class SocialProfile(id: Int, userId: Int, uid: String, provider: String, email: String) {
    public var id: Int = 0
    public var userId: Int = 0
    public var uid: String = ""
    public var provider: String = ""
    public var email: String = ""
}