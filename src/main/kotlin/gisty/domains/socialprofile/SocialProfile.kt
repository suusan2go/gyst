package gisty.domains.socialprofile

import com.fasterxml.jackson.databind.ObjectMapper
import gisty.domains.DateTime
import gisty.domains.user.EmptyUserId
import gisty.domains.user.UserId
import gisty.support.EmptyIdentifier
import gisty.support.PersistedIdentifier

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
                    EmptySocialProfileId(),
                    EmptyUserId(),
                    SocialProfileUid(uid),
                    SocialProfileProvider(providerName),
                    SocialProfileAuth(auth),
                    DateTime.current(),
                    DateTime.current()
            )
        }
    }
}

interface SocialProfileId { val value: Int }
data class DefinedSocialProfileId(override val value: Int): SocialProfileId, PersistedIdentifier<Int>(value)
class EmptySocialProfileId: SocialProfileId, EmptyIdentifier()
data class SocialProfileUid(val value: String)
data class SocialProfileAuth(val value: String){
    constructor(auth: Map<String, Any>): this(ObjectMapper().writeValueAsString(auth))
}
