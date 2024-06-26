import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String option = request.getParameter("option");

        if (option != null) {
            switch (option) {
                case "show":
                    response.sendRedirect("Display");
                    break;
                case "insert":
                    response.sendRedirect("AddMedicine.html");
                    break;
                case "delete":
                    response.sendRedirect("DeleteMedicine.html");
                    break;
                case "update":
                    response.sendRedirect("UpdateMedicine.html");
                    break;
                case "exit":
                    response.getWriter().println("Goodbye! Have a nice Day");
                    break;
                default:
                    response.sendRedirect("Home.html");
            }
        }
    }

}