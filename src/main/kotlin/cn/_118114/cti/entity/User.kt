package cn._118114.cti.entity

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*
import javax.persistence.*

/**
 * Created by R2D2 on 2018/4/23.
 * desc:用户信息表 ,用username单一唯一
 */
@Entity
@Table(uniqueConstraints=[UniqueConstraint(columnNames=["userName"])])
class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id:Long? = 0,//主键
        @Column(nullable = false)
        var userName:String ="",//用户名
        @Column(nullable = false)
        var passWord:String ="",//密码
        @Column(nullable = false)
        var realName:String = "",//真实姓名
        @Column(name = "create_time")
        @CreatedDate
        var createTime:Date = Date(),//创建时候填入的时间戳
        @Column(name ="update_time")
        @LastModifiedDate
        var updateTime:Date = Date(),//更新时的时间戳
        @ManyToMany( fetch = FetchType.EAGER,cascade = [CascadeType.MERGE, CascadeType.PERSIST])
        @JoinTable(
                name = "users_roles",
                joinColumns = [JoinColumn(name = "user_id", referencedColumnName = "id")],
                inverseJoinColumns = [ JoinColumn(name = "role_id", referencedColumnName = "roleId")])
        var roles:Collection<Role> = arrayListOf()

)