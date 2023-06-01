

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/EditServletDepartamendo2")
public class EditServletDepartamendo2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String nome=request.getParameter("nomedepartamento");  
        String sigla=request.getParameter("sigladepartamento");  
        String descricao=request.getParameter("descricaodepartamento");  
          
        Departamento e=new Departamento();  
        e.setIddepartamento(id);  
        e.setNomedepartamento(nome);  
        e.setSigla(sigla);  
        e.setDescricao(descricao);  
          
        int status=DepartamentoDao.update(e);  
        if(status>0){  
            response.sendRedirect("VisualizarDepartamento");  
        }else{  
            out.println("Desculpa! não foi possivel atualizar o registro");  
        }  
          
        out.close();  

	}

}
