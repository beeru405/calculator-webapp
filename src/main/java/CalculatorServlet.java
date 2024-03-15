import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CalculatorServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Display calculator JSP page
        RequestDispatcher view = request.getRequestDispatcher("calculator.jsp");
        view.forward(request, response);
    }
}
