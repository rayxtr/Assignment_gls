import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {
	public static Properties loadProperties(String f) {
		Properties p = new Properties();
		try(InputStream i = Main.class.getClassLoader().getResourceAsStream(f)){
			p.load(i);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return p;
	}
public static void main(String[] args) {
	
	Properties p = loadProperties("jdbc.properties");
	String url = p.getProperty("db.url");
	String user = p.getProperty("db.username");
	String pass = p.getProperty("db.password");
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
		return;
	}
	
	try(Connection con = DriverManager.getConnection(url,user,pass)){
		
		String qu = "Select empName, empAge from employee";
		try(Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(qu)){
					while(rs.next()) {
						String name = rs.getString("empName");
						int age = rs.getInt("empAge");
						
						System.out.println("Name - "+name+" Age - "+age);
					}
				}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	
}
}
