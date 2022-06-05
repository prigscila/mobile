package com.ifsc.tacoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.TextView;
import com.ifsc.tacoapp.model.Taco;
import java.util.ArrayList;
import java.util.List;

public class TacoAdapter extends BaseAdapter {
    private List<Taco> filteredItems;
    private List<Taco> items;
    private LayoutInflater layoutInflater;

    public TacoAdapter(Context context, List<Taco> items) {
        this.items = items;
        this.filteredItems = items;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return filteredItems.size();
    }

    @Override
    public Object getItem(int arg0) {
        return filteredItems.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return filteredItems.get(arg0).getId();
    }

    @Override
    public View getView(int position, View tacoItemLayout, ViewGroup parent) {
        ItemHelper itemHelper = new ItemHelper();
        Taco tacoItem = filteredItems.get(position);

        if (tacoItemLayout == null) {
            tacoItemLayout = layoutInflater.inflate(R.layout.taco_item_layout, null);
            itemHelper.alimento = (TextView) tacoItemLayout.findViewById(R.id.tvAlimento);
            tacoItemLayout.setTag(itemHelper);
        } else {
            itemHelper = (ItemHelper) tacoItemLayout.getTag();
        }

        itemHelper.alimento.setText(tacoItem.getAlimento());
        return tacoItemLayout;
    }

    private class ItemHelper {
        TextView alimento;
    }

    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence filter) {
                FilterResults results = new FilterResults();

                if (filter == null || filter.length() == 0) {
                    results.count = items.size();
                    results.values = items;
                } else {
                    List<Taco> newFilteredItems = new ArrayList<>();

                    for (int i = 0; i < items.size(); i++) {
                        Taco tacoItem = items.get(i);
                        filter = filter.toString().toLowerCase();
                        String nomeAlimento = tacoItem.getAlimento().toLowerCase();

                        if (nomeAlimento.contains(filter)) {
                            newFilteredItems.add(tacoItem);
                        }
                    }

                    results.count = newFilteredItems.size();
                    results.values = newFilteredItems;
                }
                return results;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
                filteredItems = (List<Taco>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}