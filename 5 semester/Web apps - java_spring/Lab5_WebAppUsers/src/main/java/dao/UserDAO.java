package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.User;

public class UserDAO {

	String login = "postgres";
	String haslo = "postgres";
	String url =  "jdbc:postgresql://localhost:5432/postgres?currentSchema=\"users\"";
 // CRUID

private static final String SELECT_ALL_USERS = "SELECT * FROM users.users;";

private static final String SELECT_USER_BY_ID = 
		 "SELECT id, first_name, last_name, year_of_study, email, personal_id, country FROM users.users WHERE id = ?;";
 
private static final String INSERT_USERS_SQL = "INSERT INTO users.users (first_name, last_name, year_of_study, email, personal_id, country) VALUES (?, ?, ?, ?, ?, ?)";

private static final String UPDATE_USER_BY_ID = "UPDATE users.users SET first_name = ?, last_name = ?, year_of_study = ?, email = ?, personal_id = ?, country = ? WHERE id = ?";

private static final String DELETE_USER_BY_ID = "DELETE FROM users.users WHERE id = ?";


Connection connection = null;

 /**
 * Connect to the PostgreSQL database
 *
 * @return a Connection object
 */
 //rozpoczęcie polączenia
 public Connection DBSQLConnection() {
 try {
 Class.forName("org.postgresql.Driver");
 connection = DriverManager.getConnection(url, login, haslo);
 if(connection.isValid(5)) {
	 /*System.out.println("Connection is working");*/
	 }
 }
 catch (SQLException e) {
 e.printStackTrace();
 }
 catch (ClassNotFoundException e) {
 e.printStackTrace();
 }
 return connection;
 }

 private void DBSQLConnectionClose(){
 if(connection==null) return;try{
 connection.close();
 if(!connection.isValid(5)) {/*System.out.println("Connection closed");*/}
 }
 catch(SQLException e){
 e.printStackTrace();}
 }

 public UserDAO() {
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
			 
		 }
	 }
}
 
 
 public User selectUser(int id) {
	 User user = null;
	 
	 try(
		 Connection connection = DBSQLConnection(); 
		 PreparedStatement preparedStatement =
		 connection.prepareStatement(SELECT_USER_BY_ID);)
	 
	 {
		 preparedStatement.setInt(1, id);
		 ResultSet rs = preparedStatement.executeQuery();
		 
		 while (rs.next()) {
			 String t_first_name = rs.getString("first_name");
			 String t_last_name = rs.getString("last_name");
			 int t_year_of_study = rs.getInt("year_of_study");
			 String t_email = rs.getString("email");
			 Long t_personal_id = rs.getLong("personal_id");
			 String t_country = rs.getString("country");
			 user = new User(id, t_first_name, t_last_name, t_year_of_study,
			 t_email, t_personal_id, t_country);
		 }
	 }
	 catch (SQLException e) { printSQLException(e); }
	 finally {
		 DBSQLConnectionClose();
	 }

	 return user;
 }
 
 public ArrayList<User> selectAllUsers() {
	 ArrayList<User> users = new ArrayList<>();

	 try (Connection connection = DBSQLConnection();
	 PreparedStatement preparedStatement =
	 connection.prepareStatement(SELECT_ALL_USERS);)
	 {
	 ResultSet rs = preparedStatement.executeQuery();

	 while (rs.next()) {
	 int t_id = rs.getInt("id");
	 String t_first_name = rs.getString("first_name");String t_last_name = rs.getString("last_name");
	 int t_year_of_study = rs.getInt("year_of_study");
	 String t_email = rs.getString("email");
	 Long t_personal_id= rs.getLong("personal_id");
	 String t_country = rs.getString("country");
	 users.add(new User(t_id, t_first_name, t_last_name, t_year_of_study,
	 t_email, t_personal_id, t_country));
	 }
	 }
	 catch (SQLException e) { printSQLException(e);}
	 finally {
		 DBSQLConnectionClose();
	 }
	 
	 return users;
}

public void insertUser(User user) throws SQLException
{
	try(Connection connection = DBSQLConnection();
	
	PreparedStatement preparedStatement =
	connection.prepareStatement(INSERT_USERS_SQL))
	{
	  preparedStatement.setString(1, user.getFirst_name());
	  preparedStatement.setString(2, user.getLast_name());
	  preparedStatement.setInt(3, user.getYear_of_study());
	  preparedStatement.setString(4, user.getEmail());
	  preparedStatement.setLong(5, (Long)user.getPersonal_id());
	  preparedStatement.setString(6, user.getCountry());
	  preparedStatement.executeUpdate();
	}
	catch (SQLException e) { printSQLException(e); }
	finally {
		 DBSQLConnectionClose();
	}
}

public void updateUser(User user) throws SQLException {
	try (Connection connection = DBSQLConnection();
	PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_BY_ID);)
	{
		preparedStatement.setString(1, user.getFirst_name());
		preparedStatement.setString(2, user.getLast_name());
		preparedStatement.setInt(3, user.getYear_of_study());
		preparedStatement.setString(4, user.getEmail());
		preparedStatement.setLong(5, (Long)user.getPersonal_id());
		preparedStatement.setString(6, user.getCountry());
		preparedStatement.setInt(7, user.getId());
		preparedStatement.executeUpdate();
	}
	catch (SQLException e) { printSQLException(e); }
}

public void deleteUser(int id) throws SQLException {
	try (Connection connection = DBSQLConnection();
	PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);)
	{
		preparedStatement.setInt(1,id);
		preparedStatement.executeUpdate();
	}
	catch (SQLException e) { printSQLException(e); }
}

 public static void main(String[] args)
 {
	 UserDAO dao = new UserDAO();

				 
	 var u1= dao.selectAllUsers();

	 for(User u:u1) {
		 System.out.println(u.getFirst_name());
	 }
	 
	 try {
		dao.insertUser(new User(2, "Andrzej", "Gołota", 3, "andrzejgolota@domena.pl", 56111915711L ,"Polska"));
	} catch (SQLException e) {
		e.printStackTrace();
	}
	 
	 ArrayList<User> list = dao.selectAllUsers();

 }

}