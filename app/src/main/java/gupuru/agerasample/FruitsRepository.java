package gupuru.agerasample;

import android.support.annotation.NonNull;

import com.google.android.agera.BaseObservable;
import com.google.android.agera.Supplier;
import com.google.android.agera.Updatable;

import java.util.ArrayList;

/**
 * Repository
 */
public class FruitsRepository extends BaseObservable implements Supplier<ArrayList<String>>, Updatable, FruitsGetApiRequest.FruitsCallback {

    private ArrayList<String> fruitsNameArrayList;

    public FruitsRepository(){

    }

    @NonNull
    @Override
    public ArrayList<String> get() {
        return fruitsNameArrayList;
    }

    @Override
    public void update() {
        //２番目
        FruitsGetApiRequest fruitsGetApiRequest = new FruitsGetApiRequest(this);
        fruitsGetApiRequest.run();
    }

    @Override
    protected void observableActivated() {
        //ここが最初によばれる
        update();
    }

    @Override
    public void setError() {
        //dispatchUpdateでactivity側に更新処理
        dispatchUpdate();
    }

    @Override
    public void setFruits(ArrayList<Fruits> fruitsArrayList) {
        fruitsNameArrayList = new ArrayList<>();
        for (Fruits fruits : fruitsArrayList) {
            fruitsNameArrayList.add(fruits.getName());
        }
        //dispatchUpdateでactivity側に更新処理
        dispatchUpdate();
    }

}
