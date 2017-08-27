package gisty.security

import gisty.domain.repository.socialprofile.SocialProfileRepository
import gisty.domain.repository.user.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import javax.servlet.ServletException
import java.io.IOException
import javax.servlet.http.HttpServletResponse
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import org.springframework.security.web.DefaultRedirectStrategy


@Component
class SocialAuthenticationSuccessHandler : AuthenticationSuccessHandler {
    @Autowired
    lateinit private var userRepository: UserRepository
    @Autowired
    lateinit private var socialProfileRepository: SocialProfileRepository

    private val redirectStrategy = DefaultRedirectStrategy()


    @Throws(IOException::class, ServletException::class)
    override fun onAuthenticationSuccess(req: HttpServletRequest, res: HttpServletResponse, auth: Authentication) {
        redirectStrategy.sendRedirect(req, res, "/documents")
    }
}