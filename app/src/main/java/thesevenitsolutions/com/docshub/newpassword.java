package thesevenitsolutions.com.docshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class newpassword extends AppCompatActivity {
    EditText newpassword,confirm_password;
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
    }

    private void setevent() {
        submitpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });

    }
    private boolean validate(){
        boolean temp=true;
        String pass=newpassword.getText().toString();
        String cpass=confirm_password.getText().toString();
         if(!pass.equals(cpass)){
            Toast.makeText(newpassword.this,"Password Not matching",Toast.LENGTH_SHORT).show();
            temp=false;
        }
         else{
             Toast.makeText(newpassword.this,"Password Matching",Toast.LENGTH_SHORT).show();
         }
        return temp;
    }
}
