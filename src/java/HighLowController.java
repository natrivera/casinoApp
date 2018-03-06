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
        int count = 0;
        

        //Declare the string to hold the url
        String url = "/hi-lo.jsp";
                     
        //Win message to display to user
        String winMessage = "";

                        
            if(playButton != null){

                playButtonState = "disabled";
                //Create instance of deck and use shuffle method to a deck of 52 to randomize
                Deck deck = new Deck();
                deck.shuffle();

                Card[] card1 = {deck.dealCard()};
                Card[] card2 = {deck.dealCard()};

                deck.setSingleCardScore(card1);
                int card1Score = deck.getScore();

                deck.setSingleCardScore(card2);
                int card2Score = deck.getScore();

                session.setAttribute("card1", card1);
                session.setAttribute("card2", card2);
                session.setAttribute("card1Score", card1Score);
                session.setAttribute("card2Score", card2Score);

                count ++;
                request.setAttribute("playButtonState", playButtonState);
                request.setAttribute("winmessage" , winMessage);
                request.setAttribute("count", count);


                 getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
            }

            if(lowerButton != null)
            {
                if((int)session.getAttribute("card2Score") < (int)session.getAttribute("card1Score"))
                {
                    count = 2;
                    playButtonState = "";
                    lowerButtonState = "disabled";
                    higherButtonState = "disabled";
                    winMessage = "You win!";
                    
                    request.setAttribute("playButtonState", playButtonState);
                    request.setAttribute("lowerButtonState", lowerButtonState);
                    request.setAttribute("higherButtonState", higherButtonState);
                    request.setAttribute("winMessage", winMessage);
                    request.setAttribute("count", count);
                    
                    int bal = user.getBalance() + 10;
                    db.updateBalance(user, bal, 10 ,3);
                    user = db.getUser(user.getUserName());
                    session.setAttribute("user", user);
                                        
                         getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
                }
                else if((int)session.getAttribute("card2Score") == (int)session.getAttribute("card1Score"))
                {
                    count = 2;
                    playButtonState = "";
                    lowerButtonState = "disabled";
                    higherButtonState = "disabled";
                    winMessage = "Tie!";
                    
                    request.setAttribute("playButtonState", playButtonState);
                    request.setAttribute("lowerButtonState", lowerButtonState);
                    request.setAttribute("higherButtonState", higherButtonState);
                    request.setAttribute("winMessage", winMessage);
                    request.setAttribute("count", count);
                    
                    int bal = user.getBalance() + 0;
                    db.updateBalance(user, bal, 0 ,3);
                    user = db.getUser(user.getUserName());
                    session.setAttribute("user", user);
                                        
                         getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
                }
                else        
                {
                    count = 2;
                    winMessage = "You lose!";
                    playButtonState = "";
                    lowerButtonState = "disabled";
                    higherButtonState = "disabled";
                    
                    winMessage = "You lose!";
                    
                    request.setAttribute("playButtonState", playButtonState);
                    request.setAttribute("lowerButtonState", lowerButtonState);
                    request.setAttribute("higherButtonState", higherButtonState);
                    request.setAttribute("winMessage", winMessage);
                    request.setAttribute("count", count);
                    
                    int bal = user.getBalance() - 10;
                    db.updateBalance(user, bal, -10 ,3);
                    user = db.getUser(user.getUserName());
                    session.setAttribute("user", user);
                    
                    
                     getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
                }
            }
            else if(higherButton != null)
            {
                if((int)session.getAttribute("card2Score") > (int)session.getAttribute("card1Score"))
                {
                    count = 2;
                    winMessage = "You win!";
                    
                    playButtonState = "";
                    lowerButtonState = "disabled";
                    higherButtonState = "disabled";
                    
                    request.setAttribute("playButtonState", playButtonState);
                    request.setAttribute("lowerButtonState", lowerButtonState);
                    request.setAttribute("higherButtonState", higherButtonState);
                    request.setAttribute("winMessage", winMessage);
                    request.setAttribute("count", count);
                    
                    int bal = user.getBalance() + 10;
                    db.updateBalance(user, bal, 10 ,3);
                    user = db.getUser(user.getUserName());
                    session.setAttribute("user", user);
                                        
                         getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
                }
                else if((int)session.getAttribute("card2Score") == (int)session.getAttribute("card1Score"))
                {
                    count = 2;
                    playButtonState = "";
                    lowerButtonState = "disabled";
                    higherButtonState = "disabled";
                    winMessage = "Tie!";
                    
                    request.setAttribute("playButtonState", playButtonState);
                    request.setAttribute("lowerButtonState", lowerButtonState);
                    request.setAttribute("higherButtonState", higherButtonState);
                    request.setAttribute("winMessage", winMessage);
                    request.setAttribute("count", count);
                    
                    int bal = user.getBalance() + 0;
                    db.updateBalance(user, bal, 0 ,3);
                    user = db.getUser(user.getUserName());
                    session.setAttribute("user", user);
                                        
                         getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
                }
                else
                {
                    count = 2;
                    winMessage = "You lose!";
                    
                    playButtonState = "";
                    lowerButtonState = "disabled";
                    higherButtonState = "disabled";
                    
                    request.setAttribute("playButtonState", playButtonState);
                    request.setAttribute("lowerButtonState", lowerButtonState);
                    request.setAttribute("higherButtonState", higherButtonState);
                    request.setAttribute("winMessage", winMessage);
                    request.setAttribute("count", count);
                    
                    int bal = user.getBalance() - 10;
                    db.updateBalance(user, bal, -10 ,3);
                    user = db.getUser(user.getUserName());
                    session.setAttribute("user", user);

                    
                    
                         getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
                }
            }

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
