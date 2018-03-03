

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Poker extends HttpServlet
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
        User user = (User) request.getAttribute("user");
        String url = "/poker-play.jsp";
        String action = (String) request.getParameter("action");
        
        //user selected to play against cpu
        if(action.equals("cpu")) {
            
            Deck deck = new Deck();
            deck.shuffle();
            
            User cpu = new User("Dealer" , "usr" , "pass");
            
            
                    
            Card[] cpucards =  {deck.dealCard() , deck.dealCard() , deck.dealCard() , deck.dealCard() , deck.dealCard()};
            
            Card[] playercards = {deck.dealCard() , deck.dealCard() , deck.dealCard() , deck.dealCard() , deck.dealCard()};
            
            // display result
            deck.highCard(cpucards);
            int couples = deck.pairs(cpucards); // a pair
            deck.twoPairs(couples); // two pairs
            int triples = deck.threeOfAKind(cpucards); // three of a kind
            deck.fourOfAKind(cpucards); // four of a kind
            deck.flush(cpucards); // a flush
            deck.straight(cpucards); // a straight
            deck.fullHouse(couples, triples); // a full house
            
            String cpumessage = deck.getBet();
            int cpuscore = deck.getScore();
            
            
            // display result
            deck.highCard(playercards);
            couples = deck.pairs(playercards); // a pair
            deck.twoPairs(couples); // two pairs
            triples = deck.threeOfAKind(playercards); // three of a kind
            deck.fourOfAKind(playercards); // four of a kind
            deck.flush(playercards); // a flush
            deck.straight(playercards); // a straight
            deck.fullHouse(couples, triples); // a full house
            
            String playermessage = deck.getBet();
            int playerscore = deck.getScore();
            
            String winmessage = "";
            
            if(cpuscore > playerscore) {
            
                winmessage = "CPU Wins!!!";
            } else if(cpuscore < playerscore) {
            
                winmessage = "Player Wins!!!";
            } else {
            
                winmessage = "Tie Game";
            }
            
            request.setAttribute("winmessage" , winmessage);
            request.setAttribute("cpumessage", cpumessage);
            request.setAttribute("playermessage", playermessage);
            request.setAttribute("cpucards", cpucards);
            request.setAttribute("playercards" , playercards);
            request.setAttribute("cpu", cpu);
            
        
            
            //user selected muliplayer
        } else if(action.equals("multi")) {
            
        
            //user selected to answer challenge
        } else if(action.equals("answer")) {
        
            
        } else {}
        
        
        request.setAttribute("user" , user);
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
