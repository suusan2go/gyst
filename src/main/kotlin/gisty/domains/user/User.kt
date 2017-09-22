package gisty.domains.user

import gisty.domains.DateTime

data class User(
        val id: UserId,
        val name: UserName,
        val email: UserEmail,
        val updatedDatetime: DateTime,
        val createdDateTime: DateTime
)

data class UserId(open val value: Int)
data class UserName(val value: String)
data class UserEmail(val value: String)
