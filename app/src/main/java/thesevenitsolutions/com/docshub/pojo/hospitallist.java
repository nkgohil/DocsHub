package thesevenitsolutions.com.docshub.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class hospitallist {

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
    private hospital data;

    @SerializedName("error")
    @Expose
    private String error;


    public hospitallist(boolean status, Integer code, String message, hospital data, String error) {
        this.status = status;
        this.code = code;
        this.message = message;
        this.data = data;
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
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

    public hospital getData() {
        return data;
    }

    public void setData(hospital data) {
        this.data = data;
    }
}
