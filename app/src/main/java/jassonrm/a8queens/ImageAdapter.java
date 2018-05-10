package jassonrm.a8queens;

import android.app.Application;
import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return 64;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        int column = i % 8 - 1;

        if(i == 0){column =0;}
        else if (column == -1){column = 7;}

        int row = i / 8;
        if(i % 8 == 0){
            row--;
        }
        ImageView queen;
        if(view == null) {
            queen = new ImageView(mContext);

            final float scale = mContext.getResources().getDisplayMetrics().density;
            int size  = (int) (44 * scale);

            queen.setLayoutParams(new ViewGroup.LayoutParams(size, size));
            queen.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }else{
            queen = (ImageView) view;
        }
        if (Queens.queens != null && Queens.queens[column] == row) {
            queen.setImageResource(R.mipmap.queen);
        }
        else{
            //imagen transparente
            //queen.setImageResource(R.mipmap.queen);
        }
        return queen;
    }

}
