package UserModule;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import ConnectionModule.MyDbConnection;

public class UserCRUD {
	public static String username;
	public int signup( UserDetails ud ) throws ClassNotFoundException, SQLException {
		String query = "insert into userdetails(UserName,Password,FirstName,LastName,Contact,Email,Address)values(?,?,?,?,?,?,?)";
		username = ud.getFirstName() + Math.round(Math.random()*2323*33);
		Connection connection = MyDbConnection.getDbConnection();
		PreparedStatement stmt  =  connection.prepareStatement(query);
		stmt.setString(1, username);
		stmt.setString(2,ud.getPassword());
		stmt.setString(3, ud.getFirstName());
		stmt.setString(4, ud.getLastName());
		stmt.setLong(5, ud.getContact());
		stmt.setString(6,ud.getEmail());
		stmt.setString(7, ud.getAddress());
		int result = stmt.executeUpdate();
		System.out.println(result + "rows inserted ");
		connection.close();
		return result;
	}
	
	public int login(String user, String password) throws ClassNotFoundException, SQLException {
		String query = "select UserName,Password from userdetails where UserName = ?";
		String Password;
		Connection connection = MyDbConnection.getDbConnection();
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, user);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			username = rs.getNString("UserName");
			Password = rs.getString("Password");
			if(user.equals(username)&& Password.equals(password)) {
				System.out.println("login successfull");
				return 1;
			}
			else {
				System.out.println("check your credentials");
				return 0;
			}
		}
		connection.close();
		rs.close();
		return 0;
	}
	
	public UserDetails showProfile() throws SQLException, ClassNotFoundException {
		String query = "select UserName,FirstName,LastName,Contact,Email,Address from userdetails where UserName = ?";
		Connection connection = MyDbConnection.getDbConnection();
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, username);
		UserDetails ud = new UserDetails();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			username = rs.getNString("UserName");
			ud.setUserId(username);
			ud.setFirstName(rs.getString("FirstName"));
			ud.setLastName(rs.getString("LastName"));
			ud.setContact(rs.getLong("Contact"));
			ud.setEmail(rs.getString("Email"));
			ud.setAddress(rs.getString("Address"));
			return ud;
		}
		connection.close();
		rs.close();
		return null;
	}
}
