package thesevenitsolutions.com.docshub.pojo;

public class user2 {
    private String userName,password,token,username,email;

    public user2(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public user2( String username, String email,String token) {

        this.username = username;
        this.email = email;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
