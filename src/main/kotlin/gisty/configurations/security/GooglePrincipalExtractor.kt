package gisty.configurations.security

import gisty.domains.socialprofile.SocialProfileRepository
import gisty.domains.user.UserRepository
import gisty.services.user.AuthenticationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class GooglePrincipalExtractor(authenticationService: AuthenticationService) : OAuthPrincipalExtractor(authenticationService) {
    override val provider = "google"
}