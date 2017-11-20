package gyst.domains.socialprofile

interface SocialProfileRepository {
    fun findByUidAndProvider(uid: SocialProfileUid, provider: SocialProfileProvider): SocialProfile?
    fun createSocialProfile(socialProfile: SocialProfile): SocialProfile
}