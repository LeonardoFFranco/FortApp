package edu.upb.fortapp.ui.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.upb.fortapp.R;

public class LoginActivity extends AppCompatActivity {

        private Button login;
        private Context context;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            this.context=this;
            setContentView(R.layout.login_layout_prueba);
            this.login=findViewById(R.id.button4);

            this.login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, MenuActivity.class);
                    startActivity(intent);
                }
            });

        }
}
