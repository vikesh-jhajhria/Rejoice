package com.rejoice.rejoice.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.rejoice.rejoice.R;
import com.rejoice.rejoice.vo.Item;

import java.util.List;

public class VegAdapter extends RecyclerView.Adapter
{

    private List<Item> mItemList;

    public VegAdapter(List<Item> itemList) {
        mItemList = itemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        final ViewHolder holder = (ViewHolder) viewHolder;
        final Item item = (Item)mItemList.get(position);

        holder.mItemSelected.setOnCheckedChangeListener(null);
        holder.setmItemTitle(item.title);
        holder.setmItemDetail(item.detail);
        holder.setmItemSelected(item.selected);
        holder.mItemSelected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                item.selected = isChecked;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItemList == null ? 0 : mItemList.size();
    }





    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView mItemTitle;
        private final TextView mItemDetail;
        private final CheckBox mItemSelected;

        public ViewHolder(final View parent) {
            super(parent);
            mItemTitle      =   (TextView) parent.findViewById(R.id.rv_item_title);
            mItemDetail     =   (TextView) parent.findViewById(R.id.rv_item_detail);
            mItemSelected   =   (CheckBox) parent.findViewById(R.id.rv_item_check);
        }
        public void setmItemTitle(CharSequence text) {
            mItemTitle.setText(text);
        }
        public void setmItemDetail(CharSequence text) {
            mItemDetail.setText(text);
        }
        public void setmItemSelected(boolean selected) {
            mItemSelected.setChecked(selected);
        }


    }
}
