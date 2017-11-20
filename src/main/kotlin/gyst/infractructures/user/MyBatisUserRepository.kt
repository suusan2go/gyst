package gyst.infractructures.user

import gyst.domains.DateTime
import gyst.domains.socialprofile.SocialProfile
import gyst.domains.user.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class MyBatisUserRepository(@Autowired private val userMapper: UserMapper): UserRepository {
    override fun createUser(user: User): User {
        val record = UserRecord(
                user.id.value,
                user.name.value,
                user.email.value,
                user.updatedDatetime.value,
                user.createdDateTime.value
        )
        userMapper.createUser(record)
        return recordToUser(record)
    }

    override fun findByEmail(email: UserEmail): User? {
        val record = userMapper.findByEmail(email.value)
        return record?.let {
            recordToUser(it)
        }
    }

    override fun findById(id: UserId): User? {
        val record = userMapper.findById(id.value)
        return record?.let {
            recordToUser(it)
        }
    }

    override fun findBySocialProfile(socialProfile: SocialProfile): User? {
        val record = userMapper.findByPrincipalId(uid = socialProfile.uid.value, provider = socialProfile.provider.typeName())
        return record?.let {
            recordToUser(it)
        }
    }

    private fun recordToUser(record: UserRecord): User {
        return User(
                UserId(record.id!!),
                UserName(record.name),
                UserEmail(record.email),
                DateTime(record.updatedDatetime),
                DateTime(record.createdDatetime)
        )
    }
}