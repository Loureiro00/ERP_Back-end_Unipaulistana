import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 

@WebServlet("/SalvaBeneficio")  

public class SalvarBeneficio extends HttpServlet {  
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String nomedobeneficio=request.getParameter("nomedobeneficio");  
        String sigladobeneficio=request.getParameter("sigladobeneficio");  
        String descricaobeneficio=request.getParameter("descricaobeneficio");  
        String tipobeneficio=request.getParameter("tipobeneficio");  
       
          
        Beneficio e=new Beneficio();  
        e.setNomedobeneficio(nomedobeneficio);  
        e.setSigladobeneficio(sigladobeneficio);  
        e.setDescricaobeneficio(descricaobeneficio); 
        e.setTipobeneficio(tipobeneficio);
          
        int status=BeneficioDao.save(e);  
        if(status>0 && (nomedobeneficio!="")&&(sigladobeneficio!="")&&(descricaobeneficio!="")&&(tipobeneficio!="") ){  
            out.print("<p>Registro salvo com sucesso</p>");  
            request.getRequestDispatcher("cadastrobeneficio.html").include(request, response);  
        }else{  
            out.println("Desculpe! seu registro não foi salvo");
            request.getRequestDispatcher("cadastrobeneficio.html").include(request, response);  
        }  
          
        out.close();  
    }  
  
}  