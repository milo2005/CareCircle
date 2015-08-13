package sent.movil.carecircle.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import sent.movil.carecircle.R;
import sent.movil.carecircle.models.PublicationItem;

/**
 * Created by Dario Chamorro on 12/08/2015.
 */
public class PublicationAdapter extends BaseAdapter {

    Context context;
    List<PublicationItem> data;

    public PublicationAdapter(Context context, List<PublicationItem> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = null;
        if(convertView == null)
            v = View.inflate(context, R.layout.template_main, null);
        else
            v = convertView;

        PublicationItem item = (PublicationItem) getItem(position);

        ImageView img = (ImageView) v.findViewById(R.id.img);
        Picasso.with(context).load(item.getImg()).into(img);


        TextView txt = (TextView) v.findViewById(R.id.title);
        txt.setText(item.getTitle());

        txt = (TextView) v.findViewById(R.id.category);
        txt.setText(item.getCategoryName());
        txt.setTextColor(context.getResources().getColor(item.getCategoryColor()));

        txt = (TextView) v.findViewById(R.id.content);
        txt.setText(item.getContent());

        return v;
    }
}
