package cn._118114.cti.web

import cn._118114.cti.entity.User
import com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER
import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import  org.springframework.security.core.context.SecurityContextHolder.getContext

/**
 * Created by R2D2 on 2018/4/24.
 * desc:
 */
@Controller

class BaseController{
    @GetMapping("/login")
    fun login(model:Model):String{
        val auth = SecurityContextHolder.getContext().authentication
        LOGGER.info("auth:$auth")
        //如果匿名
        if (auth is AnonymousAuthenticationToken) {
            model.addAttribute("title", "欢迎登陆.....")
            return "/login"
        } else {

            val userinfo = getContext().authentication.principal as? User
            LOGGER.info("userinfo:$userinfo")
            println(userinfo?.userName)


            return "redirect:/"

        }

    }

    @RequestMapping("")
    fun index(model:Model):String{
        return "/index"
    }
}