package gyst.controllers.user

import gyst.controllers.ApiController
import gyst.domains.user.User
import gyst.views.UserView
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController: ApiController() {
    @RequestMapping("/user")
    fun user(@AuthenticationPrincipal principal: User) : UserView {
        return UserView(principal)
    }
}
