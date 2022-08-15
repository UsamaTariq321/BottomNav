package com.example.bottomnav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;

import com.example.bottomnav.databinding.ActivityMainBinding;

import javax.net.ssl.HostnameVerifier;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.BottonNavBar.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case  R.id.Home:
                    ReplaceFragment(new HomeFragment());
                    break;
                case  R.id.Menu:
                    ReplaceFragment(new MusicFragment());
                    break;
                case  R.id.Notification:
                    ReplaceFragment(new GroupAddFragment());
                    break;
            }
            return  true;
        });



    }
    private  void ReplaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.BottomNavFragment,fragment);
        fragmentTransaction.commit();
    }
}