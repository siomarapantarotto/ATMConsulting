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

        /**
         * The line bellow is commented because an external library is used to set "about-page"
         * Check on build.gradle: implementation 'com.github.medyo:android-about-page:1.2.4'
         */
        //setContentView(R.layout.activity_about_us);

        View aboutUs = new AboutPage(this)
                .setImage(R.drawable.logo)
                .setDescription("Write here a long description for ATM Consulting. \n\n" +
                        "Continue here the long description that you wrote for ATM Consulting.")

                /**
                 * FIRST GROUP - The library comes with default label values for the options.
                 * Prefer the commented lines if you want to change the default label values.
                 */
                .addGroup("Connect with us")
                .addEmail("siomarapantarotto@gmail.com")    // Blank email to be filled
                //.addEmail("siomarapantarotto@gmail.com", "Email us")
                .addWebsite("http://siomara.com.br")
                //.addWebsite("http://siomara.com.br", "Access our website")

                /**
                 * SECOND GROUP - The library default label values were changed only for two
                 * options: Facebook and Instagram.
                 */
                .addGroup("Find us")
                .addFacebook("100000498996433", "Facebook")
                .addInstagram("siomarapantarotto", "Instagram")
                .addGitHub("siomarapantarotto")
                .addTwitter("siomarapantarotto")    // I don't have Twitter
                .addYoutube("google")               // I don't remember my Youtube
                .addPlayStore("com.google.android.apps.plus") // I don't have PlayStore yet

                .create();

        setContentView(aboutUs);
    }
}
