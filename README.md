# Kotlin-Spring-Boot2.0-Swagger-Springmvc-Security
code by Koltin to build Spring Boot Web Application[这是一个基于Spring Boot开发的一个快速部署项目,适合SpringMVC Web项目]

##开发环境要求:
IDE环境 java8 kotlin1.2 Maven
##依赖:
*   Spring Boot2.0
*   SpringMVC
*   SpringSecurity
*   SpringJPA
*   HikariCP DataSource
*   Thymeleaf
*   ...
##使用说明
*   请仔细阅读项目内的application.properties文件修改为仔细需要的配置
*   对于Spring Security配置请参考config包下WebSecurity.kt配置
*   对于SwaggerAPI文档输出常用设置已在配置文件(application.properties)中配置,如需要其他需求请参考config包下SwaggerConfig.kt
*   API声明方法样例在api包内
*   JPA声明在entity包内
*   JPA接口定义在repository包内
*   Service类在service包内
*   普通View输出类在web包内
*   CtiApplication.kt为本项目的入口
##关于授权(license)
    DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
                   Version 2, December 2004

Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>

Everyone is permitted to copy and distribute verbatim or modified
copies of this license document, and changing it is allowed as long
as the name is changed.

           DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
  TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION

 0. You just DO WHAT THE FUCK YOU WANT TO.