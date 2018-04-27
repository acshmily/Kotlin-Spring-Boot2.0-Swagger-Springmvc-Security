package cn._118114.cti.entity

import javax.persistence.*

/**
 * Created by R2D2 on 2018/4/23.
 * desc:用户角色表 User Enity
 */
@Entity
@Table(uniqueConstraints=[(UniqueConstraint(columnNames = ["roleId"]))])
data class Role(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var roleId:Long = 0,
    @Column(nullable = false)
    var roleName:String = ""
)
