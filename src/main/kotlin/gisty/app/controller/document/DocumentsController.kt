package gisty.app.controller.document

import gisty.app.controller.ApiController
import gisty.app.exception.NotFoundException
import gisty.domain.model.Document
import gisty.domain.model.User
import gisty.domain.service.document.UserDocumentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class DocumentsController(@Autowired userDocumentService: UserDocumentService ): ApiController() {
    val userDocumentService = userDocumentService

    @GetMapping("/documents")
    fun listDocuments(@AuthenticationPrincipal principal: User): List<Document> {
        return userDocumentService.findUserDocuments(principal)
    }

    @GetMapping("/documents/{id}")
    fun document(@AuthenticationPrincipal principal: User, @PathVariable("id") documentId: Int ): Document {
        return userDocumentService.findUserDocument(principal, documentId) ?:
                throw NotFoundException("User has no documents with id $documentId")
    }
}