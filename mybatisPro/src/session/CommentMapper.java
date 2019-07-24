package session;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import model.Comment;

public interface CommentMapper {

	@Select("SELECT comment_no, user_id, comment_content, reg_date "
			+ "FROM comment WHERE comment_no = #{commentNo}")
	Comment selectCommentByPrimaryKey(Long commentNo);
	
	@Insert("INSERT INTO comment (comment_no, user_id, comment_content, reg_date) "
			+ "VALUES (#{commentNo}, #{userId}, #{commentContent}, #{regDate})")
	Integer insertComment(Comment comment);
	
	@Delete("DELETE FROM comment WHERE comment_no = #{commentNo}")
	Integer deleteComment(Long commentNo);
	
}
