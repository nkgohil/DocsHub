package thesevenitsolutions.com.docshub.pojo;

public class user {

private String name,username,password,email,mobile,token,userName,new_password,confirm_password,userid;


    public user(String name, String username, String email, String mobile, String password) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
    }

    public user(String password, String new_password, String confirm_password) {
        this.password = password;
        this.new_password = new_password;
        this.confirm_password = confirm_password;
    }

    public user(String name, String email, String mobile, String token) {
            this.name=name;
            this.email=email;
            this.mobile=mobile;
            this.token=token;
    }

    public user(String userName, String password) {
        this.userName = userName;
        this.password=password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirm_password = confirm_password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}