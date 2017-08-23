package gisty.security

import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor
import gisty.domain.model.SocialProfile
import gisty.domain.model.User
import gisty.domain.repository.socialprofile.SocialProfileRepository
import gisty.domain.repository.user.UserRepository
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
        val uid = map.get("sub") as String
        val email = map.get("email") as String
        val name = map.get("name") as String

        var user = userRepository.findByEmail(email)
        if(user == null)
            user = userRepository.findByPrincipalId(uid = uid, provider = provider)
        if (user == null) {
            LOGGER.info("No user found, generating profile for {}", uid)
            user = User(0, name, email)
        }
        val socialProfile = socialProfileRepository.findByUidAndProvider(provider = provider, uid = uid)
        if (socialProfile == null) {
            LOGGER.info("No social profile found, generating profile for {}", uid)
            socialProfileRepository.createSocialProfile(SocialProfile(0, user.id, uid, provider, map))
        }
        return user
    }
}