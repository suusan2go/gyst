package gisty

import gisty.configurations.security.GooglePrincipalExtractor
import gisty.configurations.security.SocialAuthenticationSuccessHandler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Primary
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.oauth2.client.OAuth2ClientContext
import org.springframework.security.oauth2.client.OAuth2RestTemplate
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import org.springframework.security.web.csrf.CookieCsrfTokenRepository
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import org.springframework.web.bind.annotation.RestController
import javax.servlet.Filter


@SpringBootApplication
@EnableOAuth2Sso
@RestController
class GistyApplication: WebSecurityConfigurerAdapter() {
    @Autowired
    lateinit var oauth2ClientContext: OAuth2ClientContext
    @Autowired
    lateinit var socialAuthenticationSuccessHandler: SocialAuthenticationSuccessHandler
    @Autowired
    lateinit private var googlePrincipalExtractor: GooglePrincipalExtractor

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**", "/assets**")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .addFilterBefore(ssoFilter(), BasicAuthenticationFilter::class.java)
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .logout()
                .logoutRequestMatcher(AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .permitAll()

    }

    private fun ssoFilter(): Filter {
        val googleFilter = OAuth2ClientAuthenticationProcessingFilter("/login/google")
        val googleTemplate = OAuth2RestTemplate(google(), oauth2ClientContext)
        googleFilter.setRestTemplate(googleTemplate)
        val tokenServices = UserInfoTokenServices(googleResource().userInfoUri, google().clientId)
        tokenServices.setPrincipalExtractor(googlePrincipalExtractor)
        tokenServices.setRestTemplate(googleTemplate)
        googleFilter.setTokenServices(tokenServices)
        googleFilter.setAuthenticationSuccessHandler(socialAuthenticationSuccessHandler)
        return googleFilter
    }

    @Bean
    @ConfigurationProperties("google.client")
    fun google(): AuthorizationCodeResourceDetails {
        return AuthorizationCodeResourceDetails()
    }

    @Primary
    @Bean
    @ConfigurationProperties("google.resource")
    fun googleResource(): ResourceServerProperties {
        return ResourceServerProperties()
    }

    @Bean
    fun oauth2ClientFilterRegistration(
            filter: OAuth2ClientContextFilter): FilterRegistrationBean {
        val registration = FilterRegistrationBean()
        registration.filter = filter
        registration.order = -100
        return registration
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(GistyApplication::class.java, *args)
}

