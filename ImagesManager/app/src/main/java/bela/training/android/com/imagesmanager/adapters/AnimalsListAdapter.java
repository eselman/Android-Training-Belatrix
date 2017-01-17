package bela.training.android.com.imagesmanager.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.support.v7.widget.AppCompatDrawableManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import bela.training.android.com.imagesmanager.R;

/**
 * Created by eselman on 16/01/2017.
 */
public class AnimalsListAdapter extends ArrayAdapter<String> {
    private int resource;

    public AnimalsListAdapter(Context context, int _resource,
                               List<String> urls) {
        super(context, _resource, urls);
        resource = _resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Create and inflate the View to display
        RelativeLayout newView;
        if (convertView == null) {
            // Inflate a new view if this is not an update.
            newView = new RelativeLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li;
            li = (LayoutInflater) getContext().getSystemService(inflater);
            li.inflate(resource, newView, true);
        } else {
            // Otherwise we will update the existing View
            newView = (RelativeLayout) convertView;
        }
       String imageName = getItem(position);

        ViewHolder holder = (ViewHolder)newView.getTag();

        if (holder == null){
            holder = new ViewHolder();
            holder.image = (ImageView)newView.findViewById(R.id.image);

            newView.setTag(holder);

        }

        Context context = holder.image.getContext();
        int id = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        BitmapDrawable imageDrawable = (BitmapDrawable) context.getResources().getDrawable(id, null);
        holder.image.setImageBitmap(ThumbnailUtils.extractThumbnail(imageDrawable.getBitmap(), 100, 100));
        return newView;
    }

    static class ViewHolder {
        ImageView image;
    }
}
