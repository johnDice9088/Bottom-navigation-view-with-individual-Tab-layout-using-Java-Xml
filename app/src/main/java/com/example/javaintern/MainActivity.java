package com.example.javaintern;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
//import com.example.javaintern.viewbinding.databinding.ActivityMainBinding;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {




  //  private ViewPager viewPager;
 //   private FrameLayout frame;
//  private BottomNavigationView bottomNavigationView;







 //   @SuppressLint("NonConstantResourceId")
 BottomNavigationView bottomNavigationView;








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);







    //    BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment = null;
                Fragment home = homeFragment.getInstance();
         //       Fragment net = networkFragment.getInstance();
          //      Fragment search = searchFragment.getInstance();

                switch (item.getItemId())   {
                    case 0:
                        final Fragment home1 = home;
                        break;

                    case 1:
                        final Fragment home2 = networkFragment.getInstance();
                        break;

                    case 2:
                        final Fragment home3 = searchFragment.getInstance();
                        break;


                }

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.main_frame,home);
             //   transaction.replace(R.id.main_frame,net);
            //    transaction.replace(R.id.main_frame,search);
                transaction.commit();
                return false;
            }
        });
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_frame,homeFragment.getInstance());
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu flter){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.filter,flter);
        return super.onCreateOptionsMenu(flter);
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if(id==R.id.filter){
            Intent intent = new Intent(MainActivity.this, filteract.class);
            startActivity(intent);
            return true;

        }
        return super.onOptionsItemSelected(item);
    }


}