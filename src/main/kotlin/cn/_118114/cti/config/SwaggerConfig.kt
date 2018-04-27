package cn._118114.cti.config

import com.sun.xml.internal.ws.spi.db.BindingContextFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * Created by R2D2 on 2018/4/23.
 * desc:
 */
@EnableSwagger2
@Configuration
class SwaggerConfig{
    @Value("\${swagger.enable}")
    lateinit var enableSwagger:String
    @Value("\${swagger.builder.title}")
    lateinit var title:String
    @Value("\${swagger.builder.description}")
    lateinit var description:String
    @Value("\${swagger.builder.termsOfServiceUrl}")
    lateinit var termsOfServiceUrl:String
    @Value("\${swagger.builder.version}")
    lateinit var version:String
    @Bean
    fun api(): Docket {
        BindingContextFactory.LOGGER.info("enableSwagger:$enableSwagger")
        return Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).enable(enableSwagger.toBoolean())
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn._118114.cti.api"))
                .paths(PathSelectors.any())
                .build()
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title(title)
                .description(description)
                .termsOfServiceUrl(termsOfServiceUrl)
                .version(version)
                .build()
    }
}