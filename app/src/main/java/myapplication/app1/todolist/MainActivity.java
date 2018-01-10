package myapplication.app1.todolist;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import static android.R.attr.id;

public class MainActivity extends AppCompatActivity {

    TabLayout Tab;
    ViewPager ViewPg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Tab = (TabLayout) findViewById(R.id.Tab);
        ViewPg = (ViewPager) findViewById(R.id.View);

        ViewPg.setAdapter(new PagerAdapter(getSupportFragmentManager()));       //set the pageradapter
        Tab.setupWithViewPager(ViewPg);     //pager and tab in sync

        Tab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ViewPg.setCurrentItem(Tab.getSelectedTabPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    class PagerAdapter extends FragmentPagerAdapter{

        String title[] = {"TASKS","EVENTS","MEETINGS"};
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position==0)
                return new Tasks();

            if(position==1)
                return new Events ();

            if(position==2)
                return new Meetings();

            return null;
        }

        //size of the view pager
        @Override
        public int getCount() {
            return title.length;
        }


        //return the title associated with specified position
        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }
    }
}
