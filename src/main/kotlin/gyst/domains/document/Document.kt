package gyst.domains.document

import gyst.domains.DateTime
import gyst.domains.user.UserId
import gyst.support.EmptyIdentifier
import gyst.support.PersistedIdentifier
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
) {
    fun bodyHtml(): String = body.html()
}

interface DocumentId { val value: Int }
data class DefinedDocumentId(override val value: Int): PersistedIdentifier<Int>(value), DocumentId
class EmptyDocumentId: EmptyIdentifier(), DocumentId
data class DocumentTitle(val value: String)
data class DocumentBody(val value: String) {
    private val renderer: HtmlRenderer = HtmlRenderer.builder().build()
    private val parser: Parser = Parser.builder().build()

    fun html(): String{
        val node: Node = parser.parse(value)
        return renderer.render(node)
    }
}