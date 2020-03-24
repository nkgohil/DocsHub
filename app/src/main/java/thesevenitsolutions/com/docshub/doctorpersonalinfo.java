package thesevenitsolutions.com.docshub;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.astritveliu.boom.Boom;

public class doctorpersonalinfo extends AppCompatActivity {
    ImageView docpersonalinfo_back;
    Context ctx=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView(R.layout.activity_doctorpersonalinfo);
        allocatememory();
        setevent();

    }

    private void setevent() {
        docpersonalinfo_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ctx,doctorprofile.class);
                startActivity(intent);


            }
        });

    }

    private void allocatememory() {
        docpersonalinfo_back=findViewById(R.id.docpersonalinfo_back);
        new Boom(docpersonalinfo_back);

    }
}
