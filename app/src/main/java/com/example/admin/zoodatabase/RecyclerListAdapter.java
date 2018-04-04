package com.example.admin.zoodatabase;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Admin on 4/2/2018.
 */

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ViewHolder> {
    DecimalFormat format = new DecimalFormat("#.##lb");
    List<Animal> animals;

    public RecyclerListAdapter(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.simple_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
        Animal animal = animals.get(position);
        if (animal != null)
        {
            holder.tvName.setText(animal.getName());
            holder.tvWeight.setText(animal.species.toString());
            int color = 0xff000000;
            if (animal.weight < 50)
            {
                holder.tvType.setText("1");
                color = 0xffff0000;
            }
            else if (animal.weight < 100)
            {
                holder.tvType.setText("2");
                color = 0xffff8800;
            }
            else if (animal.weight < 200)
            {
                holder.tvType.setText("3");
                color = 0xff00ff00;
            }
            else if (animal.weight < 300)
            {
                holder.tvType.setText("4");
                color = 0xff0000ff;
            }
            else
            {
                holder.tvType.setText("5");
                color = 0xffff00ff;
            }
            holder.tvType.setBackgroundColor(color);



        }
    }

    @Override
    public int getItemCount()
    {
        return animals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView tvName;
        TextView tvWeight;
        TextView tvType;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvWeight = itemView.findViewById(R.id.tvWeight);
            tvType = itemView.findViewById(R.id.tvType);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Animal animal = animals.get(getLayoutPosition());

            Intent intent = new Intent(view.getContext(), AnimalProfileActivity.class);
            intent.putExtra("data", animal);
            view.getContext().startActivity(intent);
        }
    }
}
