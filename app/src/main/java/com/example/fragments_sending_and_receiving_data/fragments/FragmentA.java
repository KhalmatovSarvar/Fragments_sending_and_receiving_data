package com.example.fragments_sending_and_receiving_data.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragments_sending_and_receiving_data.R;
import com.example.fragments_sending_and_receiving_data.model.Member;

public class FragmentA extends Fragment {
    private FragmentAListener listener;
    private EditText editText;
    private Button button;

    public interface FragmentAListener{
        void sendMessageToFragmentB(Member member);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);

        editText = view.findViewById(R.id.edt_a);
        button = view.findViewById(R.id.btn_a);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Member member = new Member("Sarvar",21,'M');
                listener.sendMessageToFragmentB(member);
            }
        });
        return view;
    }

    public void updateText(Member member){
        editText.setText(member.toString());
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentAListener){
            listener = (FragmentAListener) context ;
        }else {
            throw new RuntimeException(context.toString()+ "must implement FragmentAListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
