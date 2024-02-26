package ejb;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import dao.UserDAO;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.inject.Model;
import model.User;


@Model
public class UserManager implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user;
	private ArrayList<User> users;
	private UserDAO userDAO=new UserDAO();
		
	@PostConstruct
	 private void init()
	 {
	  user=new User();
	  setUsers(userDAO.selectAllUsers());
	 }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	public UserManager() {
		super();
		System.out.println("UserManager bean instantiated.");
	}
	
	
	public String selectUser(int id) throws SQLException {
		this.user = userDAO.selectUser(id);
		return ("update");
	}
	
	public String insertUser(User u) throws SQLException {
		userDAO.insertUser(u);
		return ("index");
	}
	
	public String updateUser(User u) throws SQLException {
		System.out.println(u.getId());
		userDAO.updateUser(u);
		return ("index");
	}
	
	public String deleteUser(int id) throws SQLException {
		userDAO.deleteUser(id);
		return ("index");
	}

	
}
