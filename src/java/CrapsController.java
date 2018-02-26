
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
        
        if(playButton != null)
        {            
            message = cm.firstRoll(die1, die2);
            
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

                url = "/craps.jsp";

                getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
            }
            else if(message.equalsIgnoreCase("lost")){
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


                url = "/craps.jsp";

                getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
            }
            else if(message.equalsIgnoreCase("continue")){
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
        else if(rollButton.equalsIgnoreCase("Roll")){
            
            int myPoint = (int) session.getAttribute("myPoint");
            cm.setPoint(myPoint);
            
            message = cm.rollAgain(die1, die2);
            
            if(message.equalsIgnoreCase("won")){
                die1ImageURL = die1.getImageURL();
                die2ImageURL = die2.getImageURL();
                
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
                
                playButton = "";
                rollButton = "";
                
                url = "/craps.jsp";

                getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
            }
            else if(message.equalsIgnoreCase("lost")){
                die1ImageURL = die1.getImageURL();
                die2ImageURL = die2.getImageURL();
                
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

                playButton = "";
                rollButton = "";
                
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
