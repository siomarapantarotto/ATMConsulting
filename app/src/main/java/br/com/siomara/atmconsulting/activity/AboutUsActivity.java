package br.com.siomara.atmconsulting.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.siomara.atmconsulting.R;
import mehdi.sakout.aboutpage.AboutPage;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_about_us);

        View aboutUs = new AboutPage(this)
                .setImage(R.drawable.logo)
                .setDescription("Write here a long description for ATM Consulting. \n\n" +
                "Continue here the long description that you wrote for ATM Consulting.")

                .addGroup("Connect with us")
                .addEmail("siomarapantarotto@gmail.com")
                //.addEmail("siomarapantarotto@gmail.com", "Email us")
                .addWebsite("http://siomara.com.br")
                //.addWebsite("http://siomara.com.br", "Access our website")

                .addGroup("Find us")
                .addFacebook("100000498996433", "Facebook")
                .addTwitter("siomarapantarotto")
                .addYoutube("google")
                .addPlayStore("com.google.android.apps.plus")
                .addGitHub("siomarapantarotto")
                .addInstagram("siomarapantarotto")

                .create();

        setContentView(aboutUs);

    }
}
