import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

@WebServlet("/converter")
public class Main extends HttpServlet {
    Parser parser = new Parser();

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            parser.generate();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("currencyInfo", parser.currencyToHTML());
        req.getRequestDispatcher("index.jsp").forward(req, resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Double amount = Double.parseDouble(req.getParameter("amount"));
        String from = req.getParameter("values");
        String to = req.getParameter("values2");
        System.out.println(parser.currencyToHTML());
        //req.setAttribute("currencyInfo",parser.currencyToHTML());
        Map<String, Double> mapCurr = parser.getCurrency();
        NumberFormat loc = NumberFormat.getNumberInstance(Locale.ROOT);
        MathContext context = new MathContext(3, RoundingMode.UP);
        BigDecimal result = new BigDecimal((mapCurr.get(to) / amount), context);

        req.setAttribute("currency", result);

        req.getRequestDispatcher("index.jsp").forward(req,resp);
        resp.sendRedirect("/converter");

    }


}
