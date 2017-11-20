package gyst.domains.user

import gyst.domains.socialprofile.SocialProfile

interface UserRepository {
    fun findById(id: UserId): User?

    fun findByEmail(email: UserEmail): User?

    fun findBySocialProfile(socialProfile: SocialProfile): User?

    fun createUser(user: User): User
}