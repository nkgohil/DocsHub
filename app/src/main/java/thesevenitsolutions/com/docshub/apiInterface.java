package thesevenitsolutions.com.docshub;
import java.util.List;

import retrofit2.http.FormUrlEncoded;
import thesevenitsolutions.com.docshub.pojo.user_signup;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface apiInterface {
        @FormUrlEncoded
        @POST("register")
        Call<user_signup> createUser(@Field("name")String name,
                                     @Field("username")String username,
                                     @Field("password")String password,
                                     @Field("mobile")String mobile,
                                     @Field("email")String email);

        @FormUrlEncoded
        @POST("login")
        Call<user_signup> loginUser(@Field("userid") String username,
                                    @Field("password") String password);
    }

