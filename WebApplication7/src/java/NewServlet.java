
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        int sno = Integer.parseInt(req.getParameter("sno"));
        String firstName = req.getParameter("firstName");
        
        Student s = new Student();
        s.setId(sno);
        s.setName(firstName);
        
        DBOperation dbo = new DBOperation();
        
        if(dbo.insertRecord(s)){
            System.out.println("Data inserted successfully.");
            req.setAttribute("student", s);
        }else{
            System.out.println("Data insertion Failed");
        }
        RequestDispatcher re = req.getRequestDispatcher("Result.jsp");
        re.forward(req, res);
        
        
        
    }
}
