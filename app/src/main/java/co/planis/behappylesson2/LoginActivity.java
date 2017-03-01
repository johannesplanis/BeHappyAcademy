package co.planis.behappylesson2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity implements LoginFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportFragmentManager().beginTransaction().add(R.id.login_activity_container,new LoginFragment()).commit();
    }

    @Override
    public void loggedIn() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    @Override
    public void onPasswordForgot() {
        getSupportFragmentManager().beginTransaction().replace(R.id.login_activity_container,new ForgotPasswordFragment())
                .addToBackStack("Forgot").commit();
    }
}
