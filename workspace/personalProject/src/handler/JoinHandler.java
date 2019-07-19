package handler;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.DuplicateIdException;
import m2.model.JoinRequest;
import service.JoinService;

public class JoinHandler implements CommandHandler {
	
	private static final String FORM_VIEW = "/amado/pages/joinForm.jsp";
	private JoinService joinService = new JoinService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, resp);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, resp);
		} else {
			resp.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse resp) {
		return FORM_VIEW;
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse resp) {
		JoinRequest joinReq = new JoinRequest();
		joinReq.setName(req.getParameter("name"));
		joinReq.setBirth(req.getParameter("birth"));
		joinReq.setId(req.getParameter("id"));
		joinReq.setPassword(req.getParameter("password"));
		joinReq.setConfirmPassword(req.getParameter("confirmPassword"));
		joinReq.setEmail(req.getParameter("email"));
		joinReq.setTel1(req.getParameter("tel1"));
		joinReq.setTel2(req.getParameter("tel2"));
		joinReq.setTel3(req.getParameter("tel3"));
		joinReq.setAddress1(req.getParameter("address1"));
		joinReq.setAddress2(req.getParameter("address2"));
		joinReq.setZipcode(req.getParameter("zipcode"));
		
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);
		
		joinReq.validate(errors);
		
		if (!errors.isEmpty()) { return FORM_VIEW; }
		
		try {
			joinService.join(joinReq);
			return "/amado/pages/joinPro.jsp";
		} catch (DuplicateIdException e) {
			errors.put("duplicatedId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

}
