package gyst.domains.user

import gyst.domains.DateTime
import gyst.support.EmptyIdentifier
import gyst.support.PersistedIdentifier

data class User(
        val id: UserId,
        val name: UserName,
        val email: UserEmail,
        val updatedDatetime: DateTime,
        val createdDateTime: DateTime
)

interface UserId {
    val value: Int
    companion object {
        operator fun invoke(value: Int): DefinedUserId {
            return DefinedUserId(value)
        }
    }
}

data class DefinedUserId(override val value: Int): UserId, PersistedIdentifier<Int>(value)
class EmptyUserId: EmptyIdentifier(), UserId

data class UserName(val value: String)
data class UserEmail(val value: String)
