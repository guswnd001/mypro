package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Comment;
import session.CommentAnnotationRepository;
import session.CommentSessionRepository;

public class Main04 {

	public static void main(String[] args) {
		
		CommentSessionRepository csr = new CommentSessionRepository();
		
		Map<String, Object> map = new HashMap<String, Object>();
		//map.put("commentNo", 3);
		//map.put("userId", "user2");
		
		List li = csr.selectCommentByConditionChoose(map);
		//System.out.println(li);
		
		//li = csr.selectCommentByConditionTrim(map);
		map.put("commentNo", 1);
		li = csr.selectCommentByConditionForeach(null);
		//System.out.println(li.size());
		
		/*List li2 = csr.selectOgnlStaticMethod();
		System.out.println(li2);
		System.out.println("/////////////////////////////////////////");
		
		List li3 = csr.selectOgnlStaticField();
		System.out.println(li3);
		System.out.println("/////////////////////////////////////////");
		
		map.put("userId", "user3");
		List li4 = csr.selectOgnlStaticMethod2(map);
		System.out.println(li4);
		System.out.println("/////////////////////////////////////////");*/
		
		CommentAnnotationRepository car = new CommentAnnotationRepository();
		Comment c1 = car.selectCommentByPrimaryKey(3L);
		System.out.println(c1);
		
	}

}
