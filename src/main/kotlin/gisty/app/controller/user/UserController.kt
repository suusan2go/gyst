package gisty.app.controller.user

import gisty.app.controller.ApiController
import gisty.domain.model.User
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController: ApiController() {
    @RequestMapping("/user")
    fun user(@AuthenticationPrincipal principal: User) : User {
        return principal
    }
}
