package gyst.configurations.security

import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor
import gyst.domains.socialprofile.SocialProfile
import gyst.domains.user.*
import gyst.services.user.AuthenticationService
import org.springframework.beans.factory.annotation.Autowired


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