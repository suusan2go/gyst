package gisty.configurations.security

import gisty.domains.DateTime
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor
import gisty.domains.socialprofile.SocialProfile
import gisty.domains.socialprofile.SocialProfileRepository
import gisty.domains.user.*
import gisty.services.user.AuthenticationService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration


open class OAuthPrincipalExtractor(
        @Autowired val authenticationService: AuthenticationService
) : PrincipalExtractor {
    open val provider = "unknown"

    override fun extractPrincipal(map: Map<String, Any>): Any {
        val email = UserEmail(map["email"] as String)
        val name = UserName(map["name"] as String)
        val socialProfile = SocialProfile.buildFromAuth(map, provider)
        return authenticationService.authenticate(
                email,
                name,
                socialProfile
        )
    }
}