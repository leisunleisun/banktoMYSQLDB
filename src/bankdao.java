

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;




public class bankdao {
	 private String jdbcURL = "jdbc:mysql://database-1.cabcxqpxk1ot.us-east-2.rds.amazonaws.com/test";
	 private String jdbcUsername = "lei";
	 private String jdbcPassword = "admin123";
	 private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (name, email,phonenum,balance,accountnum) VALUES " +
		        " (?, ?, ?, ?, ?);";

		    private static final String SELECT_USER_BY_ACCOUNTNUM = "select name,email,phonenum,balance from users where accountnum =?";
		    private static final String SELECT_ALL_USERS = "select * from users";
		    private static final String DELETE_USERS_SQL = "delete from users where accountnum = ?;";
		    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, phonenum =?,balance=? where accountnum = ?;";
			

		    public bankdao() {}
		    protected Connection getConnection() {
		        Connection connection = null;
		        try {
		        	Class.forName("com.mysql.cj.jdbc.Driver");
		            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		        } catch (SQLException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        } catch (ClassNotFoundException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
		        return connection;
		    }
		    public void insertUser(bank user) throws SQLException {
		        System.out.println(INSERT_USERS_SQL);
		        // try-with-resource statement will auto close the connection.
		        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
		            preparedStatement.setString(1, user.getName());
		            preparedStatement.setString(2, user.getemail());
		            preparedStatement.setString(3, user.getphonenum());
		            preparedStatement.setDouble(4, user.getbalance());
		            preparedStatement.setInt(5, user.getaccountnum());
		            System.out.println(preparedStatement);
		            preparedStatement.executeUpdate();
		        } catch (SQLException e) {
		            printSQLException(e);
		        }
		    }
		    
		    
		   
		    public bank selectUser(int accountnum) {
		        bank user = null;
		        // Step 1: Establishing a Connection
		        try (Connection connection = getConnection();
		            // Step 2:Create a statement using connection object
		            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ACCOUNTNUM);) {
		            preparedStatement.setInt(1, accountnum);
		            System.out.println(preparedStatement);
		            // Step 3: Execute the query or update query
		            ResultSet rs = preparedStatement.executeQuery();
		            
		            // Step 4: Process the ResultSet object.
		            while (rs.next()) {
		                String name = rs.getString("name");
		                String email = rs.getString("email");
		                String phonenum = rs.getString("phonenum");
		                double balance =rs.getDouble("balance");
		                System.out.println("name:"+name);
		                System.out.println("email:"+email);
		                System.out.println("phone number:"+phonenum);
		                System.out.println("account balance:"+balance);
		                
		                user = new bank(name, email, phonenum,balance,accountnum);
		               
		            }
		        } catch (SQLException e) {
		            printSQLException(e);
		        }
		        return user;
		    }
		    
		    
		    
		    public List < bank > selectAllUsers() {

		        // using try-with-resources to avoid closing resources (boiler plate code)
		        List < bank > users = new ArrayList < > ();
		        // Step 1: Establishing a Connection
		        try (Connection connection = getConnection();

		            // Step 2:Create a statement using connection object
		            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
		            System.out.println(preparedStatement);
		            // Step 3: Execute the query or update query
		            ResultSet rs = preparedStatement.executeQuery();

		            // Step 4: Process the ResultSet object.
		            while (rs.next()) {
		                int id = rs.getInt("accountnum");
		                String name = rs.getString("name");
		                String email = rs.getString("email");
		                String phonenum = rs.getString("phonenum");
		                double balance=rs.getDouble("balance");
		                System.out.println("name:"+name);
		                System.out.println("email:"+email);
		                System.out.println("phone number:"+phonenum);
		                System.out.println("account balance:"+balance);
		                System.out.println("account number:"+id);
		                System.out.println();
		                users.add(new bank(name, email, phonenum,balance,id));
		                
		            }
		            
		        } catch (SQLException e) {
		            printSQLException(e);
		        }
		        return users;
		    }
		    
		    public boolean deleteUser(int id) throws SQLException {
		        boolean rowDeleted;
		        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
		            statement.setInt(1, id);
		            rowDeleted = statement.executeUpdate() > 0;
		        }
		        return rowDeleted;
		    }

		    public boolean updateUser(bank user) throws SQLException {
		        boolean rowUpdated;
		        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
		            statement.setString(1, user.getName());
		            statement.setString(2, user.getemail());
		            statement.setString(3, user.getphonenum());
		            statement.setDouble(4, user.getbalance());
		            statement.setInt(5, user.getaccountnum());

		            rowUpdated = statement.executeUpdate() > 0;
		            System.out.println("updated");
		        }
		        
		        return rowUpdated;
		    }
		    
		    
		    private void printSQLException(SQLException ex) {
		        for (Throwable e: ex) {
		            if (e instanceof SQLException) {
		                e.printStackTrace(System.err);
		                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
		                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
		                System.err.println("Message: " + e.getMessage());
		                Throwable t = ex.getCause();
		                while (t != null) {
		                    System.out.println("Cause: " + t);
		                    t = t.getCause();
		                }
		            }}}
	
	
	
	//Create Method  --> Insert statement
		
	//Read Method  --> Select from where statement
		
	//uodate method 
		
	//delete method
		
		
}
