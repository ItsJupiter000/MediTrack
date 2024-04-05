
import java.sql.*;


public class DBHandler {

	public static Connection getConnection() throws Exception {
	    Connection con = null;
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "root");
	        return con;
	    } finally {
	        // Close the Connection in the finally block
	        if (con != null) {
//	            con.close();
	        }
	    }
	}

	
	
	public static Medicines[] getMedicines() throws SQLException, Exception {
		
		Statement stmt = getConnection().createStatement();
		ResultSet rs= stmt.executeQuery("select * from medi");
		Medicines medicines[]= new Medicines[20];
		int i=0;
		while(rs.next()) {
			medicines[i] = new Medicines(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			i++;
		}
		return medicines;
		
	}
	
	public static int insertMedicine(int id, int medi_id, String name, int doses, int age) throws SQLException, Exception {
        Connection con = getConnection();
        Statement stmt = null;
        int result =0;
        try {
            
            String sql = "INSERT INTO medi (id, medi_id, name, doses, age) VALUES (" + id + ",'" + medi_id + "' ,'" + name + "', '" + doses + "', " + age + ")";
            
            // Create a Statement object
            stmt = con.createStatement();
            
            // Execute the insert operation
             result = stmt.executeUpdate(sql);
            
        } catch (SQLException e) {
            System.out.println("SQL error occurred during the insert operation: " + e.getMessage());
            throw e;
        } finally {
            // Close the Statement
//            if (stmt != null) stmt.close();
            }
            
        return result;
    }
	
        
    public static int deleteMedicine(int id, int medi_id) throws Exception {
    	Connection con = getConnection();
    	Statement stmt = null;
    	int result = 0;
    	try {
    		String sql = "DELETE FROM medi WHERE id = " + id + " AND medi_id = " + medi_id;
    		stmt = con.createStatement();
    		result = stmt.executeUpdate(sql);
//    		System.out.println("Medicine deleted successfully.");
    	} catch (SQLException e) {
            System.out.println("SQL error occurred during the insert operation: " + e.getMessage());
            throw e;
        } finally {
            // Close the Statement
            if (stmt != null) stmt.close();
            
        }
    	return result;
    }
    
    public static int updateMedicine(int id,int medi_id,String new_name,int new_doses, int new_age) throws Exception {
    	Connection con = getConnection();
    	Statement stmt = null;
    	int result = 0;
    	
    	try {
    		String sql = "UPDATE medi SET name = '" + new_name + "', doses = '" + new_doses + "', age = " + new_age + " WHERE id = " + id + " AND medi_id = " + medi_id;
    		stmt = con.createStatement();
    		result = stmt.executeUpdate(sql);
//    		System.out.println("Movie details modified successfully.");
    	} catch (SQLException e) {
            System.out.println("SQL error occurred during the insert operation: " + e.getMessage());
            throw e;
        } finally {
            // Close the Statement
//            if (stmt != null) stmt.close();
            
        }
    	return result;
    }
    

}
