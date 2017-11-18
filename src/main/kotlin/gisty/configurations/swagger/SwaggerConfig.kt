package gisty.configurations.swagger

import com.google.common.base.Predicate
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

import com.google.common.base.Predicates.*
import springfox.documentation.service.*
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.swagger.web.ApiKeyVehicle
import springfox.documentation.swagger.web.SecurityConfiguration


@Configuration
@EnableSwagger2
class SwaggerConfig {

    @Bean
    fun document(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                  .paths(paths())
                  .build()
                .securitySchemes(listOf(apiKey()))
                .securityContexts(listOf(securityContext()))
                .apiInfo(apiInfo())
    }

    private fun apiKey(): ApiKey = ApiKey("mykey", "api_key", "header")

    private fun securityContext(): SecurityContext {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/anyPath.*"))
                .build()
    }


    private fun defaultAuth(): List<SecurityReference> {
        val authorizationScope: AuthorizationScope = AuthorizationScope("global", "accessEverything")
        val authorizationScopes = arrayOf(authorizationScope)
        return listOf(SecurityReference("mykey", authorizationScopes));
    }


    @Bean
    fun security(): SecurityConfiguration {
        return SecurityConfiguration(
                "test-app-client-id",
                "test-app-client-secret",
                "test-app-realm",
                "test-app",
                "apiKey",
                ApiKeyVehicle.HEADER,
                "api_key",
                ","
                /*scope separator*/)
    }


    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("Example API")
                .version("1.0")
                .build()
    }

    private fun paths(): Predicate<String> = or(containsPattern("/api*"))
}