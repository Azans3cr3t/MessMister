package com.example.android.login;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Members extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout d;
    ActionBarDrawerToggle drawerToggle;
    private int selectionId;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_members);
        toolbar = (Toolbar)findViewById(R.id.t_bar);
        setSupportActionBar(toolbar);
        d = (DrawerLayout) findViewById(R.id.d_lay);
        drawerToggle = new ActionBarDrawerToggle(this, d, toolbar,R.string.closed,R.string.open);
        d.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigationView = (NavigationView)findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        if(savedInstanceState == null)
            selectionId = R.id.item1;
        else
            selectionId = savedInstanceState.getInt("selection");
        tabLayout = (TabLayout)findViewById(R.id.t_layout);
        viewPager = (ViewPager)findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setTabsFromPagerAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_members, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent =  new Intent(this, Settings.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Intent intent = null;
        menuItem.setChecked(true);
        selectionId = menuItem.getItemId();
        if(menuItem.getItemId() == R.id.item1)
        {
            intent = new Intent(this, homepage.class);
        }
        else if(menuItem.getItemId() == R.id.item2)
        {
            d.closeDrawer(GravityCompat.START);
            return true;
        }
        else if(menuItem.getItemId() == R.id.item3)
        {
            intent = new Intent(this, Staff.class);
        }
        else if(menuItem.getItemId() == R.id.item4)
        {
            intent = new Intent(this, Bills.class);
        }
        else if(menuItem.getItemId() == R.id.item5)
        {
            intent = new Intent(this, Balance.class);
        }
        else if(menuItem.getItemId() == R.id.item6)
        {
            intent = new Intent(this, Help.class);
        }
        else if(menuItem.getItemId() == R.id.item7)
        {
            intent = new Intent(this, About.class);
        }
        d.closeDrawer(GravityCompat.START);
        startActivity(intent);
        finish();
        return false;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("selection", selectionId);
    }
    @Override
    public void onBackPressed() {
        if(d.isDrawerOpen(GravityCompat.START))
            d.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }





    public void create(View view)
    {
        Intent intent = new Intent(this, CreateMember.class);
        startActivity(intent);
    }


    public class PagerAdapter extends FragmentStatePagerAdapter
    {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }



        @Override
        public Fragment getItem(int position) {
            return MemberFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position == 0)
                return "LATE";
            else if(position == 1)
                return "DUE";
            else if(position == 2)
                return "ALL";
            else
                return "GROUPS";
        }
    }

    static public class MemberFragment extends Fragment
    {
        public static final java.lang.String ARG = "position";
        int position;

        public MemberFragment()
        {

        }

        public static MemberFragment newInstance(int pos)
        {
            MemberFragment m = new MemberFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(ARG, pos);
            m.setArguments(bundle);
            return m;
        }


        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            Bundle arguments = getArguments();
            position = arguments.getInt(ARG);
            TextView textview = new TextView(getActivity());
            textview.setText("hello " + position);
            return textview;
        }


    }

}

