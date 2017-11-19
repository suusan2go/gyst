package gisty.views

import gisty.domains.document.Document

data class DocumentView(
        val id: Int,
        val title: String,
        val body: String,
        val bodyHtml: String
){
    companion object {
        operator fun invoke(document: Document): DocumentView{
            return DocumentView(
                document.id.value,
                document.title.value,
                document.body.value,
                document.bodyHtml()
            )
        }
    }
}