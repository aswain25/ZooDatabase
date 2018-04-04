package com.example.admin.zoodatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalProfileActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvCatagory;
    TextView tvSpecies;
    TextView tvWeight;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_profile);

        tvName = findViewById(R.id.tvName);
        tvCatagory = findViewById(R.id.tvCatagory);
        tvSpecies = findViewById(R.id.tvSpecies);
        tvWeight = findViewById(R.id.tvWeight);
        iv = findViewById(R.id.iv);

        Animal model = (Animal)getIntent().getSerializableExtra("data");

        tvName.setText(model.getName());
        tvCatagory.setText(model.getCatagory().toString());
        tvSpecies.setText(model.getSpecies().toString());
        tvWeight.setText(String.valueOf(model.getWeight()));
        iv.setImageResource(getImageID(model.getSpecies()));

    }
    static int getImageID(Animal.Species species)
    {
        switch (species)
        {
            case Tiger:
                return R.mipmap.tiger;
            case Zebra:
                return R.mipmap.zebra;
            case Giraffe:
                return  R.mipmap.giraffe;
            case Peacock:
                return  R.mipmap.peacock;
            case Owl:
                return  R.mipmap.owl;
            case Parrot:
                return  R.mipmap.parrot;
            case ClownFish:
                return  R.mipmap.clownfish;
            case BlueTang:
                return R.mipmap.bluetang;
            case RainbowTrout:
                return  R.mipmap.rainbowtrout;
            case PoisonDart:
                return  R.mipmap.poisondart;
            case Salamander:
                return  R.mipmap.salamander;
            case GreenFrog:
                return  R.mipmap.greenfrog;
            case RattleSnake:
                return  R.mipmap.rattlesnake;
            case Turtle:
                return  R.mipmap.turtle;
            case Chameleon:
                return  R.mipmap.chameleon;
            default:
                return -1;
        }
    }
}
