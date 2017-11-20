package gyst.controllers.document

import gyst.domains.DateTime
import gyst.domains.document.*
import gyst.domains.user.UserId
import org.hibernate.validator.constraints.NotBlank

import java.io.Serializable;


class DocumentForm: Serializable {
    @get:NotBlank(message = "必須です")
    var title: String = ""
    @get:NotBlank(message = "必須です")
    var body: String = ""

    fun toDocument(userId: UserId): Document {
        return Document(
                EmptyDocumentId(),
                userId,
                DocumentTitle(title),
                DocumentBody(body),
                DateTime.current(),
                DateTime.current()
        )
    }
}


