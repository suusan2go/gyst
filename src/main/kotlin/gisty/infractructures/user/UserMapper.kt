package gisty.infractructures.user

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Select
import java.time.LocalDateTime

data class UserRecord(
        var id: Int?,
        val name: String,
        val email: String,
        val updatedDateTime: LocalDateTime,
        val createdDateTime: LocalDateTime
)

@Mapper
interface UserMapper {
    @Select("SELECT * FROM users WHERE id = #{id}")
    fun findById(id: Int): UserRecord?

    @Select("SELECT * FROM users WHERE email = #{email}")
    fun findByEmail(email: String): UserRecord?

    @Select("""
        SELECT users.* FROM users
        JOIN social_profiles ON social_profiles.user_id = users.id
        WHERE provider = #{provider} AND uid = #{uid}
        """
    )
    fun findByPrincipalId(uid: String, provider: String): UserRecord?

    @Insert("""
        INSERT INTO users (name, email, updated_datetime, created_datetime) VALUES (#{name}, #{email}, #{updatedDatetime}, #{createdDatetime})
        """
    )
    @Options(useGeneratedKeys=true, keyProperty="id")
    fun createUser(userRecord: UserRecord)
}