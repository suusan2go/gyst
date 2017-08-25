package gisty.app.controller.user

import gisty.domain.model.User
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.Mapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class UserController {
    @RequestMapping("/user")
    fun user(@AuthenticationPrincipal principal: User) : User {
        return principal
    }
}
