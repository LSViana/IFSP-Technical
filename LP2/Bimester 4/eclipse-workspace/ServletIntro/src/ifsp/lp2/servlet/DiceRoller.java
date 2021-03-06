package ifsp.lp2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DiceRoller
 */
@WebServlet("/DiceRoller")
public class DiceRoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String diceFormat = "dice-%d.png";
	private static final String dicePage = "DiceRoller.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DiceRoller() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		//
		String userGuessStr = request.getParameter("userGuess");
		try {
			int userGuess = Integer.parseInt(userGuessStr);
			// Generating the randomic sum
			Random random = new Random();
			int number1 = random.nextInt(6) + 1;
			int number2 = random.nextInt(6) + 1;
			//
			response.setContentType("text/html");
			writeBody(userGuess, number1, number2, writer);
		} catch (Exception e) {
			writer.write("Invalid number, try again!");
		}
		finally {
			writer.flush();
		}
	}

	private void writeBody(int userGuess, int number1, int number2, PrintWriter writer) {
		int sum = number1 + number2;
		// Start
		writer.write("<body>");
		writer.write("<html>");
		// Messages to user
		writer.write("<div>");
		writer.write(String.format("<p>The sum was: %d + %d = %d</p>", number1, number2, sum));
		writer.write("<p>");
		writer.write(sum == userGuess ? "You won, congratulations!" : "You lost, but you can try again!");
		writer.write("</p>");
		writer.write("</div>");
		// Action buttons
		writer.write(String.format("<a href=\"%s\"><button>Try again</button></a>", dicePage));
		// Dice images
		String firstDice = String.format(diceFormat, number1);
		String secondDice = String.format(diceFormat, number2);
		writer.write("<div>");
		writer.write(String.format("<img src=\"%s\" />", firstDice));
		writer.write(String.format("<img src=\"%s\" />", secondDice));
		writer.write("</div>");
		// Finish
		writer.write("</html>");
		writer.write("</body>");
	}

}
