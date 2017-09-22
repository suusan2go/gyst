package gisty.configurations.security

import gisty.domains.socialprofile.SocialProfileRepository
import gisty.domains.user.UserRepository
import org.springframework.stereotype.Component

@Component
class GooglePrincipalExtractor(userRepository: UserRepository,
                               socialProfileRepository: SocialProfileRepository):
        OAuthPrincipalExtractor(userRepository, socialProfileRepository) {
    override val provider = "google"
}