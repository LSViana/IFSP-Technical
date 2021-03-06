package ifsp.lp2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DateCalculation
 */
@WebServlet("/DateCalculation")
public class DateCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DateCalculation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		//
		String startDateStr = request.getParameter("startDate");
		String endDateStr = request.getParameter("endDate");
		int days = -1;
		try {
			LocalDate startDate = LocalDate.parse(startDateStr);
			LocalDate endDate = LocalDate.parse(endDateStr);
			days = Period.between(startDate, endDate).getDays();
			writer.println(String.format("There are %d %s between the selected dates",
					days,
					days == 1 ? "day" : "days"));
		} catch (Exception e) {
			writer.println(String.format("Invalid values selected. [%s]", e.getMessage()));
		}
		
		writer.flush();
	}

}
