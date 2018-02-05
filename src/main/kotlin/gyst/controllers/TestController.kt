package gyst.controllers

import com.github.jknack.handlebars.Handlebars
import com.github.jknack.handlebars.io.ClassPathTemplateLoader
import com.github.jknack.handlebars.springmvc.SpringTemplateLoader
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ResourceLoader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
open class TestController: ApiController() {
    @Autowired
    lateinit var resourceLoader: ResourceLoader

    @RequestMapping("/test")
    fun test() : String {
        print(resourceLoader)
        val loader = SpringTemplateLoader(resourceLoader).apply { prefix = "classpath:test/consul" }
        val handlebars = Handlebars(loader)
//        val resource = resourceLoader.getResource("classpath:test/test.txt")
        return handlebars.compile("start/piyo/test").apply(mapOf(
                "hoge" to "piyo"
        ))
    }
}