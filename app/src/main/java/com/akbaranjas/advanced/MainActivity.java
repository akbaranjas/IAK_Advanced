package com.akbaranjas.advanced;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.akbaranjas.advanced.models.DataBean;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt_test_1) TextView txtTest1;

    private Subscription subscriber = new CompositeSubscription();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        prosesObjekData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscriber.unsubscribe();
    }

    private void prosesData(){
        int[] datas = {1,2,3,4,5,6,7,8,9,10};

        Observable<int[]> dataku = Observable.just(datas);

        subscriber = dataku.map(angka -> {
            StringBuilder test = new StringBuilder();
            for (int i = 0; i < angka.length; i++) {
                if (angka[i] % 2 == 1) {
                    test.append(angka[i] + "\n");
                }
            }
            return test.toString();

        }).observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, this::onError);
    }

    private void onSuccess(String s){
        txtTest1.setText(s);
    }

    private void onError(Throwable err){

    }

    private void prosesObjekData(){
        DataBean identitas = new DataBean("Akbar Anjas", 25);
        Observable<DataBean> dataku = Observable.just(identitas);

        subscriber = dataku.observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<DataBean>() {
                    @Override
                    public void call(DataBean dataBean) {
                        txtTest1.setText(dataBean.getNama() + "\n" +
                        dataBean.getUmur());
                    }
                },this::onError);
    }
}
