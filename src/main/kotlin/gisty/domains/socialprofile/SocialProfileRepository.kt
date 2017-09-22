package gisty.domains.socialprofile

import gisty.domains.socialprofile.SocialProfile
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

interface SocialProfileRepository {
    fun findByUidAndProvider(uid: SocialProfileUid, provider: SocialProfileProvider): SocialProfile?
    fun createSocialProfile(socialProfile: SocialProfile): SocialProfile
}