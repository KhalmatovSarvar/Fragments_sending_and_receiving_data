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

public class FragmentB extends Fragment {
    private FragmentBListener listener;
    private EditText editText;
    private Button button;

    public interface FragmentBListener{
        void SendMessageToFragmentA(String text);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b,container,false);

        editText = view.findViewById(R.id.edt_b);
        button = view.findViewById(R.id.btn_b);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                listener.SendMessageToFragmentA(text);
            }
        });
    return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    if(context instanceof FragmentBListener){
        listener = (FragmentBListener) context;
    }else {
        throw new RuntimeException(context.toString()+" must implement FragmentAListener");
    }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    listener = null;
    }

public void updateText(String message){
        editText.setText(message);
}
}
