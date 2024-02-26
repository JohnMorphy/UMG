

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class ServletGetTables
 */

@WebServlet("/getAllTables")
public class ServletGetTables extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGetTables() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DaoKsiazki dao=new DaoKsiazki();
		HttpSession session=request.getSession();
		
		ArrayList<modelKsiazka> listaKsiazek;
		if(request.getParameter("id") != null) {
			int index = Integer.parseInt(request.getParameter("id"));
			listaKsiazek = dao.listaKsiazekKategorii(index);
		} else {
			listaKsiazek = dao.listaKsiazek();
		}
		session.setAttribute("listaKsiazek", listaKsiazek);
		
		
		ArrayList<modelWydawnictwo> listaWydawnictw = dao.listaWydawnictw();
		session.setAttribute("listaWydawnictw", listaWydawnictw);
		session.setAttribute("listaWydawnictwDoUsuniecia", dao.listaWydawnictwDoUsuniecia());
		
		ArrayList<modelKategoria> listaKategorii = dao.listaKategorii();
		session.setAttribute("listaKategorii", listaKategorii);
		if(request.getParameter("removeableKategoria") != null) {
			if(request.getParameter("removeableKategoria").equalsIgnoreCase("true")) {
				session.setAttribute("listaKategoriiDoUsuniecia", dao.listaKategoriiDoUsuniecia());
			} 
		} 
		
		String nextURL="/" + request.getParameter("jspFile") + ".jsp";
		RequestDispatcher rd=getServletContext().getRequestDispatcher(nextURL);
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
