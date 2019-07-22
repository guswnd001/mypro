package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Comment;
import session.CommentSessionRepository;

public class Main03 {

	public static void main(String[] args) throws ParseException {
		CommentSessionRepository csr = new CommentSessionRepository();
		/*
		Comment com = csr.selectCommentByPrimaryKey(6L); 
		System.out.println(com);
		 */
		
		
		/*
		Comment c = new Comment();
		c.setCommentContent("comment");
		c.setCommentNo(12l);
		c.setRegDate(new Date());
		c.setUserId("7");
		int count = csr.insertComment(c);
		System.out.println(count);
		*/
		
		/*
		Comment c = new Comment();
		c.setCommentNo(12l);
		c.setCommentContent("update Comment===");
		int count = csr.updateComment(c);
		System.out.println(count);
		*/
		
		/*
		int count = csr.deleteComment(12l);
		System.out.println(count);
		*/
		
		/*
		Comment c1 = new Comment();
		c1.setCommentNo(2l);
		c1.setCommentContent("댓글2222");
		int count = csr.updateCommentIf(c1);
		System.out.println(count);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Comment c2 = new Comment();
		c2.setCommentNo(3l);
		c2.setRegDate(sdf.parse("2012-03-13 03:33:33"));
		count = csr.updateCommentIf(c2);
		System.out.println(count);
		*/
		
		
		Map<String, Object> map = new HashMap();
		map.put("commentNo", 5);
		map.put("userId", "user3");
		
		List li = csr.selectCommentByConditionIf(map);
		System.out.println(li);
		
		
		/*
		Comment c = new Comment();
		c.setCommentContent("댓글55555");
		c.setCommentNo(5);
		
		int count = csr.updateCommentTrim(c);
		System.out.println(count);
		*/
	}
	
}
