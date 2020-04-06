package thesevenitsolutions.com.docshub;
import java.util.List;

  import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import thesevenitsolutions.com.docshub.pojo.forgotpassword;
import thesevenitsolutions.com.docshub.pojo.hospitallist;
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


        @Headers("application:x-www-form-urlencoded,charset:UTF-8")
        @FormUrlEncoded
        @POST("login")
        Call<user_signup> loginUser(@Field("userName") String userName,
                                        @Field("password") String password);

        @FormUrlEncoded
        @POST("change-password")
        Call<user_signup> changepassword(@Field("old_password") String old_password,
                                        @Field("new_password") String new_password,
                                        @Field("confirm_password") String confirm_password);
        //@Headers("Authorization:Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9kZXYuZ2FsYXh5aW5mb3dheXMuY29tXC9kb2N0b3JzaHViXC9wdWJsaWNcL2FwaVwvbG9naW4iLCJpYXQiOjE1ODQ5NDkyMTQsImV4cCI6MzQ3NzEwOTIxNCwibmJmIjoxNTg0OTQ5MjE0LCJqdGkiOiJ5b2FCeDJtVzFPWm1CNkczIiwic3ViIjozNiwicHJ2IjoiODdlMGFmMWVmOWZkMTU4MTJmZGVjOTcxNTNhMTRlMGIwNDc1NDZhYSJ9.YOIGmH9LtteHByhGpD-eC9qlAyekaOkh5jjqigR7yl8")
        @GET("logout")
        Call<user_signup> logout(@Header("Authorization") String token);

      //  @Headers("Authorization:Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC8xOC4yMjMuMTQ5LjI0NVwvZG9jdG9yc2h1YlwvcHVibGljXC9hcGlcL2xvZ2luIiwiaWF0IjoxNTg1NjIzMzYyLCJleHAiOjM0Nzc3ODMzNjIsIm5iZiI6MTU4NTYyMzM2MiwianRpIjoiZFh4NEtzam1HakZzMUZBaSIsInN1YiI6NjksInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEifQ.ByWyfWKbtSKeST6wPhWtgKyYwYbqJAvqLoM45cGPAtc")
        @GET("hospitals/list")
        Call<hospitallist> gethospital(@Header("Authorization") String token, @Query("City") String city);

        @FormUrlEncoded
        @POST("user/reset-password-otp")
        Call<forgotpassword> sendotp(@Header("Authorization")String token,@Field("userid") String userid );
}

