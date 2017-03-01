package co.planis.behappylesson2;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements LoginFragment.OnFragmentInteractionListener {

    @BindView(R.id.activity_main_pager)
    ViewPager activityMainPager;


    MainPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViewPager();
    }

    private void initViewPager() {
        adapter = new MainPagerAdapter(getSupportFragmentManager());


        activityMainPager.setAdapter(adapter);

    }


    @Override
    public void loggedIn() {

    }

    @Override
    public void onPasswordForgot() {

    }
}
