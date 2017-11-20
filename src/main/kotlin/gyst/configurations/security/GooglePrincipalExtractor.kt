package gyst.configurations.security

import gyst.services.user.AuthenticationService
import org.springframework.stereotype.Component

@Component
class GooglePrincipalExtractor(authenticationService: AuthenticationService) : OAuthPrincipalExtractor(authenticationService) {
    override val provider = "google"
}