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


public class ForgotPasswordFragment extends Fragment {


    @BindView(R.id.email)
    EditText email;

    Unbinder unbinder;

    public ForgotPasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forgot_password, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

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
        } else {
        }
    }


}
