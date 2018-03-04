
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class CasinoDB
{
    
    //connection variables
    String dbURL = "jdbc:mysql://localhost:3306/casinodb";
    String username = "root";
    String password = "sesame";
    
    //empty constructor
    public CasinoDB() {}
    
    public int tableL(String s) {
    
        int l = 0;
        
        String sqlResult = "";
        User user = new User();
         try {
            
            // load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            
            Connection connection = DriverManager.getConnection(
                    dbURL, username, password);

            // create a statement
            Statement statement = connection.createStatement();
            String query = "select * from " + s;
            ResultSet results = statement.executeQuery(query);
            
            //get the length of the resultset
            while(results.next()) {
                l++;
            }
            
          
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            sqlResult += "<p>Error loading the databse driver: <br>"
                    + e.getMessage() + "</p>";
        } catch (SQLException e) {
            sqlResult = "<p>Error executing the SQL statement: <br>"
                    + e.getMessage() + "</p>";
        }
        
        return l;
    }
    
    public String adminLog(String u , String p) {
    
        String out = "";
        String check = login(u , p);
        if(check.equals("match")) {
            User user = getUser(u);
            if(user.getAdmin() == 1) {
                check = "admin";
            } else {
                check = "User is not an Admin";
            }
        }
        
        return check;
    }
    
    public String login(String n , String p) {
    
        String sqlResult = "";
        String match = "Username not found in our records";
         try {
            
            // load the driver
            Class.forName("com.mysql.jdbc.Driver");
                      
            Connection connection = DriverManager.getConnection(
                    dbURL, username, password);

            // create a statement
            Statement statement = connection.createStatement();
            String query = "select username , password from user_t;";
            ResultSet results = statement.executeQuery(query);

            //arrays to store usernames and passwords from query
            ArrayList<String> usernames = new ArrayList();
            ArrayList<String> passwords = new ArrayList();
            
            //load the arrays
            while(results.next()) {            
                usernames.add(results.getString("username"));
                passwords.add(results.getString("password"));
            }
            
            //check if username is in db and if password matches
            for (int x = 0; x < usernames.size(); x++) {
                String temp = usernames.get(x);
                if(temp.equals(n)) {
                    String ptemp = passwords.get(x);
                    if(ptemp.equals(p)) {
                        match = "match";
                    } else {
                        match = "Password does not match our records";
                    }
                }
            }//end of checks
          
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            sqlResult += "<p>Error loading the databse driver: <br>"
                    + e.getMessage() + "</p>";
        } catch (SQLException e) {
            sqlResult = "<p>Error executing the SQL statement: <br>"
                    + e.getMessage() + "</p>";
        }
         return match;
    }//end of login
    
    public User getUser(String u) {

        String sqlResult = "";
        User user = new User();
         try {
            
            // load the driver
            Class.forName("com.mysql.jdbc.Driver");
     
            Connection connection = DriverManager.getConnection(
                    dbURL, username, password);

            // create a statement
            Statement statement = connection.createStatement();
            String query = "select * from user_t where username = '" + u + "';";
            ResultSet results = statement.executeQuery(query);
            
            results.next();
            user = new User(results.getString("Name") ,
                    results.getInt("Balance") , 
                    results.getString("username") , 
                    results.getInt("userid"));  
            user.setAdmin(results.getInt("admin"));
          
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            sqlResult += "<p>Error loading the databse driver: <br>"
                    + e.getMessage() + "</p>";
        } catch (SQLException e) {
            sqlResult = "<p>Error executing the SQL statement: <br>"
                    + e.getMessage() + "</p>";
        }
        
        return user;
    }//end of getuser()
    
    public void setUser(User u) {
        String sqlResult = "";
        int length = tableL("user_t");
        length++;
         try {
            
            // load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(
                    dbURL, username, password);
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            String currdate = dateFormat.format(date);
            
            String insert = 
                            "INSERT INTO user_t (userid ,  name , username , password , balance , dateofbirth , datecreated) " +
                            "VALUES (" + length + ", '" + u.getName() + "', " +
                            "'" + u.getUserName() + "', " +
                            "'" + u.getPassword() + "' , " + u.getBalance() + " , '" + u.getDob() + "' , '" + currdate + "')";

            //create the statement                
            Statement statement = connection.createStatement();

            int rowCount = statement.executeUpdate(insert);
  
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            sqlResult += "<p>Error loading the databse driver: <br>"
                    + e.getMessage() + "</p>";
        } catch (SQLException e) {
            sqlResult = "<p>Error executing the SQL statement: <br>"
                    + e.getMessage() + "</p>";
        }
        
    }//end of setuser()
    
    public String updateBalance(User u , int i , int c , int g) {
        String sqlResult = "";
         try {
            
            // load the driver
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connection = DriverManager.getConnection(
                    dbURL, username, password);
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date date = new Date();
            String currdate = dateFormat.format(date);
            
            //create and run the update usert_t query
            String insert = 
                            "update user_t set balance = " + i + " where username = '" + u.getUserName() + "'";
            //create the statement                
            Statement statement = connection.createStatement();
            int rowCount = statement.executeUpdate(insert);
            
            //get length of transaction table
            int length = tableL("transaction_t");
            length++;
            
            //create and insert the update transaction query
            insert = "insert into transaction_t (transactionid , userid , transactiondate , bet , gameid) "
                    + "values ( " + length + " , " + u.getUserid() + " , '" + currdate + "' , " + c + " , " + g +")";
            //create the statement                
            statement = connection.createStatement();
            rowCount = statement.executeUpdate(insert);
  
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            sqlResult += "<p>Error loading the databse driver: <br>"
                    + e.getMessage() + "</p>";
        } catch (SQLException e) {
            sqlResult = "<p>Error executing the SQL statement: <br>"
                    + e.getMessage() + "</p>";
        }
         return sqlResult;
    }//end of update balance and transction tables
}
