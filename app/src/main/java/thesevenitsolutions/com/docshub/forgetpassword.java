package thesevenitsolutions.com.docshub;

import androidx.appcompat.app.AppCompatActivity;
import thesevenitsolutions.com.docshub.pojo.forgotpassword;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgetpassword extends AppCompatActivity {
    Button sendotp;
    Context ctx=this;
    EditText email;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);

        allocatememory();
        setevent();
    }

    private void setevent() {
        sendotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (validateinput()){

                forgotpassword();
            }

            }
        });

    }

    private void forgotpassword() {
       String emailpass=email.getText().toString().trim();
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("ONE MOMENT PLEASE");
        progressDialog.show();
       apiInterface service=apIclient.getClient().create(apiInterface.class);

        forgotpassword forgot= new forgotpassword(emailpass);

        Call<forgotpassword>call = service.sendotp(prefrence.getInstance(ctx).getTOken(),forgot.getUserid());

        call.enqueue(new Callback<forgotpassword>() {
            @Override
            public void onResponse(Call<forgotpassword> call, Response<forgotpassword> response) {
                progressDialog.dismiss();
                if(response.body()==null){

                    Toast.makeText(ctx,"There is something wrong!",Toast.LENGTH_LONG).show();
                }
                else {
                }
            }

            @Override
            public void onFailure(Call<forgotpassword> call, Throwable t) {
                progressDialog.dismiss();
            }
        });

    }

    private void allocatememory() {
        sendotp=findViewById(R.id.btnsendotp);
        email=findViewById(R.id.email);
    }
    public boolean validateinput()
    {
        boolean isvalid=true;
        if(email.getText().toString().isEmpty()) {
            email.setError("Email can't be empty!");
            isvalid=false;
        }
        else if(!email.getText().toString().matches(emailPattern)){
            email.setError("Please Enter valid email address!" +
                    "/n"+"Like abc@xyz.ab");
            isvalid=false;
        }
        return isvalid;
    }
}
