package gisty.controllers.document

import gisty.domains.DateTime
import gisty.domains.document.Document
import gisty.domains.document.DocumentBody
import gisty.domains.document.DocumentId
import gisty.domains.document.DocumentTitle
import gisty.domains.user.UserId
import org.hibernate.validator.constraints.NotBlank

import java.io.Serializable;


class DocumentForm: Serializable {
    @get:NotBlank(message = "必須です")
    var title: String = ""
    @get:NotBlank(message = "必須です")
    var body: String = ""

    fun toDocument(userId: UserId): Document {
        return Document(
                DocumentId(0),
                userId,
                DocumentTitle(title),
                DocumentBody(body),
                DateTime.current(),
                DateTime.current()
        )
    }
}


