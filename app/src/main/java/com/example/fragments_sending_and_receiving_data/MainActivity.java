package com.example.fragments_sending_and_receiving_data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.fragments_sending_and_receiving_data.fragments.FragmentA;
import com.example.fragments_sending_and_receiving_data.fragments.FragmentB;
import com.example.fragments_sending_and_receiving_data.model.Member;

public class MainActivity extends AppCompatActivity implements FragmentA.FragmentAListener, FragmentB.FragmentBListener {
    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        fragmentA = new FragmentA();
        fragmentB = new FragmentB();

        getSupportFragmentManager().beginTransaction().replace(R.id.container_a, fragmentA).replace(R.id.container_b, fragmentB).commit();


    }

    @Override
    public void sendMessageToFragmentB(Member member) {
        fragmentB.updateText(member);
    }

    @Override
    public void SendMessageToFragmentA(String text) {

    }
}