package gupuru.agerasample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.agera.Updatable;

public class MainActivity extends AppCompatActivity implements Updatable {

    private FruitsRepository fruitsRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruitsRepository = new FruitsRepository();
        Log.d("ここ", "onCreate");
    }

    @Override
    public void onResume() {
        super.onResume();
        fruitsRepository.addUpdatable(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        fruitsRepository.removeUpdatable(this);
    }

    @Override
    public void update() {
        Log.d("ここ", "MainActivity update");

        Log.d("ここ", "あれ");
        Log.d("ここ", fruitsRepository.get());

    }
}
