package co.planis.behappylesson2;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class LoginFragment extends Fragment {


    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;
    Unbinder unbinder;
    private OnFragmentInteractionListener mListener;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.loginBtn)
    public void onClick() {
        String properEmail = "admin@behappy.io";
        String properPassword = "alamakota123";

        if (!properEmail.equals(email.getText().toString())) {
            Snackbar.make(email, "Błędny email", Snackbar.LENGTH_INDEFINITE).setAction("Wyczyść", new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    email.setText("");
                }
            }).show();
        } else if (!properPassword.equals(password.getText().toString())) {
            Toast.makeText(getContext(), "Błędne hasło", Toast.LENGTH_SHORT).show();
        } else {
            mListener.loggedIn();
        }
    }

    @OnClick(R.id.forgotPasswordBtn)
    public void forgotPassword() {
        mListener.onPasswordForgot();
    }


    public interface OnFragmentInteractionListener {
        void loggedIn();
        void onPasswordForgot();
    }
}
