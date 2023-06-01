import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");  
          
        String usuario = request.getParameter("Usuario");  
        String senha = request.getParameter("Senha");  
          
        if(LoginDao.validate(usuario, senha)){
            RequestDispatcher rd = request.getRequestDispatcher("servlet2");
            rd.forward(request, response);
        } else {
            request.getRequestDispatcher("index2.html").include(request, response);
            System.out.println(usuario);
            System.out.println(senha);
        } 
          
	}

}
