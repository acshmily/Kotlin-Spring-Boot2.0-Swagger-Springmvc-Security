package cn._118114.cti.config

import cn._118114.cti.service.UserService
import com.zaxxer.hikari.HikariDataSource
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import javax.annotation.Resource
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity







/**
 * Created by R2D2 on 2018/4/23.
 * desc:
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableAspectJAutoProxy(proxyTargetClass=true)
class WebSecurityConfig : WebSecurityConfigurerAdapter(){
    @Resource
    lateinit var userService: UserService
    @Resource
    lateinit var dataSource:HikariDataSource

    @Bean
    fun authenticationProvider(): DaoAuthenticationProvider {
        val authenticationProvider = DaoAuthenticationProvider()
        authenticationProvider.setUserDetailsService(userService)
        authenticationProvider.setPasswordEncoder(passwordEncoder())
        return authenticationProvider
    }


    override fun configure(http: HttpSecurity){
        http.authorizeRequests()
                .antMatchers("/js/**", "/css/**", "/img/**", "/images/**","/getVerify/**","/layui/**", "/","/api/**","/swagger-resources/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .permitAll()
                .invalidateHttpSession(true)
                .and()
                .rememberMe()
                .tokenValiditySeconds(864000)
                .tokenRepository(tokenRepository())
    }

    @Bean
    fun passwordEncoder(): BCryptPasswordEncoder {
        return BCryptPasswordEncoder()
    }
    @Bean
    fun tokenRepository(): JdbcTokenRepositoryImpl {
        var j = JdbcTokenRepositoryImpl()
        //j.setCreateTableOnStartup(true)
        j.setDataSource(dataSource)
        return j
    }

}