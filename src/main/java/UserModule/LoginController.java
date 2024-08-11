package UserModule;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ProductModule.ProductCRUD;
import ProductModule.ProductDetails;
import java.util.*;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter pw  = resp.getWriter();
		resp.setContentType("text/html");
		UserCRUD uc = new UserCRUD();
		ProductCRUD pc = new ProductCRUD();
		List<ProductDetails>productList = new ArrayList<ProductDetails>();
		try {
			int result = uc.login(username, password);
			if(result > 0)
			{
				pw.print("<h3>login Successfull<h3>");
				productList.addAll(pc.getProducts());
				RequestDispatcher rd  = req.getRequestDispatcher("Home.jsp");
				req.setAttribute("products",productList );
				rd.forward(req, resp);
			}
			else
			{
				pw.print("<h3>Invalid Credentials<h3>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
