package com.bawei.xushanshan.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.xushanshan.R;
import com.bawei.xushanshan.bean.SouBean;

import java.util.List;

/**
 * FileName: SouAdapter
 * Author: 徐姗姗
 * Date: 2019/11/18 10:22
 */
public class SouAdapter extends RecyclerView.Adapter<SouAdapter.ViewHolder> {
    FragmentActivity activity;
    List<SouBean.ResultBean> result;
    private View inflate;

    public SouAdapter(FragmentActivity activity, List<SouBean.ResultBean> result) {
        this.activity = activity;
        this.result = result;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        inflate = LayoutInflater.from(activity).inflate(R.layout.layout_sou, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.te_title.setText(result.get(position).getTitle());
        holder.te_source.setText(result.get(position).getSource());
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView te_title;
        private final TextView te_source;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            te_title = itemView.findViewById(R.id.te_title);
            te_source = itemView.findViewById(R.id.te_source);

        }
    }
}
