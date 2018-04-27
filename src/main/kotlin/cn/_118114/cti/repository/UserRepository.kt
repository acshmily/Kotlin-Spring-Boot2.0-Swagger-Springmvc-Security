package cn._118114.cti.repository

import cn._118114.cti.entity.User
import org.springframework.data.jpa.repository.JpaRepository

import org.springframework.stereotype.Repository

/**
 * Created by R2D2 on 2018/4/23.
 * desc:
 */
@Repository
interface UserRepository :JpaRepository<User,Long>{
    fun findByUserName(userName:String):User?
}