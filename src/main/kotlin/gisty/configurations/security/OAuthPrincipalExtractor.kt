package gisty.configurations.security

import gisty.domains.DateTime
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor
import gisty.domains.socialprofile.SocialProfile
import gisty.domains.socialprofile.SocialProfileRepository
import gisty.domains.user.*
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration


open class OAuthPrincipalExtractor @Autowired constructor(
        userRepository: UserRepository, socialProfileRepository: SocialProfileRepository) : PrincipalExtractor {
    private val LOGGER = LoggerFactory.getLogger(WebSecurityConfiguration::class.java)

    open val provider = "unknown"

    private val userRepository = userRepository
    private val socialProfileRepository = socialProfileRepository

    override fun extractPrincipal(map: Map<String, Any>): Any {
        val email = UserEmail(map.get("email") as String)
        val name = UserName(map.get("name") as String)
        val socialProfile = SocialProfile.buildFromAuth(map, provider)

        var user = userRepository.findByEmail(email)
                ?: userRepository.findBySocialProfile(socialProfile)
                ?: userRepository.createUser(User(UserId(0), name, email, DateTime.current(), DateTime.current()))
        socialProfileRepository.findByUidAndProvider(socialProfile.uid, socialProfile.provider) ?:
            LOGGER.info("No social profile found, generating profile for {}", socialProfile)
            socialProfileRepository.createSocialProfile(socialProfile.copy(userId =  user.id))
        return user
    }
}