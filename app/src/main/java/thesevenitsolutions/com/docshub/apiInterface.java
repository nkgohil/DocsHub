package thesevenitsolutions.com.docshub;
import java.util.List;

import retrofit2.Callback;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import thesevenitsolutions.com.docshub.pojo.user;
import thesevenitsolutions.com.docshub.pojo.user_signin;
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
        Call<user_signup> loginUser(@Field("userName") String userName,
                                        @Field("password") String password);

        @FormUrlEncoded
        @POST("change-password")
        Call<user_signup> changepassword(@Field("old_password") String old_password,
                                        @Field("new_password") String new_password,
                                        @Field("confirm_password") String confirm_password);

        @GET("logout")
        Call<user_signup> logout();
}

