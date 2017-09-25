package gisty.domains.document

import gisty.domains.DateTime
import gisty.domains.user.UserId
import org.commonmark.node.Node
import org.commonmark.parser.Parser
import org.commonmark.renderer.html.HtmlRenderer;

data class Document(
        val id: DocumentId,
        val userId: UserId,
        val title: DocumentTitle,
        val body: DocumentBody,
        val updatedDatetime: DateTime,
        val createdDateTime: DateTime
){
}

data class DocumentId(val value: Int)
data class DocumentTitle(val value: String)
data class DocumentBody(val value: String) {
    private val renderer: HtmlRenderer = HtmlRenderer.builder().build()
    private val parser: Parser = Parser.builder().build()

    fun html(): String{
        val node: Node = parser.parse(value)
        return renderer.render(node)
    }
}