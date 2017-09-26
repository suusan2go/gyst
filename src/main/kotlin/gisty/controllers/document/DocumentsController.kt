package gisty.controllers.document

import gisty.controllers.ApiController
import gisty.domains.DateTime
import gisty.exceptions.NotFoundException
import gisty.domains.document.Document
import gisty.domains.document.DocumentBody
import gisty.domains.document.DocumentId
import gisty.domains.document.DocumentTitle
import gisty.domains.user.User
import gisty.services.document.UserDocumentService
import gisty.views.DocumentView
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
class DocumentsController(@Autowired val userDocumentService: UserDocumentService ): ApiController() {

    @GetMapping("/documents")
    fun listDocuments(@AuthenticationPrincipal principal: User): List<DocumentView> {
        return userDocumentService.findUserDocuments(principal).map {
            DocumentView(it)
        }
    }

    @GetMapping("/documents/{id}")
    fun document(@AuthenticationPrincipal principal: User, @PathVariable("id") documentId: Int ): DocumentView {
        return DocumentView(
                userDocumentService.findUserDocument(principal, DocumentId(documentId)) ?:
                throw NotFoundException("User has no documents with id $documentId")
        )
    }

    @PostMapping("/documents")
    fun submitDocument(@AuthenticationPrincipal principal: User,
                       @Validated @RequestBody form: DocumentForm): DocumentView {
        return DocumentView(
                userDocumentService.createDocument(form.toDocument(principal.id))
        )
    }
}

