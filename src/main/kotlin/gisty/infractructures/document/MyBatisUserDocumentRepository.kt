package gisty.infractructures.document

import gisty.domains.DateTime
import gisty.domains.document.*
import gisty.domains.user.UserId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository


@Repository
class MyBatisUserDocumentRepository(
        @Autowired private val documentMapper: UserDocumentMapper
): UserDocumentRepository {
    override fun findAllDocuments(userId: UserId, limit: Int): List<Document> {
        return documentMapper.findAllDocuments(userId.value).map {
            recordToDocument(it)
        }
    }

    override fun createDocument(document: Document): Document {
        val record = DocumentRecord(
                null,
                document.userId.value,
                document.title.value,
                document.body.value,
                document.updatedDatetime.value,
                document.createdDateTime.value
        )
        documentMapper.createDocument(record)
        return recordToDocument(record)
    }

    override fun updateDocument(document: Document): Document? {
        val record = DocumentRecord(
                document.id.value,
                document.userId.value,
                document.title.value,
                document.body.value,
                document.updatedDatetime.value,
                document.createdDateTime.value
        )
        documentMapper.updateDocument(record)
        return recordToDocument(record)
    }

    override fun findDocument(userId: UserId, documentId: DefinedDocumentId): Document? {
        val record = documentMapper.findDocument(userId.value, documentId.value)
        return record?.let {
            recordToDocument(it)
        }
    }

    override fun findMoreNewerDocuments(userId: UserId, fromId: DocumentId, limit: Int ): List<Document> {
        return documentMapper.findMoreNewerDocuments(userId.value, fromId.value, limit).map {
            recordToDocument(it)
        }
    }

    override fun findMoreOlderDocuments(userId: UserId, fromId: DocumentId, limit: Int): List<Document> {
        return documentMapper.findMoreOlderDocuments(userId.value, fromId.value, limit).map {
            recordToDocument(it)
        }
    }

    private fun recordToDocument(record: DocumentRecord): Document{
        return Document(
                DefinedDocumentId(record.id!!),
                UserId(record.userId),
                DocumentTitle(record.title),
                DocumentBody(record.body),
                DateTime(record.updatedDatetime),
                DateTime(record.createdDatetime)
        )
    }
}
