import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Servlet implementation class GuessingGameServlet
 */
@WebServlet("/guess")

public class GuessingGameServlet extends HttpServlet {
	
	private int guessCount = 0;
	private int random;
	private int userGuess;
	public static ArrayList<Integer> guessingHistory = new ArrayList<>();
	
	private static final long serialVersionUID = 1L;
	 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuessingGameServlet() {
        super();
        this.setup();    
    }
    
    private void setup() {
    	this.guessCount = 0;
    	Random rand = new Random();
        this.random = rand.nextInt(100);
        guessingHistory.clear();
        this.userGuess = -1;
    }
    


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nextURL="/takeAGuess.jsp";		
		
		System.out.println(userGuess);
		
		request.getParameter("number");
				
		if(request.getParameterMap().containsKey("number")) {
			
			try	{
				userGuess = Integer.parseInt(request.getParameter("number"));
				
				guessingHistory.add(userGuess);
				request.setAttribute("guessingHistory", guessingHistory);
				
				if(userGuess == random) {
					nextURL = "/endOfTheGame.jsp";
					request.setAttribute("message", guessCount);
					setup();
				} else {
					
					this.guessCount++;
					
					if(userGuess > random) {
						request.setAttribute("message", "Number too high");
					} else if(userGuess < random) {
						request.setAttribute("message", "Number too small");
					}
				}			 					
			} catch (NumberFormatException e)	{
				System.out.println(e);
				request.setAttribute("message", "Wrong format.");
			}
			
		}
		
		getServletContext().getRequestDispatcher(nextURL).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
