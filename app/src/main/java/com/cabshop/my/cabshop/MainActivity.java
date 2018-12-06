package com.cabshop.my.cabshop;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.SubMenu;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.txt_maintitle) TextView txt_title;
    @BindView(R.id.item_list) ListView item_listView;

    @BindView(R.id.toolbar) Toolbar toolbar;

    @BindView(R.id.drawer_layout) DrawerLayout drawer;

    @BindView(R.id.nav_view) NavigationView navigationView;

    public static final String[] item_titles = new String[] { "Ear phone",
            "Mobile charger", "Mobile cover", "Screw driver" };

    public static final String[] item_prices = new String[] {
            "700/-","370/-", "500/-","260/-"};

    public static final Integer[] images = { R.drawable.earphone,
            R.drawable.charger, R.drawable.mobile_cover, R.drawable.screwdriver };

    List<RowItem> rowItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initResources();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            // Handle the camera action
        } else if (id == R.id.nav_order) {

        } else if (id == R.id.nav_cart) {

        } else if (id == R.id.nav_payment) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initResources(){
        try {

            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();

            Typeface title_face;
            title_face = Typeface.createFromAsset(getAssets(), "font1.otf");

            txt_title.setTypeface(title_face);
            menuTypeFace(navigationView);
            navigationView.setNavigationItemSelectedListener(this);

            rowItems = new ArrayList<RowItem>();
            for (int i = 0; i < item_titles.length; i++) {
                RowItem item = new RowItem(images[i], item_titles[i], item_prices[i]);
                rowItems.add(item);
            }
            ItemListAdapter adapter = new ItemListAdapter(this, rowItems);
            item_listView.setAdapter(adapter);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void menuTypeFace(NavigationView navView){
        Menu m = navView.getMenu();
        for (int i=0;i<m.size();i++) {
            MenuItem mi = m.getItem(i);

            //for aapplying a font to subMenu ...
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu!=null && subMenu.size() >0 ) {
                for (int j=0; j <subMenu.size();j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }

            //the method we have create in activity
            applyFontToMenuItem(mi);
        }
    }

    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "font.otf");
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }
}
