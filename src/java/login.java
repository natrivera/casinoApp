
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class login extends HttpServlet
{

    /**more comments
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        //create a db object
        CasinoDB db = new CasinoDB();
        
        //url to go to game after login
        String url = "/game.jsp";
        
        //get the action from the form
        String action = (String) request.getParameter("action");
        
        //get the session object
        HttpSession session = request.getSession();
        
        //action new for new user
        //action old for old user login
        if(action.equals("new")) {
        
            //get the inputed values from the form 
            String name = (String) request.getParameter("name");
            String dob = (String) request.getParameter("dob");
            String username = (String) request.getParameter("username");
            String password = (String) request.getParameter("password");
            String img = (String) request.getParameter("image");
            
            String check = db.login(username, password);
            
            if(check.equals("Username not found in our records")) {
                //create user object from inputted values
                User user = new User(name , username , password , dob);
                user.setImage(img);
                db.setUser(user);
                //set the user object to the session
                session.setAttribute("user", user);
                
                //reset the error
                session.setAttribute("error", "");
            } else {
                //send back to login screen
                url = "/index.jsp";
                
                //send the error back
                session.setAttribute("error", "UserName already in use");
            }
              
        } else if (action.equals("old")) {
            
            //get the iputted values from the login form
            String username = (String) request.getParameter("username");
            String password = (String) request.getParameter("password");
            
            String check = db.login(username, password);
            
            if(check.equals("Username not found in our records")) {
                //send back to login screen
                url = "/login.jsp";
                
                //send the error back
                session.setAttribute("error", check);
            
            } else if(check.equals("Password does not match our records")) {
                //send back to login screen
                url = "/login.jsp";
                
                //send the error back
                session.setAttribute("error", check);
            } else {
                //create a user from input
                User user = db.getUser(username);
              
                //set the user object to the session
                session.setAttribute("user", user);
                
                //reset the error
                session.setAttribute("error", "");
            }
            
    
        } else if(action.equals("admin")) {
        
            //get the iputted values from the login form
            String username = (String) request.getParameter("username");
            String password = (String) request.getParameter("password");
            
            String check = db.adminLog(username, password);
            
            if(check.equals("admin")) {
                User user = db.getUser(username);
                session.setAttribute("user", user);    
                url = "/console.jsp";
            } else {
                url = "/admin.jsp";
                request.setAttribute("error" , check);
            }
            
        }   
        
        // forward request and response objects to specified URL
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
