import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CalculateServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        String operator = request.getParameter("operator");
        int result = 0;

        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
        }

        request.setAttribute("result", result);
        RequestDispatcher view = request.getRequestDispatcher("calculator.jsp");
        view.forward(request, response);
    }
}
