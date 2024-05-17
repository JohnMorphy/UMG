

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class servletFormularzKsiazkiSubmit
 */

@WebServlet("/formAddWydawnictwo")
public class ServletFormAddWydawnictwo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFormAddWydawnictwo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		RequestDispatcher dispatcher = request.getRequestDispatcher("dodajWydawnictwo.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DaoKsiazki dao=new DaoKsiazki();
		
		String nazwa = request.getParameter("nazwa");
		String adres = request.getParameter("adres");
	
		String message = dao.dodajWydawnictwo(nazwa, adres);
		
		request.setAttribute("message", message);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("showMessage.jsp");
		dispatcher.forward(request, response);
	}

}
