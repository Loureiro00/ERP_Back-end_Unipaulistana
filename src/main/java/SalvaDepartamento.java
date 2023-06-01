import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

@WebServlet("/SalvaDepartamento")  

public class SalvaDepartamento extends HttpServlet {  
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String nomedepartamento=request.getParameter("nomedepartamento");  
        String sigla=request.getParameter("sigladepartamento");  
        String descricao=request.getParameter("descricaodepartamento");  
        
       
          
        Departamento e=new Departamento();  
        e.setNomedepartamento(nomedepartamento);  
        e.setSigla(sigla);  
        e.setDescricao(descricao);  
          
        int status=DepartamentoDao.save(e);  
        if(status>0 && (nomedepartamento!="") &&(sigla!="")&& (descricao!="")){  
            out.print("<p>Registro salvo com sucesso</p>");  
            request.getRequestDispatcher("cadastrodepartamento.html").include(request, response);  
        }else{  
            out.println("Desculpe! seu registro não foi salvo");
            request.getRequestDispatcher("cadastrodepartamento.html").include(request, response);  
        }  
          
        out.close();  
    }  
  
}  