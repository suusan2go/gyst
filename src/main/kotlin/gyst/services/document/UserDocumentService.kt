package gyst.services.document

import gyst.domains.DateTime
import gyst.domains.document.DefinedDocumentId
import gyst.domains.document.Document
import gyst.domains.user.User
import gyst.domains.document.UserDocumentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserDocumentService(@Autowired private val userDocumentRepository: UserDocumentRepository) {

    fun findUserDocuments(user: User): List<Document> {
        return userDocumentRepository.findAllDocuments(user.id)
    }

    fun findUserDocument(user: User, documentId: DefinedDocumentId): Document? {
        return userDocumentRepository.findDocument(userId = user.id, documentId = documentId)
    }

    fun createDocument(document: Document): Document {
        return userDocumentRepository.createDocument(document)
    }

    fun updateDocument(id: DefinedDocumentId, document: Document): Document? {
        val currentDocument = userDocumentRepository.findDocument(document.userId, id)
        return currentDocument?.let {
            userDocumentRepository.updateDocument(
                    it.copy(
                            title = document.title,
                            body = document.body,
                            updatedDatetime = DateTime.current()
                    )
            )
        }
    }
}