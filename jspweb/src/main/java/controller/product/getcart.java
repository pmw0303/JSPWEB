package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dao.MemberDao;
import dao.ProductDao;

/**
 * Servlet implementation class getcart
 */
@WebServlet("/product/getcart")
public class getcart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getcart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String mid = (String)request.getSession().getAttribute("login");
		int mno = MemberDao.getmemberDao().getmno(mid);
		JSONArray jsonArray = ProductDao.getProductDao().getcart(mno);
		// request, response 인코딩 (한글)
			// 응답객체 한글 인코딩 타입 설정
		response.setCharacterEncoding("UTF-8");
			// 응답객체 자료형 [ 문자열->json ]
		response.setContentType("application/json");
			// 출력
		response.getWriter().print(jsonArray);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
