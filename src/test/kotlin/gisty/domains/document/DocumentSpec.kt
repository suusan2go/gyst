package gisty.domains.document

import gisty.domains.DateTime
import gisty.domains.user.UserId
import org.hamcrest.Matchers.containsString
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import java.time.LocalDateTime

object DocumentSpec: Spek({
    describe("bodyHtml") {
        val document = Document(
                DefinedDocumentId(1), UserId(1), DocumentTitle("title"),
                DocumentBody("body" ),
                DateTime(LocalDateTime.now()),
                DateTime(LocalDateTime.now()))
        it("should contins Markdown HTML") {
           assertThat(document.bodyHtml(), containsString("<p>body</p>"))
        }
    }
})