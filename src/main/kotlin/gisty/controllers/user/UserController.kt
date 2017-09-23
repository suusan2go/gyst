package gisty.controllers.user

import gisty.controllers.ApiController
import gisty.domains.user.User
import gisty.views.UserView
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
