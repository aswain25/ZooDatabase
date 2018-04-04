package com.example.admin.zoodatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static android.support.v7.widget.helper.ItemTouchHelper.LEFT;
import static android.support.v7.widget.helper.ItemTouchHelper.RIGHT;

public class AnimalsActivity extends AppCompatActivity {
    private RecyclerView rvMain;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerListAdapter adapter;
    CatagoriesActivity.Catagory catagory;

    Predicate<? super Animal> predicate = new Predicate<Animal>() {
        @Override
        public boolean test(Animal animal) {
            return animal.catagory == catagory;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        catagory = (CatagoriesActivity.Catagory)getIntent().getSerializableExtra("catagory");

        final RecyclerView rvMain = findViewById(R.id.rvMain);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        adapter = new RecyclerListAdapter((List<Animal>)(Object)Arrays.asList(AppModel.getAnimals().stream().filter(predicate).toArray()));
        rvMain.setAdapter(adapter);
        rvMain.setLayoutManager(layoutManager);

        rvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RecyclerListAdapter.ViewHolder holder = (RecyclerListAdapter.ViewHolder) rvMain.getChildViewHolder(view);
                Animal animal = adapter.animals.get(holder.getLayoutPosition());

                Intent intent = new Intent(getApplicationContext(), AnimalProfileActivity.class);
                intent.putExtra("data", animal);
                startActivity(intent);

            }
        });

        SwipeController swipeController = new SwipeController();
        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
        itemTouchhelper.attachToRecyclerView(rvMain);
    }

    public void btnGenClicked(View view) {
        List<Animal> added = Animal.GenerateRandom(RandomRange.randInt(5, 20));
        AppModel.getAnimals().addAll(added);

        adapter.animals = (List<Animal>)(Object)Arrays.asList(AppModel.getAnimals().stream().filter(predicate).toArray());
        adapter.notifyDataSetChanged();

        Toast.makeText(this, "Added " +String.valueOf(added.size()) + " animals of all types", Toast.LENGTH_LONG ).show();
    }
    class SwipeController extends ItemTouchHelper.Callback {

        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
            int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
            return makeMovementFlags(dragFlags, swipeFlags);
        }

        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            int i = viewHolder.getLayoutPosition();
            int j = target.getLayoutPosition();
            Collections.swap(AppModel.getAnimals(), AppModel.getAnimals().indexOf(adapter.animals.get(i)), AppModel.getAnimals().indexOf(adapter.animals.get(j)));
            adapter.animals = (List<Animal>)(Object)Arrays.asList(AppModel.getAnimals().stream().filter(predicate).toArray());
            adapter.notifyItemMoved(i, j);
            return true;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            int layoutPosition = viewHolder.getLayoutPosition();
            AppModel.getAnimals().remove(adapter.animals.get(layoutPosition));

            adapter.animals = (List<Animal>)(Object)Arrays.asList(AppModel.getAnimals().stream().filter(predicate).toArray());
            adapter.notifyItemRemoved(layoutPosition);
        }
    }
}