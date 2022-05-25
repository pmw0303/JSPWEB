package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.ProductDao;

/**
 * Servlet implementation class updatecart
 */
@WebServlet("/product/updatecart")
public class updatecart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatecart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String json = request.getParameter("json"); // json 변수 요청
		try {
			JSONArray jsonArray = new JSONArray(json);
			for(int i=0 ; i<jsonArray.length() ; i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				int cartno = Integer.parseInt(jsonObject.get("cartno").toString()) ;
				int samount = Integer.parseInt(jsonObject.get("samount").toString()) ;		
				int totalprice = Integer.parseInt(jsonObject.get("totalprice").toString()) ;
				ProductDao.getProductDao().updatecart(cartno, samount, totalprice);
			}
		} catch (Exception e) {
			System.out.println("sevlet updatecart 오류 " +e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
