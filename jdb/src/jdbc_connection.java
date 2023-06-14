import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc_connection {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "vi18");
			Statement smt = con.createStatement();
			smt.executeUpdate("create table emp(eno number,ename varchar(20),empsal number)");
			System.out.println("table created ");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
