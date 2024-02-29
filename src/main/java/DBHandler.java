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

	
	
	public static Movies[] getMovies() throws SQLException, Exception {
		
		Statement stmt = getConnection().createStatement();
		ResultSet rs= stmt.executeQuery("select * from movies");
		Movies movies[]= new Movies[20];
		int i=0;
		while(rs.next()) {
			movies[i] = new Movies(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			i++;
		}
		return movies;
		
	}
	
	public static int insertMovie(int id, String title, String genre, int releaseYear) throws SQLException, Exception {
        Connection con = getConnection();
        Statement stmt = null;
        int result =0;
        try {
            
            String sql = "INSERT INTO movies (id, title, genre, release_year) VALUES (" + id + ", '" + title + "', '" + genre + "', " + releaseYear + ")";
            
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
	
        
    public static int deleteMovie(int movie_id) throws Exception {
    	Connection con = getConnection();
    	Statement stmt = null;
    	int result = 0;
    	try {
    		String sql = "DELETE FROM movies WHERE id = " + movie_id;
    		stmt = con.createStatement();
    		result = stmt.executeUpdate(sql);
//    		System.out.println("Movie deleted successfully.");
    	} catch (SQLException e) {
            System.out.println("SQL error occurred during the insert operation: " + e.getMessage());
            throw e;
        } finally {
            // Close the Statement
            if (stmt != null) stmt.close();
            
        }
    	return result;
    }
    
    public static int updateMovie(int movie_id,String new_title,String new_genre, int new_releaseYear) throws Exception {
    	Connection con = getConnection();
    	Statement stmt = null;
    	int result = 0;
    	
    	try {
    		String sql = "UPDATE movies SET title = '" + new_title + "', genre = '" + new_genre + "', release_year = " + new_releaseYear + " WHERE id = " + movie_id;

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
    
    
	
//	public static void insertMovie(int id, String title, String genre, int releaseYear) throws SQLException, Exception {
//		Connection con = getConnection();
//	    
//	    // Prepare the SQL statement with placeholders for the values
//	    String sql = "INSERT INTO movies (id, title, genre, release_year) VALUES (?, ?, ?, ?)";
//	    
//	    // Use try-with-resources to ensure that resources are closed after the operation is complete
//	    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
//	        // Set the values for each placeholder
//	        pstmt.setInt(1, id);
//	        pstmt.setString(2, title);
//	        pstmt.setString(3, genre);
//	        pstmt.setInt(4, releaseYear);
//	        
//	        // Execute the insert operation
//	        int affectedRows = pstmt.executeUpdate();
//	        
//	        // Check if the insert was successful
//	        if (affectedRows > 0) {
//	            System.out.println("Movie inserted successfully.");
//	        } else {
//	            System.out.println("Movie insertion failed.");
//	        }
//	    } catch (SQLException e) {
//	        System.out.println("SQL error occurred during the insert operation: " + e.getMessage());
//	        throw e; // Rethrow the exception to handle it in the calling method
//	    }
//	    // Note: No need to close the Connection or PreparedStatement here if using try-with-resources
//	    
//	    
//	
}