package gisty.infractructures.socialprofile

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import java.time.LocalDateTime

data class SocialProfileRecord(
        var id: Int? = null,
        val userId: Int = 0,
        val uid: String = "",
        val provider: String = "",
        val auth: String = "",
        val updatedDatetime: LocalDateTime = LocalDateTime.now(),
        val createdDatetime: LocalDateTime = LocalDateTime.now()
)

@Mapper
interface SocialProfileMapper {
    @Select("""
            SELECT id, user_id, uid, provider, auth::text, updated_datetime, created_datetime FROM social_profiles
            WHERE provider = #{provider} AND uid = #{uid}
            """
    )
    fun findByUidAndProvider(uid: String, provider: String): SocialProfileRecord?

    @Insert("""
            INSERT INTO social_profiles (user_id, uid, provider, auth, updated_datetime, created_datetime)
    VALUES(#{userId}, #{uid}, #{provider}, to_json(#{auth}::json), #{updatedDatetime}, #{createdDatetime})
            """
    )
    fun createSocialProfile(socialProfileRecord: SocialProfileRecord)
}
