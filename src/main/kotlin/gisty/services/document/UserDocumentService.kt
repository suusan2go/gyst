package gisty.services.document

import gisty.domains.document.Document
import gisty.domains.document.DocumentId
import gisty.domains.user.User
import gisty.domains.document.UserDocumentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserDocumentService(@Autowired private val userDocumentRepository: UserDocumentRepository) {

    fun findUserDocuments(user: User): List<Document> {
        return userDocumentRepository.findAllDocuments(user.id)
    }

    fun findUserDocument(user: User, documentId: DocumentId): Document? {
        return userDocumentRepository.findDocument(userId = user.id, documentId = documentId)
    }

    fun createDocument(document: Document): Document {
        return userDocumentRepository.createDocument(document)
    }
}