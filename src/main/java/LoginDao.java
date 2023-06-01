import java.sql.*;

public class LoginDao {

	public static boolean validate(String usuario, String senha) {
		
		boolean status = false;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rhuni","root","2129");
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM login WHERE usuario = ? AND senha = ?");
			ps.setString(1, usuario);
			ps.setString(2, senha);
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}
}