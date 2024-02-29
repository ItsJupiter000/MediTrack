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
		Movies movies[] = null;
		try {
			movies = DBHandler.getMovies();
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
	        out.println("<title>List of All Movies</title>");
	        out.println("<style>"
	        		+"td{border:2px solid black;} tr{border:2px solid black;}"+ "</style>");
	        out.println("</head>");
	        out.println("<body style='align-items:center;display:flex;justify-content:center'>");

	        // Build the table header
	        out.println("<table style='text-align:center;border:2px solid black;'>");
	        out.println("<tr>");
	        out.println("<th>id</th>");
	        out.println("<th>title</th>");
	        out.println("<th>genre</th>");
	        out.println("<th>release year</th>");
	        out.println("<th>Actions</th>");
	        out.println("</tr>");

	        // Loop through movie data and add table rows
	        for (Movies movie : movies) {
	            out.println("<tr>");
	            out.println("<td>" + movie.getId() + "</td>");
	            out.println("<td>" + movie.getTitle() + "</td>");
	            out.println("<td>" + movie.getGenre() + "</td>");
	            out.println("<td>" + movie.getReleaseYear() + "</td>");
	            out.println("<td><a href='DeleteMovie?id=" + movie.getId() + "'>Delete</a></td>");
	            
	         // Delete button
	            
	         // Assuming you have a PrintWriter object named "out" and the movie ID is stored in a variable named "movieId"

//	            out.println("<form action=\"DeleteMovie\" method=\"POST\">");
//	         
//	            out.println("<input type=\"number\"  value=\"" + movie.getId() + "\" required>");
//	            out.println("<input type=\"submit\" value=\"Delete\">");
//	            out.println("</form>");

//	            out.println("<td>");
//	            out.println("<form method=\"post\" action=\"DeleteButton\">");
//	            out.println("<input type=\"hidden\" name=\"id\" value=\"${movie.getId()}\"\">");
//	            out.println("<button type=\"button\" onclick=\"deleteMovie(${movie.getId()})\">Delete</button>");
//	            out.println("</form>");
//	            out.println("</td>");
//	            out.println("</tr>");
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
		String movieId = request.getParameter("id");
        if (movieId != null) {
            response.sendRedirect("DeleteButton");
        } else {
           
            response.sendRedirect( "Display"); 
        }
	}


}
