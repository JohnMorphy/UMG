

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class ServletFormRemoveWydawnictwo
 */

@WebServlet("/formRemoveWydawnictwo")
public class ServletFormRemoveWydawnictwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFormRemoveWydawnictwo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("usunWydawnictwo.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoKsiazki dao=new DaoKsiazki();
		
		int idw = Integer.parseInt(request.getParameter("idw"));
	
		String message = dao.usunWydawnictwo(idw);
		
		request.setAttribute("message", message);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("showMessage.jsp");
		dispatcher.forward(request, response);
	}

}
