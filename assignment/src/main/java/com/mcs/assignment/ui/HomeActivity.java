package com.mcs.assignment.ui;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mcs.assignment.R;
import com.mcs.assignment.adapters.DrawerAdapter;
import com.mcs.assignment.pojos.DrawerItem;

import java.util.ArrayList;

/**
 * Activity class of MCS3106 Home,
 * Create navigation drawer here
 *
 * @author eranga herath(erangaeb@gmail.com)
 */
public class HomeActivity extends FragmentActivity {

    // UI components
    private ListView drawerListView;
    private DrawerLayout drawerLayout;
    private RelativeLayout drawerContainer;
    private HomeActionBarDrawerToggle homeActionBarDrawerToggle;

    // drawer components
    private ArrayList<DrawerItem> drawerItemList;
    private DrawerAdapter drawerAdapter;

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);

        initDrawer();
        initDrawerList();
        loadBook();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (homeActionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        homeActionBarDrawerToggle.syncState();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        homeActionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    /**
     * Initialize Drawer UI components
     */
    private void initDrawer() {
        // enable ActionBar app icon to behave as action to toggle nav drawer
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerContainer = (RelativeLayout) findViewById(R.id.drawer_container);

        // set custom sign out button
        TextView signOutTextView = (TextView) findViewById(R.id.sign_out_text);
        Typeface face = Typeface.createFromAsset(this.getAssets(), "fonts/vegur_2.otf");
        signOutTextView.setTypeface(face, Typeface.NORMAL);

        // set a custom shadow that overlays the main content when the drawer opens
        // set up drawer listener
        //drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        homeActionBarDrawerToggle = new HomeActionBarDrawerToggle(this, drawerLayout);
        drawerLayout.setDrawerListener(homeActionBarDrawerToggle);
    }

    /**
     * Initialize Drawer list
     */
    private void initDrawerList() {
        // initialize drawer content
        // need to determine selected item according to the currently selected
        drawerItemList = new ArrayList();
        drawerItemList.add(new DrawerItem("New Book", true));
        drawerItemList.add(new DrawerItem("New Publisher", false));
        drawerItemList.add(new DrawerItem("New Member", false));
        drawerItemList.add(new DrawerItem("Books", false));
        drawerItemList.add(new DrawerItem("Publishers", false));
        drawerItemList.add(new DrawerItem("Lending", false));

        drawerAdapter = new DrawerAdapter(HomeActivity.this, drawerItemList);
        drawerListView = (ListView) findViewById(R.id.drawer);

        if (drawerListView != null)
            drawerListView.setAdapter(drawerAdapter);

        drawerListView.setOnItemClickListener(new DrawerItemClickListener());
    }

    /**
     * Handle open/close behaviours of Navigation Drawer
     */
    private class HomeActionBarDrawerToggle extends ActionBarDrawerToggle {
        public HomeActionBarDrawerToggle(Activity mActivity, DrawerLayout mDrawerLayout) {
            super(mActivity, mDrawerLayout, R.drawable.ic_navigation_drawer, R.string.ns_menu_open, R.string.ns_menu_close);
        }

        @Override
        public void onDrawerClosed(View view) {
            invalidateOptionsMenu();
        }

        @Override
        public void onDrawerOpened(View drawerView) {
            invalidateOptionsMenu();
        }
    }

    /**
     * Drawer click event handler
     */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // Highlight the selected item, update the title, and close the drawer
            // update selected item and title, then close the drawer
            drawerLayout.closeDrawer(drawerContainer);

            //  reset content in drawer list
            for (DrawerItem drawerItem : drawerItemList) {
                drawerItem.setSelected(false);
            }

            if (position == 0) {
                loadBook();
            } else if (position == 1) {
                loadPublisher();
            } else if (position == 2) {
                loadMember();
            } else if (position == 3) {
                loadBookList();
            } else if (position == 4) {
                loadPublisherList();
            } else if (position == 5) {
                loadLending();
            }

            drawerAdapter.notifyDataSetChanged();
        }
    }

    /**
     * Load my sensor list fragment
     */
    private void loadBook() {
        drawerItemList.get(0).setSelected(true);
        getActionBar().setTitle("New book");

        // fragment transitions
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        BookFragment todayFragment = new BookFragment();
        transaction.replace(R.id.main, todayFragment);
        transaction.commit();
    }

    /**
     * Load my sensor list fragment
     */
    private void loadPublisher() {
        drawerItemList.get(1).setSelected(true);
        getActionBar().setTitle("New publisher");

        // fragment transitions
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        PublisherFragment summaryFragment = new PublisherFragment();
        transaction.replace(R.id.main, summaryFragment);
        transaction.commit();
    }

    private void loadMember() {
        drawerItemList.get(2).setSelected(true);
        getActionBar().setTitle("New member");

        // fragment transitions
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        MemberFragment assignment3Fragment = new MemberFragment();
        transaction.replace(R.id.main, assignment3Fragment);
        transaction.commit();
    }

    /**
     * Load my switch board fragment
     */
    private void loadBookList() {
        drawerItemList.get(3).setSelected(true);
        getActionBar().setTitle("Books");

        // data to populate
        ArrayList<String> list = new ArrayList();
        list.add("Java in action");
        list.add("Clean code");
        list.add("Scala in action");
        list.add("Distributed Systems");

        // fragment transitions
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        ListFragment fragment = new ListFragment();

        // set data to fragment
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("list", list);
        fragment.setArguments(bundle);

        transaction.replace(R.id.main, fragment);
        transaction.commit();
    }

    private void loadPublisherList() {
        drawerItemList.get(4).setSelected(true);
        getActionBar().setTitle("Publishers");

        // data to populate
        ArrayList<String> list = new ArrayList();
        list.add("Springer");
        list.add("British publish");
        list.add("Creative tech");
        list.add("Typesafe");
        list.add("PyCon");

        // fragment transitions
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        ListFragment fragment = new ListFragment();

        // set data to fragment
        Bundle bundle = new Bundle();
        bundle.putStringArrayList("list", list);
        fragment.setArguments(bundle);

        transaction.replace(R.id.main, fragment);
        transaction.commit();
    }

    private void loadLending() {
        drawerItemList.get(5).setSelected(true);
        getActionBar().setTitle("Lending");

        // fragment transitions
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        LendingFragment fragment = new LendingFragment();
        transaction.replace(R.id.main, fragment);
        transaction.commit();
    }

}
