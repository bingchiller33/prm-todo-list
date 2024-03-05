package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

import com.example.myapplication.bean.Group;
import com.example.myapplication.repository.GroupRepository;

import java.util.List;

public class GroupListAdapter extends BaseAdapter {
    private List<Group> groupList;
    private Context context;
    private GroupRepository groupRepository = null;

    public GroupListAdapter(List<Group> groupList, Context context) {
        this.groupList = groupList;
        this.context = context;
        this.groupRepository = new GroupRepository(context);
    }
    private void deleteProduct(Group group) {
        groupRepository.deleteProductById(group.getId());
        groupList.remove(group);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return groupList.size();
    }

    @Override
    public Object getItem(int position) {
        return groupList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.group_task_item, parent, false);
        }
        Group group = groupList.get(position);
        TextView groupNameTextView = convertView.findViewById(R.id.group_task_item_name);
        groupNameTextView.setText(group.getName());

        return convertView;
    }
}
