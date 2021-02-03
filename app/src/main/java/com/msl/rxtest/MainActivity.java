    package com.msl.rxtest;

    import android.os.Bundle;
    import android.util.Log;
    import android.widget.TextView;

    import androidx.appcompat.app.AppCompatActivity;

    import com.msl.rxtest.utils.RxHelper;

    import io.reactivex.Observer;
    import io.reactivex.annotations.NonNull;
    import io.reactivex.disposables.Disposable;

    public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tx = findViewById(R.id.textView);

        // наблюдатель _ спостерігач
        RxHelper.getObservable()
                .subscribe(new Observer<String>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        tx.setText(s);
                        Log.d("tag", s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        Log.d("tag","complete");
                    }
                });
    }
}