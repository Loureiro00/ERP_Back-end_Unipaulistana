

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditServletDepartamendo")
public class EditServletDepartamendo extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Departamento</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        
        Departamento e = DepartamentoDao.getDepartamentoById(id);
		
        out.print("<form action='EditServletDepartamendo2' method='post'>");  
        out.print("<table>");  
        out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getIddepartamento()+"'/></td></tr>");  
        out.print("<tr><td>Nome do Departamento:</td><td><input type='text' name='nomedepartamento' value='"+e.getNomedepartamento()+"'/></td></tr>");  
        out.print("<tr><td>Senha:</td><td><input type='text' name='sigladepartamento' value='"+e.getSigla()+"'/></td></tr>");  
        out.print("<tr><td>Email:</td><td><input type='text' name='descricaodepartamento' value='"+e.getDescricao()+"'/></td></tr>");  
        out.print("<tr><td colspan='2'><input type='submit' value='Editar & Salvar '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
        out.close();
        
	}

	
}
