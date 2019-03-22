import java.sql.*;

public class Database {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo","anshul","agarwal777anshul");

            String query = "SELECT * FROM users";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            if (conn != null) { System.out .println("Successfully connected to MySQL database test"); }

            while (rs.next())
            {
                String folio_num = rs.getString("Folio_num");
                String company = rs.getString("Company");
                String scheme = rs.getString("Scheme");
                String nav = rs.getString("NAV");
                String Iamount = rs.getString("Amount_invested");
                String Camount = rs.getString("Current_amount");

                //System.out.format("%s, %s, %s, %s, %s, %s\n", id, firstName, lastName, dateCreated, isAdmin, numPoints);
            }
            st.close();
            rs.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }
}