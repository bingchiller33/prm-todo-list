package com.example.myapplication.handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapter.GroupListAdapter;
import com.example.myapplication.bean.Group;
import com.example.myapplication.entity.GroupEntity;
import com.example.myapplication.repository.GroupRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {
    private List<Group> groupList = new ArrayList<>();
    private EditText edit_search, edit_newGroup;
    private TextView tv_icon_delete, tv_cancel;
    private Button btn_addNew;
    private GroupRepository groupRepository = null;
    private GroupListAdapter groupListAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        RecyclerView recyclerView = findViewById(R.id.recycle_view_group_task_list);
        edit_search = findViewById(R.id.hp_searching_task);
        tv_icon_delete = findViewById(R.id.hp_icon_delete);
        tv_cancel = findViewById(R.id.hp_cancel);
        edit_newGroup = findViewById(R.id.hp_ed_new_group);
        btn_addNew = findViewById(R.id.hp_btn_add);
        groupRepository = new GroupRepository(this);

        tv_icon_delete.setVisibility(View.GONE);
        tv_cancel.setVisibility(View.GONE);

        groupListAdapter = new GroupListAdapter(groupList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(groupListAdapter);
        registerForContextMenu(recyclerView);
        addNew(btn_addNew, edit_newGroup);
        groupRepository = new GroupRepository(this);
        loadAllProducts();
        animation();
    }
    private void loadAllProducts() {
        List<GroupEntity> groups = groupRepository.getAllProduct(1);
        Log.d("TAG", "loadAllProducts: Number of products retrieved: " + groups.size());
        convertGroupEntity(groups);
        groupListAdapter.notifyDataSetChanged();
    }
    private void convertGroupEntity(List<GroupEntity> groupEntities) {
        if (groupEntities == null) {
            return;
        }
//        groupList.clear();
        for (GroupEntity productEntity : groupEntities) {
            Group group = new Group();
            group.setId(productEntity.getId());
            group.setName(productEntity.getName());
            group.setStatus(productEntity.getStatus());
            group.setCreatedAt(productEntity.getCreatedAt());
            group.setUpdatedAt(productEntity.getUpdatedAt());
            groupList.add(group);
        }
    }

    private void addNew(Button btn, EditText edt) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt.getText().toString();
                if(name.length() == 0) return;
                Date currentTime = new Date();
                GroupEntity groupEntity = new GroupEntity();
                groupEntity.setName(name);
                groupEntity.setStatus("null");
                groupEntity.setUserId(1);
                groupEntity.setCreatedAt(currentTime);
                groupEntity.setUpdatedAt(currentTime);
                groupRepository.createGroup(groupEntity);
            }
        });
    }
    private void animation() {
        edit_search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 0) {
                    tv_icon_delete.setVisibility(View.VISIBLE);
                    tv_icon_delete.animate().alpha(1f).setDuration(400).start();
                } else {
                    tv_icon_delete.setVisibility(View.GONE);
                    tv_icon_delete.animate().alpha(0f).setDuration(400).start();
                }
            }
        });
        tv_icon_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_search.setText("");
            }
        });
        edit_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_search.setFocusableInTouchMode(true);
                edit_search.setFocusable(true);
                edit_search.requestFocus();
                tv_cancel.setVisibility(View.VISIBLE);
                Animation animation = new TranslateAnimation(
                        Animation.RELATIVE_TO_SELF, 1.0f, // Từ vị trí phải (1.0) của TextView
                        Animation.RELATIVE_TO_SELF, 0.0f, // Đến vị trí trái (0.0) của TextView
                        Animation.RELATIVE_TO_SELF, 0.0f, // Giữ nguyên vị trí trên của TextView
                        Animation.RELATIVE_TO_SELF, 0.0f  // Giữ nguyên vị trí dưới của TextView
                );
                animation.setDuration(1000); // Đặt thời gian di chuyển là 1 giây
                tv_cancel.startAnimation(animation);
            }
        });
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit_search.setText("");
                edit_search.setFocusableInTouchMode(false);
                edit_search.setFocusable(false);
                edit_search.requestFocus();
                Animation animation = new TranslateAnimation(
                        Animation.RELATIVE_TO_SELF, 0f, // Từ vị trí phải (1.0) của TextView
                        Animation.RELATIVE_TO_SELF, 1.0f, // Đến vị trí trái (0.0) của TextView
                        Animation.RELATIVE_TO_SELF, 0.0f, // Giữ nguyên vị trí trên của TextView
                        Animation.RELATIVE_TO_SELF, 0.0f  // Giữ nguyên vị trí dưới của TextView
                );
                animation.setDuration(1000); // Đặt thời gian di chuyển là 1 giây
                tv_cancel.startAnimation(animation);
                tv_cancel.setVisibility(View.GONE);
            }
        });
    }
}