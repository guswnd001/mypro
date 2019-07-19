package main;

import model.Comment;
import session.CommentSessionRepository;

public class Main02 {

	public static void main(String[] args) {
		CommentSessionRepository csr = new CommentSessionRepository();
		
		Long commentNo = 3L;
		Comment c = csr.selectCommentByPrimaryKey(commentNo);
		System.out.println(c);
		
		commentNo = 5L;
		c = csr.selectCommentByPrimaryKey(commentNo);
		System.out.println(c);
	}

}
