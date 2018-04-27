package cn._118114.cti.api

import io.swagger.annotations.Api
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by R2D2 on 2018/4/23.
 * desc:
 */
@Api
@RestController
@RequestMapping("/api/test")
class TestRestController{
    @RequestMapping("",method = [RequestMethod.GET])
    fun test():String {
        return "1"
    }
}