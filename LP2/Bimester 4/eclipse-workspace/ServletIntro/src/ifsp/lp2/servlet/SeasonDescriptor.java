package ifsp.lp2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SeasonDescriptor
 */
@WebServlet("/SeasonDescriptor")
public class SeasonDescriptor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HashMap<String, String> seasonDescriptions = new HashMap<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeasonDescriptor() {
        super();
        // Creating season descriptions
        seasonDescriptions.put("summer", "Very hot");
        seasonDescriptions.put("winter", "Very cold");
        seasonDescriptions.put("autumn", "Much raining");
        seasonDescriptions.put("spring", "Much wind");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		//
		String seasonName = request.getParameter("seasonName");
		String message = "";
		//
		String seasonNameLowerCase = seasonName.toLowerCase();
		if(seasonDescriptions.containsKey(seasonNameLowerCase)) {
			message = seasonDescriptions.get(seasonNameLowerCase);
		}
		else
			message = "Season not found";
		//
		writer.println(message);
		writer.flush();
	}

}
