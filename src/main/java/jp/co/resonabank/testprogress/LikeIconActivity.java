package jp.co.resonabank.testprogress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class LikeIconActivity extends AppCompatActivity {

    private GridView gridView;
    private Button downlaodButton;
    private ImageView imageview;
    public int[] imgs = new int[]
            {
                    R.drawable.icon1, R.drawable.icon2, R.drawable.icon3, R.drawable.icon4,
                    R.drawable.icon5, R.drawable.icon6, R.drawable.icon7, R.drawable.icon8,
                    R.drawable.icon9, R.drawable.icon10
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_like_icon);
        gridView = (GridView) findViewById(R.id.gridViewIcon);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(imgs, LikeIconActivity.this);
        gridView.setAdapter(gridViewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(LikeIconActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
                Intent it = getIntent();
                Bundle bd = new Bundle();
                bd.putInt("imgid",imgs[position]);
                it.putExtras(bd);
                setResult(0x123,it);
                finish();
            }
        });


    }
}
