package thesevenitsolutions.com.docshub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class homescreen extends AppCompatActivity {
    BottomNavigationView bottomNavigation;
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
        BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.tabhome:
                                startActivity(new Intent(ctx,homescreen.class));
                                return true;
                            case R.id.tabsearch:
                                startActivity(new Intent(ctx,finddoctor.class));
                                return true;
                            case R.id.tabappointment:
                                startActivity(new Intent(ctx,department.class));
                            return true;
                        }
                        return false;
                    }
                };
    }

    private void allocatememory() {
        imghos= findViewById(R.id.imgfindhos);
        imgdoc= findViewById(R.id.imgfinddoc);
        imgdepartment= findViewById(R.id.imgdepartment);
        imgappoint= findViewById(R.id.imgappoint);
        bottomNavigation = findViewById(R.id.bottom_navigation);

    }

}
