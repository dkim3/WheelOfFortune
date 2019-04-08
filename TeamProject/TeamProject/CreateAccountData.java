package TeamProject;

public class CreateAccountData
{
 private String username;
 private String password;
 
 // Getter
 public String getUsername() {return username;}
 public String getPassword() {return password;}
 
 // Setter
 public void setUsername(String username) {this.username = username;}
 public void setPassword(String password) {this.password = password;}

 // Constructor that initializes the username and password.
 public CreateAccountData(String username, String password)
 {
   setUsername(username);
   setPassword(password); 
 }
  
  
}
