import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc_update {

	public static void main(String[] args) {

		String value;
		int id;
		double sal;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "vi18");
			Statement smt = con.createStatement();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("enter employee id");
			value = br.readLine();
			id = Integer.parseInt(value);

			System.out.println("enter employee new salary");
			value = br.readLine();
			sal = Integer.parseInt(value);

			int count = smt.executeUpdate("update emp set empsal = " + sal + "where eno = " + id);

			if (count > 0) {
				System.out.println(count + " row updated");

			} else {
				System.out.println("no record found");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
