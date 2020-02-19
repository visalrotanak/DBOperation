
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


public class DBOperation {
    
    Connection con = null;
    public Connection getCon() throws ClassNotFoundException, SQLException{
        if(con == null){
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kit", "root", "");
        }
        return con;
    }
    
    public boolean insertRecord(Student s){
//        int id = s.getId();
//        String name = s.getName();
        
        try{
            getCon();
            PreparedStatement ps = con.prepareStatement("insert into Student values(?,?)");
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            
            return true;
        }catch(ClassNotFoundException | SQLException e){
            
        }
        return false;
    }
    public int insertElement(List<Student> studentList){
        int count = 0;
        try{
            getCon();
            PreparedStatement ps = con.prepareStatement("insert into student values()");
            for(Student student: studentList){
                ps.setInt(1, student.getId());
                ps.setString(2, student.getName());
                ps.addBatch();
                count++;
            }
            ps.executeBatch();
        }catch(ClassNotFoundException | SQLException e){}
        return count;
    }
    
}
