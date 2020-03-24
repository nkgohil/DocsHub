package thesevenitsolutions.com.docshub.pojo;

public class user {
    private String name, email,mobile, username,token,password,confirm_password;
private Integer regid=10;
    public user(String name, String s, Integer regid, String mobile, String password, String email, String username) {
        this.email = email;
        this.username = username;
    }

    public user(String name, String email, String mobile, String username, String password, String confirm_password, Integer regid) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.username = username;
        this.password = password;
        this.confirm_password = confirm_password;
        this.regid = regid;
    }

    public user(String email, String token, String password) {
        this.email = email;
        this.token = token;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public Integer getRegid() {
        return regid;
    }

    public void setRegid(Integer regid) {
        this.regid = regid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
