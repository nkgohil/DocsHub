package thesevenitsolutions.com.docshub;
import retrofit2.Call;
import retrofit2.http.GET;
public interface SpinnerInterface {

        String JSONURL = "https://demonuts.com/Demonuts/JsonTest/Tennis/";
        @GET("json_parsing.php")
        Call<String> getJSONString();
    }

