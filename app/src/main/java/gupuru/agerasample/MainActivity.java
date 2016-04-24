package gupuru.agerasample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.agera.Updatable;

public class MainActivity extends AppCompatActivity implements Updatable {

    private FruitsRepository fruitsRepository;
    private TextView status;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        status = (TextView) findViewById(R.id.status);
        listView = (ListView) findViewById(R.id.list_view);
        fruitsRepository = new FruitsRepository();

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
        if (!fruitsRepository.get().isEmpty()) {
            status.setText("読み込み完了");
            ListAdapter listAdapter = new ArrayAdapter<String>(MainActivity.this,
                    android.R.layout.simple_list_item_1, fruitsRepository.get());
            listView.setAdapter(listAdapter);
        }
    }

}
