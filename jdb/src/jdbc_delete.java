import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc_delete {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "vi18");
			Statement smt = con.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			while (true) {
				System.out.println("enter employee id to delete");
				int eno = Integer.parseInt(br.readLine());

				int count = smt.executeUpdate("delete from emp where eno = " + eno);
				if (count > 0) {
					System.out.println(count + " record deleted");

				} else {
					System.out.println("no record deleted");
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
