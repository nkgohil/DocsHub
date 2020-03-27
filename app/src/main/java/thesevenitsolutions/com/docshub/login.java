package thesevenitsolutions.com.docshub;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import thesevenitsolutions.com.docshub.pojo.user2;
import thesevenitsolutions.com.docshub.pojo.user_signin;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.astritveliu.boom.Boom;

import java.io.IOException;


public class login extends AppCompatActivity {
    Button button;
    Context ctx=this;
    TextView txtsignup;
    EditText usernamelog,passwordlog;
    TextView usernamechange;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        allocatememory();
        setevent();
    }

    private void setevent() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateinput()){
                    loginuser();

                }
            }
        });
        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signinintent=new Intent(ctx,signup.class);
                startActivity(signinintent);

            }
        });
    }

    private void loginuser() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("ONE MOMENT PLEASE");
        progressDialog.show();

        String userName=usernamelog.toString().trim();
        String password=passwordlog.toString().trim();

        apiInterface service = apIclient.getClient().create(apiInterface.class);

        user2 user2= new user2(userName,password);

        Call<user_signin>call = service.loginUser(user2.getUserName(),user2.getPassword());

        call.enqueue(new Callback<user_signin>() {
            @Override
            public void onResponse(Call<user_signin> call, Response<user_signin> response) {
                progressDialog.dismiss();
                if(response.body()==null){
                    try {
                        Toast.makeText(ctx,response.errorBody().string(),Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    if(response.body().isStatus()) {
                        prefrence.getInstance(ctx).userLogin(response.body().getData());
                        Log.d("signin", response.body().getData().getToken());
                        startActivity(new Intent(ctx, homescreen.class));
                        finish();
                        Toast.makeText(ctx, "success:" + response.body().getMessage(), Toast.LENGTH_LONG).show();
                    }
                    else
                        Toast.makeText(ctx,"error"+ response.body().getError().getUserName(),Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<user_signin> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(ctx,t.getMessage(),Toast.LENGTH_LONG).show();

            }

        });
    }

    private boolean validateinput() {
        String password = passwordlog.toString().trim();
        String username = usernamelog.toString().trim();
        boolean isvalid = true;
        if (username.length() == 0){
            usernamelog.setError("Please Enter Username!");
            isvalid = false;
        }
        else if(password.length()<8) {
            passwordlog.setError("Password Should Be Minimum 8 char Long!");
            isvalid = false;
        }

        return isvalid;
    }


    private void allocatememory() {
        button=findViewById(R.id.login);
        new Boom(button);
        txtsignup=findViewById(R.id.txtsignup);
        usernamelog=findViewById(R.id.txtusernamelog);
        passwordlog=findViewById(R.id.passwordlog);
        usernamechange=findViewById(R.id.txtuserchange);
    }
}
