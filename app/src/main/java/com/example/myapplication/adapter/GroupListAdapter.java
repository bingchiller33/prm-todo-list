package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.bean.Group;
import com.example.myapplication.handler.HomePageActivity;
import com.example.myapplication.repository.GroupRepository;

import java.util.List;

public class GroupListAdapter extends RecyclerView.Adapter<GroupListAdapter.GroupViewHolder> {
    private Context context;
    private List<Group> groups;
    private GroupRepository groupRepository = null;
    private int postition;
    public GroupListAdapter(List<Group> groupList, Context context) {
        this.groups = groupList;
        this.context = context;
        this.groupRepository = new GroupRepository(context);
    }
    private void deleteProduct(Group group) {
        groupRepository.deleteProductById(group.getId());
        groups.remove(group);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.group_task_item, parent, false);
        return new GroupViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupViewHolder holder, int position) {
        int itemPosition = holder.getAdapterPosition();
        Group group = groups.get(itemPosition);
        holder.tv_group_item.setText(group.getName());
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }
    public class GroupViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_group_item;
        private GroupListAdapter groupListAdapter = null;

        public GroupViewHolder(@NonNull View itemView, GroupListAdapter groupListAdapter) {
            super(itemView);
            tv_group_item =itemView.findViewById(R.id.group_task_item);
            ((HomePageActivity) context).registerForContextMenu(tv_group_item);
            this.groupListAdapter = groupListAdapter;
        }

        @Override
        public void onClick(View v) {
//            PopupMenu popupMenu = new PopupMenu(context, v);
//            popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
//            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                @Override
//                public boolean onMenuItemClick(MenuItem item) {
//                    if (item.getItemId() == R.id.menu_context_delete) {
//                        products.remove(postition);
//                        productListAdapter.notifyDataSetChanged();
//                    } else if (item.getItemId() == R.id.menu_popup_view) {
//                        Intent intent = new Intent(context, ProductDetailActivity.class);
//                        context.startActivity(intent);
//                    }
//                    return true;
//                }
//            });
//            popupMenu.show();
        }
    }
}
