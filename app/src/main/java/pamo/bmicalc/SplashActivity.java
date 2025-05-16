package pamo.bmicalc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Aktywność startowa wyświetlająca główny ekran przez 3 sekundy,a następnie przełączająca się na aktywność główną aplikacji
 */
@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity {

    /**
     * Ustawia layout ekranu powitalnego, a następnie po 3 sekundach
     * uruchamia HomeActivity i kończy SplashActivity, aby nie była widoczna
     * po naciśnięciu przycisku "wstecz".
     *
     * @param savedInstanceState zapisany stan aktywności, jeśli istnieje
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();
        }, 3000); // 3 sekundy
    }
}