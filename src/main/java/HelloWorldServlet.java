import java.util.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name = "HelloWorldServlet", urlPatterns = "/hello-world")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String name = "World";
        if (req.getParameter("name") != null ) {
            name = req.getParameter("name");
        }
        out.printf("Welcome %s!", name);
        out.println("<h1 style=\"color:blue; text-align:center; margin-top:30%; font-size:60px;\">BING, BANG, BOOM!</h1>");

    }
}
