package jain.autorotatetesting.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import jain.autorotatetesting.R;

/**
 * Created by harsh on 22-Mar-17.
 * Mobile: +91-916 800 4402
 */

public class Password extends Fragment {

    EditText password;
    Button button;
    SharedPreferences prefs;
    final String passkey = "jain.autorotatetesting.password";
    String passwordText="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.password, container, false);

        password = (EditText) view.findViewById(R.id.password);
        button = (Button) view.findViewById(R.id.save);
        button.setVisibility(View.GONE);
        if(isAdded()) {
            prefs = getActivity().getSharedPreferences("jain.autorotatetesting", Context.MODE_PRIVATE);
            passwordText = prefs.getString(passkey, "12345");
        }

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (isAdded()) {
                    if (passwordText.equals(charSequence.toString())) {
                        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(password.getWindowToken(), 0);
                        FragmentManager fm = getActivity().getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_place, new BedRoom());
                        fragmentTransaction.commit();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }
}
