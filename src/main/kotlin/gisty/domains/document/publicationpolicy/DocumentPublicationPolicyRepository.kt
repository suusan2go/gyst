package gisty.domains.document.publicationpolicy

import gisty.domains.DateTime
import gisty.domains.document.DocumentId

interface DocumentPublicationPolicyRepository {
    fun findActivePolicy(documentId: DocumentId): DocumentPublicationPolicy?
    fun extendPolicyDeadline(
            documentPublicationPolicyId: DocumentPublicationPolicyId,
            expiredDateTime: DateTime): DocumentPublicationPolicy
    fun generatePolicy(documentId: DocumentId, expiredDateTime: DateTime)
    fun disablePolicy(documentPublicationPolicyId: DocumentPublicationPolicyId)
}
