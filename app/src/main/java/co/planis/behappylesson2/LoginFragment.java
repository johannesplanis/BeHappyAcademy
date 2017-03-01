package co.planis.behappylesson2;

import android.content.Context;
import android.os.Bundle;
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

    @BindView(R.id.etEmail)
    EditText etEmail;
    @BindView(R.id.etPassword)
    EditText etPassword;
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

    @OnClick(R.id.btnLogin)
    public void onLoginClick() {
        String message;

        String goodEmail = "admin@behappy.io";
        String goodPassword = "alamakota123";

        if (!goodEmail.equals(etEmail.getText().toString())) {
            message = "Nieprawidłowy adres email";
            etEmail.setText("");
            etPassword.setText("");
        } else if (!goodPassword.equals(etPassword.getText().toString())) {
            message = "NIeprawidłowe hasło";
            etPassword.setText("");
        } else {
            message = "Zalogowano";
            mListener.loggedIn();
        }
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.tvForgotPassword)
    public void onForgotPasswordClick() {
        mListener.onForgotPasswordClicked();
    }


    public interface OnFragmentInteractionListener {
        void loggedIn();

        void onForgotPasswordClicked();
    }
}
