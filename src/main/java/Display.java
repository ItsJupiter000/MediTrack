import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class Display
 */

@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		Medicines medicines[] = null;
		try {
			medicines = DBHandler.getMedicines();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>List of All Medicines</title>");
		out.println("<style>");
		out.println("body {");
		out.println("    font-family: Arial, sans-serif;");
		out.println("    background-color: #1E1E1E;");
		out.println("    padding: 20px;");
		out.println("}");
		out.println("table {");
		out.println("    border-collapse: collapse;");
		out.println("    width: 80%;");
		out.println("    margin-left: 10%;");
		out.println("    background-color: #333;");
		out.println("}");
		out.println("th, td {");
		out.println("    border: 1px solid #dddddd;");
		out.println("    text-align: center;");
		out.println("    padding: 8px;");
		out.println("    color: white;");
		out.println("}");
		out.println("th {");
		out.println("    background-color: #1E1E1E;");
		out.println("    color: white;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");

		// Build the table header
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Patient Id</th>");
		out.println("<th>Medicine Id</th>");
		out.println("<th>Medicine Name</th>");
		out.println("<th>No. Of Doses</th>");
		out.println("<th>Age</th>");
		out.println("</tr>");

		// Loop through medicine data and add table rows
		for (Medicines medicine : medicines) {
		    out.println("<tr>");
		    out.println("<td>" + medicine.getId() + "</td>");
		    out.println("<td>" + medicine.getMedi_id() + "</td>");
		    out.println("<td>" + medicine.getName() + "</td>");
		    out.println("<td>" + medicine.getDoses() + "</td>");
		    out.println("<td>" + medicine.getAge() + "</td>");
		    out.println("</tr>");
		}

		// Close the table and HTML structure
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String medicineId = request.getParameter("id");
        if (medicineId != null) {
            response.sendRedirect("DeleteButton");
        } else {
           
            response.sendRedirect( "Display"); 
        }
	}


}