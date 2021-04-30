import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/converter")
public class Main extends HttpServlet {
    HashMap<String, Currency> currencies = Currency.setCurrency();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double amount = Double.parseDouble(req.getParameter("amount"));
        String from = req.getParameter("values");
        String to = req.getParameter("values2");


        double result = Math.ceil(currencies.get(from).otherValues.get(to) * amount);

        System.out.println(amount + " " + from + " " + to + " " + result);
        req.setAttribute("currency", result);
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }


}
