package thesevenitsolutions.com.docshub;

import androidx.appcompat.app.ActionBar;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import thesevenitsolutions.com.docshub.pojo.user;
import thesevenitsolutions.com.docshub.pojo.user_signup;

public class homescreen extends AppCompatActivity {
    BottomNavigationView bottomNavigation;
    Context ctx=this;
    ImageView imghos,imgdoc,imgdepartment,imgappoint;
    DrawerLayout d1;
    TextView userchange;
    ActionBarDrawerToggle abdt;
    Toolbar toolbar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        allocatememory();
        navview();
        setevent();


    }

    private void navview() {
        setSupportActionBar(toolbar);
        abdt=new ActionBarDrawerToggle(this,d1,R.string.open,R.string.close);
        abdt.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        abdt.setHomeAsUpIndicator(R.mipmap.navbutton);
        d1.addDrawerListener(abdt);
        abdt.syncState();
        NavigationView navview=findViewById(R.id.nav_view);
        navview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int items = item.getItemId();
                switch (items){

                    case R.id.myappoint:
                        break;

                    case R.id.mydoc:
                        break;

                    case R.id.healthblog:
                        break;
                    case R.id.setting:
                        startActivity(new Intent(ctx,SettingsActivity.class));

                        break;
                    case R.id.logout:
                        new AlertDialog.Builder(ctx).setTitle("LOGOUT").setMessage("Are you sure You want to Logout?").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                logout();
                            }
                        }).setNegativeButton("CANCLE",null).setIcon(R.mipmap.logout).show();
                        break;
                }
                return false;
            }
        });
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

    private void logout() {
        if(prefrence.getInstance(ctx).isLoggedIn()) {
            prefrence.getInstance(ctx).logout();
            apiInterface service = apIclient.getClient().create(apiInterface.class);

            Call<user_signup> call = service.logout();

            call.enqueue(new Callback<user_signup>() {
                @Override
                public void onResponse(Call<user_signup> call, Response<user_signup> response) {
                    if (response.body().getError() != null) {
                        Log.d("Logout", response.body().getError().toString());
                    } else {
                        if (prefrence.getInstance(ctx).isLoggedIn()){
                            startActivity(new Intent(ctx, login.class));
                        finish();
                        Toast.makeText(ctx, "LOGOUT Successfully!", Toast.LENGTH_LONG).show();
                    }
                        else{
                            Toast.makeText(ctx, "Please LogIn First", Toast.LENGTH_LONG).show();

                        }
                    }

                }

                @Override
                public void onFailure(Call<user_signup> call, Throwable t) {

                }
            });

        }

    }

    private void allocatememory() {
        imghos= findViewById(R.id.imgfindhos);
        imgdoc= findViewById(R.id.imgfinddoc);
        imgdepartment= findViewById(R.id.imgdepartment);
        imgappoint= findViewById(R.id.imgappoint);
        userchange=findViewById(R.id.txtuserchange);
        d1=findViewById(R.id.drawer);
        toolbar=findViewById(R.id.toolbar);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return abdt.onOptionsItemSelected(item)|| super.onOptionsItemSelected(item);
    }

}
