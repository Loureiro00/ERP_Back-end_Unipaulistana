import java.sql.*; 

public class BeneficioDao {
	  
	    public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rhuni","root","2129");
	        }
	        catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
	    public static int save(Beneficio e){  
	        int status=0;
	        
	        try{  
	            Connection con=BeneficioDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "insert into beneficio(nomedobeneficio,sigladobeneficio,tipobeneficio,descricaobeneficio) values (?,?,?,?)");  
	            
	            ps.setString(1,e.getNomedobeneficio());  
	            ps.setString(2,e.getSigladobeneficio());  
	            ps.setString(3,e.getTipobeneficio());
	            ps.setString(4, e.getDescricaobeneficio());
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }
	        catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    } 
	    public static int update(Beneficio e) {
	    	int status = 0;
	    	try {
	    		 Connection con=BeneficioDao.getConnection();  
		         PreparedStatement ps=con.prepareStatement( "update beneficio(nomedobeneficio,sigladobeneficio,tipobeneficio,descricaobeneficio,idbeneficio) values (?,?,?,?,?)");
		         ps.setString(1, e.getNomedobeneficio());
		         ps.setString(2, e.getSigladobeneficio());
		         ps.setString(3, e.getTipobeneficio());
		         ps.setString(4, e.getDescricaobeneficio());
		         ps.setInt(5, e.getIdbeneficio());
		         
		         status = ps.executeUpdate();
		         con.close();
			} 
	    	catch (Exception e2) {
				// TODO: handle exception
			}
	    	
	    	
			return status;
	    	
	    	
	    }
	
}
