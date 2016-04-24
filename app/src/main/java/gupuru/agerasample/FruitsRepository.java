package gupuru.agerasample;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.agera.BaseObservable;
import com.google.android.agera.Supplier;
import com.google.android.agera.Updatable;

/**
 * Created by kohei on 2016/04/24.
 */
public class FruitsRepository extends BaseObservable implements Supplier<String>, Updatable {

    public FruitsRepository(){

    }
    /**
     * @return the most up to date known list of usernames
     */
    @NonNull
    @Override
    public String get() {
        return "apple";
    }

    @Override
    public void update() {
        Log.d("ここ", "FruitsRepository update");
        dispatchUpdate();
    }

    @Override
    protected void observableActivated() {
        Log.d("ここ", "observableActivated");
        update();
    }

}
