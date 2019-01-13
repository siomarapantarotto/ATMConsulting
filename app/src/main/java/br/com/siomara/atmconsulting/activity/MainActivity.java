package br.com.siomara.atmconsulting.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import br.com.siomara.atmconsulting.R;
import br.com.siomara.atmconsulting.fragment.ClientsFragment;
import br.com.siomara.atmconsulting.fragment.HomeFragment;
import br.com.siomara.atmconsulting.fragment.ServicesFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        HomeFragment homeFragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameContainer, homeFragment);
        fragmentTransaction.commit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendPresetEmail();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            HomeFragment homeFragment = new HomeFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameContainer, homeFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_services) {
            ServicesFragment servicesFragment = new ServicesFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameContainer, servicesFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_clients) {
            ClientsFragment clientsFragment = new ClientsFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameContainer, clientsFragment);
            fragmentTransaction.commit();

        } else if (id == R.id.nav_contact) {
            this.sendPresetEmail();

        } else if (id == R.id.nav_about) {
            startActivity( new Intent(this, AboutUsActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /** Send email with preset values */
    public void sendPresetEmail() {
        Intent email = new Intent(Intent.ACTION_SEND);

        // Inform as many emails you want the message to be sent to
        email.putExtra(Intent.EXTRA_EMAIL, new String[] {
                "siomarapantarotto@gmail.com",      // 1st email
                "siomarapantarotto@hotmail.com"     // 2nd email
        });

        // Inform email subject
        email.putExtra(Intent.EXTRA_SUBJECT, "Hello from Fictional ATM Consulting");

        // Inform email message
        email.putExtra(Intent.EXTRA_TEXT, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut nisl tincidunt, eleifend erat at, molestie ex. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce et mauris vitae tortor sollicitudin dapibus quis in velit. Nam vitae malesuada eros, at blandit eros. Suspendisse potenti. Donec congue quam eu enim volutpat, ac sagittis ex viverra. Vivamus finibus neque a ultricies tempor. Maecenas ligula nisl, facilisis a odio et, elementum gravida lorem. Cras eget ornare orci. Aliquam pellentesque sapien scelerisque, posuere ex sed, blandit est. Sed tristique ultricies egestas. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.");

        // Configuration to open only email applications installed on de mobile device
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Choose your favorite email application!"));
    }
}
