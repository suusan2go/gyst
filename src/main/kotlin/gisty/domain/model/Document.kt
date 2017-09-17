package gisty.domain.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import org.commonmark.node.Node
import org.commonmark.parser.Parser
import org.commonmark.renderer.html.HtmlRenderer;
import java.time.LocalDateTime

class Document: Entity {
    var id: Int = 0
    var userId: Int = 0
    lateinit var title: String
    lateinit var body: String
    @get:JsonIgnore
    val renderer: HtmlRenderer = HtmlRenderer.builder().build()
    @get:JsonIgnore
    val parser: Parser = Parser.builder().build()

    constructor(id: Int, userId: Int, title: String, body: String): this() {
        this.id = id
        this.userId = userId
        this.title = title
        this.body = body
        this.updatedDatetime = LocalDateTime.now()
        this.createdDatetime = LocalDateTime.now()
    }

    @JsonProperty("bodyHtml")
    fun getBodyHtml(): String{
        val node: Node = parser.parse(body)
        return renderer.render(node)
    }

    private constructor(): super() {}
}