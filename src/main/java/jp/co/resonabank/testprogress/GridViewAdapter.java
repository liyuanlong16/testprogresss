package jp.co.resonabank.testprogress;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by smyhvae on 2015/5/7.
 */
public class GridViewAdapter extends BaseAdapter {
    public int[] imgs = new int[]{};
    private Context mContext;

    //排版布局ViewHolder重用组件
    ViewHolder viewHolder = null;

    public GridViewAdapter(int[] imgs, Context mContext) {
        this.mContext = mContext;
        this.imgs = imgs;
    }

    //获得数量
    @Override
    public int getCount() {
        return imgs.length;
    }

    //获得当前选项
    @Override
    public Object getItem(int i) {
        return imgs[i];
    }

    //获得当前选项对应的id
    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        ImageView imageView;
//        if (view == null) {
//            inf
//                    imageView = new ImageView(mContext);
//            //设置图片宽高
//            imageView.setAdjustViewBounds(true);
//            imageView.setMaxHeight(111);
//            imageView.setMaxWidth(111);
//            imageView.setPadding(5, 5, 5, 5);
//        } else imageView = (ImageView) view;
//
//        imageView.setImageResource(imgs[i]);
//        return imageView;
        /**
         *这样写的好处是每次改变view的内容时不需要每次都新的实例化和加载布局了
         * 直接从Holder中取就好
         * */
        if (view == null) {

            view = LayoutInflater.from(mContext).inflate(R.layout.adapter_layout_grid_view, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.girdImageView = (ImageView) view.findViewById(R.id.girdImageView);
            view.setTag(viewHolder);   //将Holder存储到convertView中
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.girdImageView.setImageResource(imgs[i]);
        return view;
    }
    static class ViewHolder {
        ImageView girdImageView;
    }

}
