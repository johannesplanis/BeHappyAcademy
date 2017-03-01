package co.planis.behappylesson2;

import android.print.PageRange;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johannesplanis on 01/03/2017.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {


    List<Fragment> fragments = new ArrayList<>();

    MainPagerAdapter(FragmentManager manager){
        super(manager);

        fragments.add(new LoginFragment());
        fragments.add(new ForgotPasswordFragment());
    }
    @Override
    public int getCount() {
        return fragments.size();
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
}
