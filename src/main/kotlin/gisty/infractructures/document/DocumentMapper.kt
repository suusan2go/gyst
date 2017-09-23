package gisty.infractructures.document

import java.time.LocalDateTime
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Select

data class DocumentRecord(
        val id: Int? = null,
        val userId: Int = 1,
        val title: String = "",
        val body: String = "",
        val updatedDatetime: LocalDateTime = LocalDateTime.now(),
        val createdDatetime: LocalDateTime = LocalDateTime.now()
)

@Mapper
interface UserDocumentMapper {
    @Select("""
        SELECT * FROM documents
        WHERE user_id = #{userId}
        ORDER BY id DESC
        LIMIT #{limit}
        """
    )
    fun findAllDocuments(userId: Int,limit: Int = 10): List<DocumentRecord>

    @Select("""
        SELECT * FROM documents
        WHERE id = #{documentId} AND user_id = #{userId}
        ORDER BY id DESC
        LIMIT 1
        """
    )
    fun findDocument(userId: Int, documentId: Int): DocumentRecord?

    @Insert("""
        INSERT INTO documents (user_id, title, body, updated_datetime, created_datetime) VALUES
        (#{userId}, #{title}, #{body}, #{updatedDatetime}, #{createdDatetime})
        """
    )
    @Options(useGeneratedKeys=true, keyProperty="id")
    fun createDocument(documentRecord: DocumentRecord)

    @Select("""
        SELECT * FROM documents
        WHERE user_id = #{user_id} AND
        id > #{fromId}
        ORDER BY id DESC
        LIMIT #{limit}
        """
    )
    fun findMoreNewerDocuments(userId: Int, fromId: Int, limit: Int = 10): List<DocumentRecord>

    @Select("""
        SELECT * FROM documents
        WHERE user_id = #{user_id} AND
        id < #{fromId}
        ORDER BY id DESC
        LIMIT #{limit}
        """
    )
    fun findMoreOlderDocuments(userId: Int, fromId: Int, limit: Int = 10): List<DocumentRecord>
}
