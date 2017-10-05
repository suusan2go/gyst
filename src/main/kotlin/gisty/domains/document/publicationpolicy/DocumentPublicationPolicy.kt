package gisty.domains.document.publicationpolicy

import gisty.domains.DateTime
import gisty.domains.document.DocumentId
import java.util.*

data class DocumentPublicationPolicy(
        val id: DocumentPublicationPolicyId,
        val documentId: DocumentId,
        val token: DocumentPublicationToken,
        val expiresDateTime: DateTime,
        val createdDateTime: DateTime
)

data class DocumentPublicationPolicyId(val value: Int)
data class DocumentPublicationToken(val value: UUID)
