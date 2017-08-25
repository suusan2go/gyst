package gisty.domain.repository.user

import gisty.domain.model.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository

@Mapper
interface UserRepository {
    @Select("SELECT * FROM users WHERE id = #{id}")
    fun findById(id: Int): User?

    @Select("SELECT * FROM users WHERE email = #{email}")
    fun findByEmail(email: String): User?

    @Select("""
        SELECT users.* FROM users
        JOIN social_profiles ON social_profiles.user_id = users.id
        WHERE provider = #{provider} AND uid = #{uid}
        """
    )
    fun findByPrincipalId(uid: String, provider: String): User?

    @Insert("""
        INSERT INTO users (name, email, updated_datetime, created_datetime) VALUES (#{name}, #{email}, #{updatedDatetime}, #{createdDatetime})
        """
    )
    @Options(useGeneratedKeys=true, keyProperty="id")
    fun createUser(user: User)
}