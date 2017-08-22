package gisty.security

import gisty.domain.model.SocialProfile
import gisty.domain.model.User
import gisty.domain.repository.socialprofile.SocialProfileRepository
import gisty.domain.repository.user.UserRepositroy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.provider.OAuth2Authentication
import javax.servlet.ServletException
import java.io.IOException
import javax.servlet.http.HttpServletResponse
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import org.springframework.security.web.DefaultRedirectStrategy
import org.springframework.security.web.RedirectStrategy



@Component
class SocialAuthenticationSuccessHandler : AuthenticationSuccessHandler {
    @Autowired
    lateinit private var userRepository: UserRepositroy
    @Autowired
    lateinit private var socialProfileRepository: SocialProfileRepository

    private val redirectStrategy = DefaultRedirectStrategy()


    @Throws(IOException::class, ServletException::class)
    override fun onAuthenticationSuccess(req: HttpServletRequest, res: HttpServletResponse, auth: Authentication) {
        val oauth = auth as OAuth2Authentication
        val details = oauth.userAuthentication.details as LinkedHashMap<String, Any>
        val socialProfile = socialProfileRepository.findByUid(details.get("sub") as String)
        if (socialProfile == null) {
            val user = User(0, details["name"] as String, details["email"] as String)
            userRepository.createUser(user)
            socialProfileRepository.createSocialProfile(SocialProfile(
                    0, user.id, details["sub"] as String, "google", details)
            )
        }

        redirectStrategy.sendRedirect(req, res, "/memos")
    }
}