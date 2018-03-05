
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class leaderboard extends HttpServlet
{

    /**
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
        String url = "/leaderboard.jsp";
        
        CasinoDB db = new CasinoDB();
        String action = (String) request.getParameter("action");
        
        String sql = "";
        if(action.equals("")) {
            sql = "select username , balance from user_t order by balance desc";
        } else if(action.equals("1")) {
            sql = "select user_t.username , sum(transaction_t.bet) as Winigs " +
                    "from user_t left join transaction_t on user_t.UserID = transaction_t.UserID " +
                    "where transaction_t.GameID = 1 " +
                    "group by user_t.username " +
                    "order by Balance desc;";
        } else if(action.equals("2")) {
            sql = "select user_t.username , sum(transaction_t.bet) as Winnings " +
                    "from user_t left join transaction_t on user_t.UserID = transaction_t.UserID " +
                    "where transaction_t.GameID = 2 " +
                    "group by user_t.username " +
                    "order by Balance desc;";
        }  

        String table = db.select(sql);
        
        request.setAttribute("table" , table);
        
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
