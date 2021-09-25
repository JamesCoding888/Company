package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.memberDao;
import Model.member;

/**
 * Servlet implementation class addMemberController
 */
@WebServlet("/addMemberController")
public class addMemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public addMemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.接收表單
		 * 2.先判斷帳號重複
		 * 3.沒重複, 新增資料庫
		 */
		String username = request.getParameter("username");
		if(new memberDao().queryUsername(username) !=null) {
			response.sendRedirect("addMemberError.html");
			
		}else {
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String mobile = request.getParameter("mobile");

			member m = new member(username, name, password, address, phone, mobile);
			
			new memberDao().add(m);
			
			response.sendRedirect("addMemberSuccess.html");
			
		}
	}
}