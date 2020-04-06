package thesevenitsolutions.com.docshub.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class user_signup {
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private user data;
    @SerializedName("error")
    @Expose
    private user error;

    public user_signup(boolean status, Integer code, String message, user data,user error) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
        this.error=error;
    }

    public user getError() {
        return error;
    }

    public void setError(user error) {
        this.error = error;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public user getData() {
        return data;
    }

    public void setData(user data) {
        this.data = data;
    }
}
