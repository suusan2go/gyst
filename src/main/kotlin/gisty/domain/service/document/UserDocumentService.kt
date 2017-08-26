package gisty.domain.service.document

import gisty.domain.model.Document
import gisty.domain.model.User
import gisty.domain.repository.document.UserDocumentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserDocumentService(@Autowired userDocumentRepository: UserDocumentRepository) {
    private val userDocumentRepository = userDocumentRepository

    fun findUserDocuments(user: User): List<Document> {
        return userDocumentRepository.findAllDocuments(user.id)
    }

    fun findUserDocument(user: User, documentId: Int): Document? {
        val document = userDocumentRepository.findDocument(userId = user.id, documentId = documentId)
        return document
    }
}