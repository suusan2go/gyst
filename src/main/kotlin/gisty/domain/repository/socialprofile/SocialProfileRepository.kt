package gisty.domain.repository.socialprofile

import gisty.domain.model.SocialProfile
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface SocialProfileRepository {
    @Select("""
        SELECT * FROM social_profiles
        where provider = 'google' AND uid = #{uid}
        """
    )
    fun findByUid(uid: String): SocialProfile;

    @Insert("""
        INSERT INTO social_profiles (user_id, uid, provider, auth, updated_datetime, created_datetime)
        VALUES(#{userId}, #{uid}, 'google', to_json(#{auth}::json), #{updatedDatetime},#{createdDatetime})
        """
    )
    fun createSocialProfile(socialProfile: SocialProfile);
}