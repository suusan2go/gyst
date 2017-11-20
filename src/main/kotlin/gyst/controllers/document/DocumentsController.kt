package gyst.controllers.document

import gyst.controllers.ApiController
import gyst.domains.document.*
import gyst.exceptions.NotFoundException
import gyst.domains.user.User
import gyst.services.document.UserDocumentService
import gyst.views.DocumentView
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
                userDocumentService.findUserDocument(principal, DefinedDocumentId(documentId)) ?:
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

    @PatchMapping("/documents/{id}")
    fun updateDocument(@AuthenticationPrincipal principal: User,
                       @Validated @RequestBody form: DocumentForm,
                       @PathVariable("id") documentId: Int ): DocumentView {
        val document = form.toDocument(principal.id)
        return DocumentView(
                userDocumentService.updateDocument(DefinedDocumentId(documentId), document) ?:
                throw NotFoundException("User has no documents with id $documentId")
        )
    }
}

