package gisty.domain.repository.document

import gisty.domain.model.Document
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface UserDocumentRepository {
    @Select("""
        SELECT * FROM documents
        WHERE user_id = #{user_id}
        ORDER BY id DESC
        LIMIT #{limit}
        """
    )
    fun findAllDocuments(limit: Int = 10): List<Document>

    @Select("""
        SELECT * FROM documents
        WHERE id = #{documentId} AND user_id = #{userId}
        ORDER BY id DESC
        LIMIT 1
        """
    )
    fun findDocument(userId: Int, documentId: Int): Document?

    @Select("""
        SELECT * FROM documents
        WHERE user_id = #{user_id} AND
        id > #{fromId}
        ORDER BY id DESC
        LIMIT #{limit}
        """
    )
    fun findMoreNewerDocuments(userId: Int, fromId: Int, limit: Int = 10): List<Document>

    @Select("""
        SELECT * FROM documents
        WHERE user_id = #{user_id} AND
        id < #{fromId}
        ORDER BY id DESC
        LIMIT #{limit}
        """
    )
    fun findMoreOlderDocuments(userId: Int, fromId: Int, limit: Int = 10): List<Document>
}