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
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class signup extends AppCompatActivity {
    EditText txtname,txtemail,txtmobile,txtpassword,txtconfirmpassword,txtusername;
    Button btnsignup;
    TextView txtsignin;
    Context ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        allocatememory();
        setevent();
        validate();
    }

    private void validate() {
        //String email=
    }

    private void setevent() {
        txtsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logintent=new Intent(ctx,login.class);
            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup_user();
            }
        });
    }

    private void signup_user() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Signing Up...");
        progressDialog.show();

        String name = txtname.getText().toString().trim();
        String email = txtemail.getText().toString().trim();
        String mobile = txtmobile.getText().toString().trim();
        String password = txtpassword.getText().toString().trim();
        String confirm_password = txtconfirmpassword.getText().toString().trim();
        String username =txtusername.getText().toString().trim();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(common.getbaseurl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface service = retrofit.create(apiInterface.class);
        Integer regid=10;
        user user = new user(name,password,regid,mobile,email,username,confirm_password);
        Call<user_signup> call = service.createUser(
               user.getName(),
                user.getPassword(),
                user.getRegid(),
                user.getMobile(),
                user.getEmail(),
                user.getUsername(),
                user.getConfirm_password());
        call.enqueue(new Callback<user_signup>() {
            @Override
            public void onResponse(Call<user_signup> call, Response<user_signup> response) {
                progressDialog.dismiss();
                Toast.makeText(signup.this,response.body().toString(), Toast.LENGTH_SHORT).show();
                if(response.body().status==true){
                    Intent homeintent=new Intent(ctx,homescreen.class);
                    startActivity(homeintent);
                }
                else{
                    Toast.makeText(ctx,"Something went Wrong",Toast.LENGTH_LONG).show();
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
        txtconfirmpassword=findViewById(R.id.txtconfirmpassword);
        btnsignup=findViewById(R.id.btnsignup);
        txtusername=findViewById(R.id.txtusername);
        txtsignin=findViewById(R.id.txtsignin);
    }
}
