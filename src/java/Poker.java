

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
        
        //get the session object
        HttpSession session = request.getSession();
        //get the user in the session object
        User user = (User) session.getAttribute("user");
        //url to poker page
        String url = "/poker-play.jsp";
        String action = (String) request.getParameter("action");
        //get the bet set by te user
        String bet = (String) request.getParameter("poker-bet");
        
        //initialize the bet
        request.setAttribute("bet", "10");
        
        //first time getting to this page
        if(bet == null) {
        
            Card[] cpucards = {new Card() , new Card() , new Card() , new Card() , new Card()};
            Card[] playercards = {new Card() , new Card() , new Card() , new Card() , new Card()};
            request.setAttribute("cpucards", cpucards);
            request.setAttribute("playercards" , playercards);
          
        //after user sends a bet    
        } else {
        
            //user selected to play against cpu
            if(action.equals("cpu")) {

                Deck deck = new Deck();
                deck.shuffle();

                User cpu = new User("Dealer" , "usr" , "pass");
                
                Integer userbet = Integer.parseInt(bet);

                //deal cards to player
                Card[] playercards =  {deck.dealCard() , deck.dealCard() , deck.dealCard() , deck.dealCard() , deck.dealCard()};

                //deal cards to cpu
                Card[] cpucards = {deck.dealCard() , deck.dealCard() , deck.dealCard() , deck.dealCard() , deck.dealCard()};

                // get the result
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


                // get the result
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
                    
                    user.updateBalance(-1 * userbet);
                } else if(cpuscore < playerscore) {

                    winmessage = "Player Wins!!!";
                    
                    user.updateBalance(userbet);
                } else {

                    winmessage = "Tie Game";
                }

                request.setAttribute("winmessage" , winmessage);
                request.setAttribute("cpumessage", cpumessage);
                request.setAttribute("playermessage", playermessage);
                request.setAttribute("cpucards", cpucards);
                request.setAttribute("playercards" , playercards);
                request.setAttribute("cpu", cpu);
                request.setAttribute("bet", userbet);



                //user selected muliplayer
            } else if(action.equals("multi")) {


                //user selected to answer challenge
            } else if(action.equals("answer")) {


            } else if(action.equals("first")) {

                

            }//end of first 
        
        }//end of user enters a bet
        
        
        
        
        
        request.setAttribute("user" , user);
        // forward request and response objects to specified URL
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }//end of process request

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
