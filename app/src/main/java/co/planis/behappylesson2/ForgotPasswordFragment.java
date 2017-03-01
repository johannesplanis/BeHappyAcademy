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


public class ForgotPasswordFragment extends Fragment {

    @BindView(R.id.etEmail)
    EditText etEmail;

    Unbinder unbinder;
    private OnFragmentInteractionListener mListener;

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

    @OnClick(R.id.btnReset)
    public void onClick() {
        String message;

        String goodEmail = "admin@behappy.io";

        if (!goodEmail.equals(etEmail.getText().toString())){
            message = "Nieprawidłowy adres email";
            etEmail.setText("");
        }else{
            message = "Wysłano nowe hasło na adres: ".concat(etEmail.getText().toString());
            mListener.passwordSent();
        }
        Toast.makeText(getContext(),message,Toast.LENGTH_SHORT).show();
    }

    public interface OnFragmentInteractionListener {
        void passwordSent();

    }
}
