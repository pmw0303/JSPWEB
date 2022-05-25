package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dto.Chatting;


@WebServlet("/chatting")
public class chatting extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public chatting() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {;
		request.setCharacterEncoding("UTF-8");
		String nickname = request.getParameter("nickname");
		String chatting = request.getParameter("chatting");
		String time = request.getParameter("time");
		Chatting chat = new Chatting(0, nickname, chatting, time);
		boolean result = BoardDao.getBoardDao().sendmsg(chat);
		if(result) {
			response.getWriter().print(1);
		}
		else {
			response.getWriter().print(2);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}