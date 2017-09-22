package gisty.infractructures.socialprofile

import gisty.domains.DateTime
import gisty.domains.socialprofile.*
import gisty.domains.user.UserId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class MyBatisSocialProfileRepository(
        @Autowired val socialProfileMapper: SocialProfileMapper
): SocialProfileRepository{
    override fun createSocialProfile(socialProfile: SocialProfile): SocialProfile {
        val record = SocialProfileRecord(
                socialProfile.id.value,
                socialProfile.userId.value,
                socialProfile.uid.value,
                socialProfile.provider.typeName(),
                socialProfile.auth.value,
                socialProfile.updatedDatetime.value,
                socialProfile.createdDateTime.value
        )
        socialProfileMapper.createSocialProfile(record)
        return recordToSocialProfile(record)
    }

    override fun findByUidAndProvider(uid: SocialProfileUid, provider: SocialProfileProvider): SocialProfile? {
        val record = socialProfileMapper.findByUidAndProvider(uid.value, provider.typeName())
        return record?.let{
            recordToSocialProfile(it)
        }
    }

    private fun recordToSocialProfile(record: SocialProfileRecord): SocialProfile {
        return SocialProfile(
                SocialProfileId(record.id),
                UserId(record.userId),
                SocialProfileUid(record.uid),
                SocialProfileProvider.init((record.provider)),
                SocialProfileAuth(record.auth),
                DateTime(record.updatedDateTime),
                DateTime(record.createdDateTime)
        )
    }
}
