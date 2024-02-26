

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Multiplication
 */
public class Multiplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Multiplication() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String value = "<table>";
		
		for(int i = 0; i<21; i++) {
			value += "<tr>";
			for(int j = 0; j<21; j++) {
				
				if(i == 0 && j == 0) {
					value+="<th class=\"corner\"></th>";
					continue;
				}
				
				if(i == 0) {
					value+="<th class=\"main number\">" + j + "</th>";
					continue;
				}
				
				if(j == 0) {
					value+="<th class=\"main number\">" + i + "</th>";
					continue;
				}
				
				if(((i)*(j))%2==0) {
					value+="<th class=\"even\">" + (i)*(j) + "</th>";
				} else {
					value+="<th class=\"noteven\">" + (i)*(j) + "</th>";
				}
				
			}
			value += "</tr>";
		}
		
		value += "</table>";
		

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter printWriter = response.getWriter();
		response.getWriter().append(value);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
