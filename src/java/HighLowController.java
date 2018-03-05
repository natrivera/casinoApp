import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HighLowController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Create an instance of CasinoDB class
       CasinoDB db = new CasinoDB();
        
        //get the session object
        HttpSession session = request.getSession();
        //get the user in the session object
        User user = (User) session.getAttribute("user");
        
        
        //Retrieve button pushed
        String playButton = (String) request.getParameter("playButton");
        String lowerButton = (String) request.getParameter("lowerButton");
        String higherButton = (String)request.getParameter("higherButton");
        
        //At start set playButton to enabled and lowerButton, higherButton to disabled
        String playButtonState = "";
        String lowerButtonState = "disabled";
        String higherButtonState = "disabled";
        
        //Send the buttons states to jsp
        request.setAttribute("playButtonState", playButtonState);
        request.setAttribute("lowerButtonState", lowerButtonState);
        request.setAttribute("higherButtonState", higherButtonState);
        
        //Declare the string to hold the url
        String url = "/hi-lo.jsp";
        
        if(playButton != null)
        {
            //Create instance of deck and use shuffle method to a deck of 52 to randomize
            Deck deck = new Deck();
            deck.shuffle();
            
            //User information will go here
            
            //Get the bet from jsp will go here
            
            //Deal cards to the player
            Card[] card1 =  {deck.dealCard()};
            Card[] card2 = {deck.dealCard()};
            
            //Win message to display to user
            String winMessage = "";
            
            deck.setSingleCardScore(card1);
            int card1Score = deck.getScore();
            
            deck.setSingleCardScore(card2);
            int card2Score = deck.getScore();
            
            if(lowerButton != null)
            {
                if(card2Score < card2Score)
                {
                    winMessage = "You win!";
                }
                else
                {
                    winMessage = "You lose!";
                }
            }
            else if(higherButton != null)
            {
                if(card2Score > card1Score)
                {
                    winMessage = "You win!";
                }
                else
                {
                    winMessage = "You lose!";
                }
            }
            
            //Database stuff goes here
            
                request.setAttribute("winmessage" , winMessage);
                request.setAttribute("card1", card1);
                request.setAttribute("card2" , card2);

        }
        
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
            throws ServletException, IOException {
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
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
