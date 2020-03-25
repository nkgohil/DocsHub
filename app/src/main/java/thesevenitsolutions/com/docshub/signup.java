package thesevenitsolutions.com.docshub;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import thesevenitsolutions.com.docshub.pojo.user;
import thesevenitsolutions.com.docshub.pojo.user_signup;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class signup extends AppCompatActivity {

    EditText txtname,txtemail,txtmobile,txtpassword,txtconfirmpassword,txtusername;
    Button btnsignup;
    TextView txtsignin;
    Context ctx=this;
    prefrence SharedPrefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        allocatememory();
        setevent();

    }


    private void setevent() {
        txtsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logintent=new Intent(ctx,login.class);
                startActivity(logintent);
            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  signup_user();
            }
        });
        ScrollView scrollView;
       scrollView=findViewById(R.id.scroll);
        scrollView.post(new Runnable()
        {
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_UP);
            }
        });
    }

    private void signup_user() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.show();

        String name = txtname.getText().toString().trim();
        String email = txtemail.getText().toString().trim();
        String mobile = txtmobile.getText().toString().trim();
        String password = txtpassword.getText().toString().trim();
      //  String confirm_password = txtconfirmpassword.getText().toString().trim();
        String username =txtusername.getText().toString().trim();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(common.getbaseurl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface service = retrofit.create(apiInterface.class);
        Integer regid=10;
        user user = new user(name,username,email,mobile,password);
        Call<user_signup> call = service.createUser(
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                user.getMobile(),
                user.getPassword());
        call.enqueue(new Callback<user_signup>() {
            @Override
            public void onResponse(Call<user_signup> call, Response<user_signup> response) {
                progressDialog.dismiss();
                assert response.body() != null;
                Toast.makeText(signup.this,response.body().getMessage(), Toast.LENGTH_SHORT).show();
                if(response.body().getData().getToken()!=null){
                    prefrence.getInstance(ctx).userLogin(response.body().getData());
                    Intent homeintent=new Intent(ctx,homescreen.class);
                    startActivity(homeintent);
                    Toast.makeText(ctx,response.body().getData().getUsername(),Toast.LENGTH_LONG).show();


                }
                else{
                    Toast.makeText(ctx, (CharSequence) response.body().getError(),Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<user_signup> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(ctx,"no response from server", Toast.LENGTH_LONG).show();

            }
        });
    }

            private void allocatememory() {
        txtname=findViewById(R.id.txtname);
        txtemail=findViewById(R.id.txtemail);
        txtmobile=findViewById(R.id.txtmobileno);
        txtpassword=findViewById(R.id.txtpassword);
        btnsignup=findViewById(R.id.btnsignup);
        txtusername=findViewById(R.id.txtusername);
        txtsignin=findViewById(R.id.txtsignin);
    }
}
