package gisty.domains.socialprofile

import com.fasterxml.jackson.databind.ObjectMapper
import gisty.domains.DateTime
import gisty.domains.user.UserId

data class SocialProfile(
        val id: SocialProfileId,
        val userId: UserId,
        val uid: SocialProfileUid,
        val provider: SocialProfileProvider,
        val auth: SocialProfileAuth,
        val updatedDatetime: DateTime,
        val createdDateTime: DateTime
) {
    companion object {
        fun buildFromAuth(auth: Map<String, Any>, providerName: String): SocialProfile {
            val uid = auth.get("sub") as String

            return SocialProfile(
                    SocialProfileId(0),
                    UserId(0),
                    SocialProfileUid(uid),
                    SocialProfileProvider.init(providerName),
                    SocialProfileAuth(auth),
                    DateTime.current(),
                    DateTime.current()
            )
        }
    }
}

data class SocialProfileId(val value: Int)
data class SocialProfileUid(val value: String)
data class SocialProfileAuth(val value: String){
    constructor(auth: Map<String, Any>): this(ObjectMapper().writeValueAsString(auth))
}
