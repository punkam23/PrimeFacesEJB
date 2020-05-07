package servletClient;

import com.test.web.detalle.DetalleServiceImplBean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(name = "DetalleServiceImplBeanClient", urlPatterns = { "DetalleServiceImplBeanClient" })
public class DetalleServiceImplBeanClient extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
    @EJB
    private DetalleServiceImplBean detalleServiceImplBean;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>DetalleServiceImplBeanClient</title></head>");
        out.println("<body>");
        try {
            // TODO: Invoke Session Bean's business methods here. E.g.
            //   out.println(sessionEJB.helloWorld())
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        out.println("</body></html>");
        out.close();
    }
}
