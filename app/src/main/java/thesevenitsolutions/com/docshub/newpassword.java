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
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class newpassword extends AppCompatActivity {
    EditText newpassword,confirm_password,oldpassword;
    Button submitpass;
    Context ctx=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpassword);
       allocatememory();
       setevent();
    }

    private void allocatememory() {

        newpassword=findViewById(R.id.newpassword);
        confirm_password=findViewById(R.id.confirm_password);
        submitpass=findViewById(R.id.submitpass);
        oldpassword=findViewById(R.id.oldpassword);
    }

    private void setevent() {
        submitpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    changepass();
                }
            }
        });

    }

    private void changepass() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("ONE MOMENT PLEASE");
        progressDialog.show();

        String oldpass=oldpassword.getText().toString().trim();
        String newpass=newpassword.getText().toString().trim();
        String conpass=confirm_password.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(common.getbaseurl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterface service = retrofit.create(apiInterface.class);
        user user= new user(oldpass,newpass,conpass);
        Call<user_signup> call = service.changepassword(
                user.getPassword(),
                user.getNew_password(),
                user.getConfirm_password());
        call.enqueue(new Callback<user_signup>() {
            @Override
            public void onResponse(Call<user_signup> call, Response<user_signup> response) {
                progressDialog.dismiss();
                assert response.body() != null;
                if(response.body().isStatus()){
                    Toast.makeText(ctx,response.body().getMessage(),Toast.LENGTH_LONG).show();
                }
                else
                    Toast.makeText(ctx,response.body().getMessage(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<user_signup> call, Throwable t) {
                Toast.makeText(ctx,"No Response From The Server",Toast.LENGTH_LONG).show();
            }
        });
    }

    private boolean validate(){
        boolean temp=true;
        String pass=newpassword.getText().toString().trim();
        String cpass=confirm_password.getText().toString().trim();
         if(!pass.matches(cpass)){
            newpassword.setError("Password Does Not Match");
        temp=false;
        }
         else if(oldpassword.length()<8)
             oldpassword.setError("Password Should be 8 Character Long");
        return temp;
    }
}
