package cn._118114.cti

import cn._118114.cti.entity.Role
import cn._118114.cti.entity.User
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.PostConstruct
import cn._118114.cti.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import java.util.*
import javax.annotation.Resource


@RunWith(SpringRunner::class)
@SpringBootTest
class CtiApplicationTests {

	@Test
	fun contextLoads() {

	}

	@Resource
	lateinit var passwordEncoder: BCryptPasswordEncoder

	@Resource
	lateinit var userRepository: UserRepository

	@PostConstruct
	fun init() {
		var user = User(
				id = null,
				userName = "root",
				passWord = BCryptPasswordEncoder().encode("root"),
				realName = "root",
				roles = arrayListOf(Role(roleName = "ROLE_ADMIN",roleId = 0), Role(roleId = 0,roleName = "ROLE_USER")),
				createTime = Date(),
				updateTime =  Date()
		)
		if (userRepository!!.findByUserName(user.userName!!) == null){
			userRepository.save(user)
		}
	}


}
