package gisty.domains.document

import gisty.domains.user.UserId

interface UserDocumentRepository {
    fun findAllDocuments(userId: UserId, limit: Int = 10): List<Document>
    fun findDocument(userId: UserId, documentId: DocumentId): Document?
    fun createDocument(document: Document): Document
    fun updateDocument(document: Document): Document?
    fun findMoreNewerDocuments(userId: UserId, fromId: DocumentId, limit: Int = 10): List<Document>
    fun findMoreOlderDocuments(userId: UserId, fromId: DocumentId, limit: Int = 10): List<Document>
}