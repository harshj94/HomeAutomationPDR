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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import jain.autorotatetesting.R;

/**
 * Created by harsh on 22-Mar-17.
 * Mobile: +91-916 800 4402
 */

public class ChangePassword extends Fragment {

    final String passkey = "jain.autorotatetesting.password";
    EditText password;
    RelativeLayout relativeLayout;
    Button button;
    TextView heading;
    int turn = 0;
    SharedPreferences prefs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.password, container, false);

        password = (EditText) view.findViewById(R.id.password);
        button = (Button) view.findViewById(R.id.save);
        heading = (TextView) view.findViewById(R.id.heading);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.relativeLayout);
        button.setVisibility(View.GONE);
        if (isAdded()) {
            prefs = getActivity().getSharedPreferences("jain.autorotatetesting", Context.MODE_PRIVATE);
        }
        final String passwordText = prefs.getString(passkey, "12345");

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (isAdded()) {
                    if (turn == 0 && passwordText.equals(charSequence.toString())) {
                        turn = 1;
                        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(password.getWindowToken(), 0);
                        password.setText("");
                        heading.setText("Enter new Password");
                        button.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefs.edit().putString(passkey, password.getText().toString()).apply();
                if (isAdded()) {
                    password.setText("");
                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(password.getWindowToken(), 0);
                    Toast.makeText(getActivity(), "Password Successfully changed", Toast.LENGTH_SHORT).show();
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_place, new ChangePassword());
                    fragmentTransaction.commit();
                }
            }
        });

        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(password.getWindowToken(), 0);
            }
        });

        return view;
    }
}