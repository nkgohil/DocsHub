package thesevenitsolutions.com.docshub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class homescreen extends AppCompatActivity {

    Context ctx=this;
    ImageView imghos,imgdoc,imgdepartment,imgappoint;
    apiInterface apiInterface;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        allocatememory();
        setevent();

    }

    private void setevent() {
        imgdoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent finddocintent=new Intent(ctx,finddoctor.class);
                startActivity(finddocintent);
            }
        });
        imghos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent findhosintent=new Intent(ctx,findhospital.class);
                startActivity(findhosintent);
            }
        });
        imgappoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent appointintent= new Intent(ctx,finddoctor.class);
                startActivity(appointintent);
            }
        });
        imgdepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent departmentintent=new Intent(ctx,department.class);
                startActivity(departmentintent);
            }
        });
    }

    private void allocatememory() {
        imghos= findViewById(R.id.imgfindhos);
        imgdoc= findViewById(R.id.imgfinddoc);
        imgdepartment= findViewById(R.id.imgdepartment);
        imgappoint= findViewById(R.id.imgappoint);

    }

}
