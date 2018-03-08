
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Stats extends HttpServlet
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
        //get the user name from the url
        String id = (String) request.getParameter("id");
        String url = "/stats.jsp";
        
        CasinoDB db = new CasinoDB();
        String sql = "select name as Name , username as Username , balance as Balance , dateofbirth as DOB , datecreated as Membersince from user_t where userid = " + id;
        
        String table = db.select(sql);
        
        request.setAttribute("table" , table);
        
        //return stats sql for poker
        sql = "select * from user_t , transaction_t where user_t.userid = transaction_t.userid " +
              "and user_t.userid = " + id +
                " and gameid = 1";
        ArrayList<Double>  bets = db.getBets(sql);
        ArrayList<Double>  pokerout = new ArrayList();
        double totalgames = 1;
        double total = 0;
        double average = 0;

        double wins = 0;
        double winpercent = 0;
           for(double bet : bets) {             
                total = total + bet;
                if(bet > 0) {
                    wins++;
                }
           }        
        
        totalgames = bets.size();
        if(totalgames == 0) {
            
        } else {
        
            winpercent = wins / totalgames;
            winpercent = (double)Math.round(winpercent * 10000d) / 100d;
            average = total / totalgames;
            average = (double)Math.round(average * 100d) / 100d;
        }
        
        pokerout.add(totalgames);
        pokerout.add(average);
        pokerout.add(winpercent);
        pokerout.add(wins);
        
        request.setAttribute("pokerstats" , pokerout);
        
        //return stats sql for poker
        sql = "select * from user_t , transaction_t where user_t.userid = transaction_t.userid " +
              "and user_t.userid = " + id +
                " and gameid = 2";
        bets = db.getBets(sql);
        ArrayList<Double>  crapsout = new ArrayList();
        totalgames = 1;
        total = 0;
        average = 0;

        wins = 0;
        winpercent = 0;
           for(double bet : bets) {             
                total = total + bet;
                if(bet > 0) {
                    wins++;
                }
           }        
        
        totalgames = bets.size();
        if(totalgames == 0) {
           
        } else {
            winpercent = wins / totalgames;
            winpercent = (double)Math.round(winpercent * 10000d) / 100d;
            average = total / totalgames;
            average = (double)Math.round(average * 100d) / 100d;
        }
        
        crapsout.add(totalgames);
        crapsout.add(average);
        crapsout.add(winpercent);
        crapsout.add(wins);
        
        request.setAttribute("crapstats" , crapsout);
        
        //return stats sql for Hi-Low
        sql = "select * from user_t , transaction_t where user_t.userid = transaction_t.userid " +
              "and user_t.userid = " + id +
                " and gameid = 3";
        bets = db.getBets(sql);
        ArrayList<Double>  hiloout = new ArrayList();
        totalgames = 1;
        total = 0;
        average = 0;

        wins = 0;
        winpercent = 0;
           for(double bet : bets) {             
                total = total + bet;
                if(bet > 0) {
                    wins++;
                }
           }        
        
        totalgames = bets.size();
        if(totalgames == 0) {
            
        } else {
        
           winpercent = wins / totalgames;
            winpercent = (double)Math.round(winpercent * 10000d) / 100d;
            average = total / totalgames;
            average = (double)Math.round(average * 100d) / 100d; 
        }
        
        
        hiloout.add(totalgames);
        hiloout.add(average);
        hiloout.add(winpercent);
        hiloout.add(wins);
        
        request.setAttribute("hilostats" , hiloout);
        
        
        
        
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
