package jw04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginBeanDataSource extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC_KR");
		response.setContentType("text/html;charset=euc_kr");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setPwd(pwd);
		
		UserDataSourceDao userDataSourceDao = new UserDataSourceDao();
		userDataSourceDao.getUser(userVO);

		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h2> Login ȭ�� </h2>");
		
		if(userVO.isActive()) {
			out.println("<div>"+id+"�� ȯ�� �մϴ�~ ^0^ </div>");
		}else {
			out.println("<div> ����!! Id , Pwd �� Ȯ�����ּ���~ </div>");
		}
		out.println("<p><a href = 'jw04/loginBeanDataSource.html'> �ڷ� </a></p>");
		out.println("</body>");
		out.println("</html>");
		
	}

}