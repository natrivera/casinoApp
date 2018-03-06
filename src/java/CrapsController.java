
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CrapsController extends HttpServlet
{


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {      
        //Declare variables and set them to defaults
        HttpSession session = request.getSession();
        CrapsModel cm = new CrapsModel();
        Die die1 = new Die();
        Die die2 = new Die();
        String playButton = (String) request.getParameter("playButton");
        String rollButton = (String) request.getParameter("rollButton");
        String playButtonState = "";
        String rollButtonState = "disabled";
        String message = "";
        String url = "";   
        String pointDie1Image = "";
        String pointDie2Image = "";
        String die1ImageURL = "";
        String die2ImageURL = ""; 

        //Makes a user from the user session and a CasinoDB instance is created to write to the database
        User user = (User) session.getAttribute("user");
        CasinoDB db = new CasinoDB();
        
        //If the playbutton is selected then it runs the first roll method from the CrapsModel class in order to retrieve two random dices and display them to the craps.jsp
        if(playButton != null)
        {            
            message = cm.firstRoll(die1, die2);
            
            //Uses the message variable from above to retrieve whether the user won, lost, or can continue
            //If the user wins, then it sends appropiate information to the craps.jsp, this is the same for if the player loses
            //If the player rolled a continue then the user is asked to click on the roll button until the player loses or wins
            if(message.equalsIgnoreCase("won")){
                die1ImageURL = die1.getImageURL();
                die2ImageURL = die2.getImageURL();
                pointDie2Image = "img/blank_1.png";
                pointDie1Image = "img/blank_1.png";
                
                request.setAttribute("die1ImageURL", die1ImageURL);
                request.setAttribute("die2ImageURL", die2ImageURL);
                request.setAttribute("pointDie1Image", pointDie1Image);
                request.setAttribute("pointDie2Image", pointDie2Image);
                request.setAttribute("playButtonState", playButtonState);
                request.setAttribute("rollButtonState", rollButtonState);
                request.setAttribute("message", "You won! Click Play to play again!");
                
                playButton = "";
                rollButton = "";
                
                int bal = user.getBalance() + 10;
                db.updateBalance(user, bal, 10 ,2);
                user = db.getUser(user.getUserName());
                session.setAttribute("user", user);

                url = "/craps.jsp";

                getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
            }
            else if(message.equalsIgnoreCase("lost")){ //Checks if the user lost
                die1ImageURL = die1.getImageURL();
                die2ImageURL = die2.getImageURL();
                pointDie2Image = "img/blank_1.png";
                pointDie1Image = "img/blank_1.png";
                
                request.setAttribute("die1ImageURL", die1ImageURL);
                request.setAttribute("die2ImageURL", die2ImageURL);
                request.setAttribute("pointDie1Image", pointDie1Image);
                request.setAttribute("pointDie2Image", pointDie2Image);
                request.setAttribute("playButtonState", playButtonState);
                request.setAttribute("rollButtonState", rollButtonState);
                request.setAttribute("message", "You lost! Click Play to play again!");
                
                playButton = "";
                rollButton = "";

                int bal = user.getBalance() - 10;
                db.updateBalance(user, bal, -10 ,2);
                user = db.getUser(user.getUserName());
                session.setAttribute("user", user);

                url = "/craps.jsp";

                getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
            }
            else if(message.equalsIgnoreCase("continue")){//checks if the user can continue 
                pointDie1Image = die1.getImageURL();
                pointDie2Image = die2.getImageURL();                

                die1ImageURL = "img/blank_1.png";
                die2ImageURL = "img/blank_1.png";
                
                playButtonState = "disabled";
                rollButtonState = "";
                
                session.setAttribute("myPoint", cm.getPoint());
                session.setAttribute("pointDie1Image", pointDie1Image);
                session.setAttribute("pointDie2Image", pointDie2Image);
                
                request.setAttribute("pointDie1Image", pointDie1Image);
                request.setAttribute("pointDie2Image", pointDie2Image);
                request.setAttribute("die1ImageURL", die1ImageURL);
                request.setAttribute("die2ImageURL", die2ImageURL);
                request.setAttribute("message", "Roll again.");
                session.setAttribute("playButtonState", playButtonState);
                request.setAttribute("rollButtonState", rollButtonState);
                
                playButton = "";
                rollButton = "";
                               
                url = "/craps.jsp";

                getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
                
            }
        }
        else if(rollButton.equalsIgnoreCase("Roll")){//checks if the rollbutton from craps.jsp is clicked and sends the information to the craps.jsp
            
            int myPoint;
            
            if(session.getAttribute("mypoint") == null)
            {
                myPoint = 0;
            }
            else
            {
                myPoint = (int) session.getAttribute("myPoint");

            }
            
            cm.setPoint(myPoint);
            
            message = cm.rollAgain(die1, die2);
            
            if(message.equalsIgnoreCase("won")){
                die1ImageURL = die1.getImageURL();
                die2ImageURL = die2.getImageURL();
                session.removeAttribute("playButtonState");

                
                playButtonState = "";
                rollButtonState = "disabled";
                
                request.setAttribute("pointDie1Image", session.getAttribute("pointDie1Image"));
                request.setAttribute("pointDie2Image", session.getAttribute("pointDie2Image"));
                request.setAttribute("die1ImageURL", die1ImageURL);
                request.setAttribute("die2ImageURL", die2ImageURL);
                request.setAttribute("playButtonState", playButtonState);
                request.setAttribute("rollButtonState", rollButtonState);
                request.setAttribute("message", "You won! Click Play to play again!");
                
                session.removeAttribute("myPoint");
                session.removeAttribute("pointDie1Image");
                session.removeAttribute("pointDie2Image");
                
                playButton = "";
                rollButton = "";
                
                url = "/craps.jsp";
                
                int bal = user.getBalance() + 10;
                db.updateBalance(user, bal, 10 ,2);
                user = db.getUser(user.getUserName());
                session.setAttribute("user", user);

                getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
            }
            else if(message.equalsIgnoreCase("lost")){
                die1ImageURL = die1.getImageURL();
                die2ImageURL = die2.getImageURL();
                session.removeAttribute("playButtonState");

                
                playButtonState = "";
                rollButtonState = "disabled";
                
                request.setAttribute("pointDie1Image", session.getAttribute("pointDie1Image"));
                request.setAttribute("pointDie2Image", session.getAttribute("pointDie2Image"));
                request.setAttribute("die1ImageURL", die1ImageURL);
                request.setAttribute("die2ImageURL", die2ImageURL);
                request.setAttribute("playButtonState", playButtonState);
                request.setAttribute("rollButtonState", rollButtonState);
                request.setAttribute("message", "You lost! Click Play to play again!");
                
                session.removeAttribute("myPoint");
                session.removeAttribute("pointDie1Image");
                session.removeAttribute("pointDie2Image");

                playButton = "";
                rollButton = "";
                
                int bal = user.getBalance() - 10;
                db.updateBalance(user, bal, -10 ,2);
                user = db.getUser(user.getUserName());
                session.setAttribute("user", user);
                
                url = "/craps.jsp";

                getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
            }
            else if(message.equalsIgnoreCase("continue")){
                die1ImageURL = die1.getImageURL();
                die2ImageURL = die2.getImageURL(); 
                
                playButtonState = "disabled";
                rollButtonState = "";
                               
                
                request.setAttribute("pointDie1Image", session.getAttribute("pointDie1Image"));
                request.setAttribute("pointDie2Image", session.getAttribute("pointDie2Image"));
                request.setAttribute("die1ImageURL", die1ImageURL);
                request.setAttribute("die2ImageURL", die2ImageURL);
                request.setAttribute("message", "Roll again.");
                request.setAttribute("playButtonState", playButtonState);
                request.setAttribute("rollButtonState", rollButtonState);
                
                playButton = "";
                rollButton = "";
               
                url = "/craps.jsp";

                getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
            }
            

        }          
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
