package gyst.views

import gyst.domains.user.User

data class UserView(
        val id: Int,
        val name: String
) {
    companion object {
        operator fun invoke(user: User): UserView {
            return UserView(
                    user.id.value,
                    user.name.value
            )
        }
    }
}