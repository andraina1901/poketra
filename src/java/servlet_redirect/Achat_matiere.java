
package servlet_redirect;

import func.Utile;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Achat_matiere", urlPatterns = {"/Achat_matiere"})
public class Achat_matiere extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
          try  {
              Utile.dispatcher(request, response, "achat_matiere.jsp");
        }catch(Exception e){
            PrintWriter out = response.getWriter();
            out.println(e.getMessage());
        }
    }

}

