package jp.co.resonabank.testprogress;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private AnimationDrawable animationDrawable;
    private Button downlaodButton, selectButton;

    private ImageView imageview, mySelectImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview = (ImageView) findViewById(R.id.proiamgeView);
        downlaodButton = (Button) findViewById(R.id.downlaodButton);
        downlaodButton.setOnClickListener(downlaodButtonListener);
        animationDrawable = (AnimationDrawable) imageview.getDrawable();

        mySelectImageView = (ImageView) findViewById(R.id.mySelectImageView);
        selectButton = (Button) findViewById(R.id.selectButton);
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, LikeIconActivity.class);
                startActivityForResult(it, 0x123);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0x123 && resultCode == 0x123) {
            Bundle bd = data.getExtras();
            int imageID = bd.getInt("imgid");
            mySelectImageView.setImageResource(imageID);
        }
    }

    View.OnClickListener downlaodButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (downlaodButton.getText().toString().equals("ダウンロード")) {
                //ダウンロード　始める
                downlaodButton.setText("停める");
                imageview.setVisibility(View.VISIBLE);
                imageview.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        animationDrawable.start();
                    }
                }, 200);

            } else if (downlaodButton.getText().toString().equals("停める")) {
                //ダウンロード　停める
                downlaodButton.setText("ダウンロード");
                imageview.setVisibility(View.GONE);
            }
        }
    };
}
