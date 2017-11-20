package gyst.services.user

import gyst.domains.DateTime
import gyst.domains.socialprofile.SocialProfile
import gyst.domains.socialprofile.SocialProfileRepository
import gyst.domains.user.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
        @Autowired val userRepository: UserRepository,
        @Autowired val socialProfileRepository: SocialProfileRepository)
{
    fun authenticate(userEmail: UserEmail, userName: UserName, socialProfile: SocialProfile): User {
        val user = userRepository.findByEmail(userEmail)
                ?: userRepository.findBySocialProfile(socialProfile)
                ?: userRepository.createUser(User(EmptyUserId(), userName, userEmail, DateTime.current(), DateTime.current()))
        socialProfileRepository.findByUidAndProvider(socialProfile.uid, socialProfile.provider) ?:
                socialProfileRepository.createSocialProfile(socialProfile.copy(userId = user.id))
        return user
    }
}