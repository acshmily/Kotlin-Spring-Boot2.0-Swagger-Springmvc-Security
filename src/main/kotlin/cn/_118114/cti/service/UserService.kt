package cn._118114.cti.service

import cn._118114.cti.entity.Role
import cn._118114.cti.entity.User
import cn._118114.cti.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import java.util.stream.Collectors
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.GrantedAuthority
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource


/**
 * Created by R2D2 on 2018/4/23.
 * desc:
 */
@Transactional
@Service
class UserService: UserDetailsService{
    @Resource
    lateinit var userRepository: UserRepository
    override fun loadUserByUsername(username:String): UserDetails {
        var user = userRepository.findByUserName(username)
        if (user == null) {
            throw  UsernameNotFoundException("Invalid username or password.")
        }
        return org.springframework.security.core.userdetails.User(user.userName,
                user.passWord,
                mapRolesToAuthorities(user.roles!!))
    }

    private fun mapRolesToAuthorities(roles: Collection<Role>): Collection<GrantedAuthority> {
        return roles.stream().map { role ->SimpleGrantedAuthority(role.roleName)}.collect(Collectors.toList())
    }
}