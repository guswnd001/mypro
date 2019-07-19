package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Comment;
import session.CommentSessionRepository;

public class Main01 {

	public static void main(String[] args) {
		CommentSessionRepository csr = new CommentSessionRepository();
		Map<String, Object> map = new HashMap();
		
		map.put("commentNo", 1);
		List li = csr.selectCommentByCondition(map);
		System.out.println(li);
		
		li = csr.selectCommentByCondition(null);
		System.out.println(li);
		
		Comment com = csr.selectCommentByPrimaryKey(3L);
		System.out.println(com);
		
	}

}
