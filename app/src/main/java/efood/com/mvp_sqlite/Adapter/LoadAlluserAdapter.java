package efood.com.mvp_sqlite.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import efood.com.mvp_sqlite.Model.User;
import efood.com.mvp_sqlite.R;

/**
 * Created by loc on 28/04/2016.
 */
public class LoadAlluserAdapter extends BaseAdapter {
    ArrayList<User> list;

    public LoadAlluserAdapter(ArrayList<User> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    View view;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        view = convertView;
        if (view == null) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
            ViewHoler holer = new ViewHoler();
            holer.txtName = (TextView) view.findViewById(R.id.txtname);
            view.setTag(holer);
        }
        ViewHoler viewHoler = (ViewHoler) view.getTag();
        viewHoler.txtName.setText(list.get(position).getUsername());
        return view;
    }

    class ViewHoler {
        TextView txtName;
    }
}
