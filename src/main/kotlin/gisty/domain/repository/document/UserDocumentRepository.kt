package gisty.domain.repository.document

import gisty.domain.model.Document
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
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

    @Insert("""
        INSERT INTO documents (user_id, title, body, updated_datetime, created_datetime) VALUES
        (#{userId}, #{title}, #{body}, #{updatedDatetime}, #{createdDatetime})
        """
    )
    @Options(useGeneratedKeys=true, keyProperty="id")
    fun createDocument(user: Document)

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