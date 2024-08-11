package UserModule;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignupController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String firstName = (String) req.getParameter("firstname");
		String lastName = (String) req.getParameter("lastname");
		long contact = Long.parseLong( req.getParameter("contact"));
		String address = (String) req.getParameter("address");
		String email = (String) req.getParameter("email");
		String password1 = (String) req.getParameter("password");
		String password2 = (String) req.getParameter("password2");
		UserDetails ud = new UserDetails();
		if(password1.equals(password2)) {
			ud.setFirstName(firstName);
			ud.setLastName(lastName);
			ud.setContact(contact);
			ud.setAddress(address);
			ud.setEmail(email);
			ud.setPassword(password1);
		}
		UserCRUD uc = new UserCRUD();
		try {
			int result = uc.signup(ud);
			if(result>0)
			{
				RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
				rd.forward(req, resp);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
