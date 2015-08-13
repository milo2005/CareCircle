package sent.movil.carecircle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    Button facebook, google;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        facebook = (Button) findViewById(R.id.btn_facebook);
        google = (Button) findViewById(R.id.btn_google);

        facebook.setOnClickListener(this);
        google.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent intent  = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
