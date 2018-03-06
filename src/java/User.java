public class User
{
    private String name, username , password , dob , image;

    

    private int balance , currentWins , currentPlayed , userid , admin;
    
    //empty constructor
    User() {
    
        name = "";
        username = "";
        password = "";
        balance = 1000;
        currentWins = 0;
        currentPlayed = 0;
        dob = "1999-01-01";
        userid = 1;
        admin = 0;
        image = "./img/male.jpg";
    }

  
    
    User( String n , String u , String p , String d ) {
    
        name = n;
        username = u;
        password = p;
        balance = 1000;
        currentWins = 0;
        currentPlayed = 0;
        dob = d;
        userid = 1;
        admin = 0;
        image = "./img/male.jpg";
    }

    public void setAdmin(int admin)
    {
        this.admin = admin;
    }

    public int getAdmin()
    {
        return admin;
    }
    
    User( String n , int b , String u , int i) {
    
        name = n;
        username = u;
        password = "";
        balance = b;
        currentWins = 0;
        currentPlayed = 0;
        userid = i;
        admin = 0;
        image = "./img/male.jpg";
    }
    
    public void setImage(String image)
    {
        this.image = image;
    }

    public String getImage()
    {
        return image;
    }

    public void setUserid(int userid)
    {
        this.userid = userid;
    }

    public int getUserid()
    {
        return userid;
    }
    
    public void setDob(String dob)
    {
        this.dob = dob;
    }

    public String getDob()
    {
        return dob;
    }
    
      public String getUsername()
    {
        return username;
    }

    public void setCurrentWins(int currentWins)
    {
        this.currentWins = currentWins;
    }

    public void setCurrentPlayed(int currentPlayed)
    {
        this.currentPlayed = currentPlayed;
    }

    public int getCurrentWins()
    {
        return currentWins;
    }

    public int getCurrentPlayed()
    {
        return currentPlayed;
    }
    
    public void setName(String n) {
    
        name = n;
    }
    
    public String getName() {
    
        return name;
    }
    
    public void setUsername(String u) {
    
        username = u;
    }
    
    public String getUserName() {
    
        return username;
    }
    
    public void setPassword(String p) {
    
        password = p;
    }
    
    public String getPassword() {
    
        return password;
    }
    
    public String checkPassword(String p , User u) {
    
        return "l";
    }
    
    public int getBalance() {
    
        return balance;
    }
    
    public void setBalance(int i) {
    
        balance = i;
    }
    
    public void updateBalance( int n) {
    
        balance += n;
    }
}
