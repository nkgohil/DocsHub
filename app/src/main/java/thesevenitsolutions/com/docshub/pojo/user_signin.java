package thesevenitsolutions.com.docshub.pojo;
import com.google.gson.annotations.SerializedName;

public class user_signin {

    @SerializedName("status")
    private boolean status;
    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private user2 data;
    @SerializedName("error")
    private user2 error;

    public user_signin(boolean status, Integer code, String message, user2 data,user2 error) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
        this.error=error;
    }


    public user2 getError() {
        return error;
    }

    public void setError(user2 user) {
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

    public user2 getData() {
        return data;
    }

    public void setData(user2 data) {
        this.data = data;
    }

}
