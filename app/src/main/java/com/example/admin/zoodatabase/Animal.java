package com.example.admin.zoodatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Admin on 4/2/2018.
 */

public class Animal implements Serializable {
    public enum Species
    {
        Tiger,
        Zebra,
        Giraffe,
        Peacock,
        Owl,
        Parrot,
        ClownFish,
        BlueTang,
        RainbowTrout,
        PoisonDart,
        Salamander,
        GreenFrog,
        RattleSnake,
        Turtle,
        Chameleon,

    }
    String name;
    CatagoriesActivity.Catagory catagory;
    Species species;
    double weight;

    public Animal(String name, CatagoriesActivity.Catagory catagory, Species species, double weight) {
        this.name = name;
        this.catagory = catagory;
        this.species = species;
        this.weight = weight;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CatagoriesActivity.Catagory getCatagory() {
        return catagory;
    }

    public void setCatagory(CatagoriesActivity.Catagory catagory) {
        this.catagory = catagory;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", catagory=" + catagory +
                ", weight=" + weight +
                '}';
    }

    public static List<Animal> GenerateRandom(int count)
    {
        List<Animal> result = new ArrayList<Animal>();
        for (int i = 0 ; i < count; i++)
        {
            CatagoriesActivity.Catagory catagory = getRandomCatagory();
            result.add(new Animal(getRandomName(), catagory, getRandomSpecies(catagory), RandomRange.randDouble(.1, 400)));
        }
        return  result;
    }
    public static String getRandomName()
    {
        String[] names = new String[]
        {
                "Bowie",
                "Iris",
                "Da Vinci",
                "Tyrone",
                "Tico",
                "Lucas",
                "Grant",
                "Goon",
                "Gomez",
                "Kent",
                "Goldy",
                "Dream",
                "Mo",
                "Monk",
                "Murdoc",
                "Casanova",
                "Kermit",
                "Boogie",
                "Lulu",
                "Slick",
                "Sushi",
                "Noir",
                "Vino",
                "Baxter",
                "Atlas",
                "Baldy",
                "Oatmeal",
                "Gamble",
                "Latte",
                "Radial",
                "Law",
                "Relish",
                "Orbit",
                "Sultan",
                "Toffee",
                "Fuzzball",
                "Wallace",
                "Tundra",
                "Stormy",
                "Cream",
                "Crash",
                "Casper",
                "Capone",
                "Thunder",
                "Scar",
                "Sahara",
                "Ocean",
                "Cloud",
                "Crimson",
                "Marco",
                "Moses",
                "Quick",
                "Jinx",
                "Toto",
                "Conrad",
                "Otto",
                "Skipper",
                "Mason",
                "Teddy",
                "Tyson",
                "Reagan",
                "Optic",
                "Dakota",
                "Presto",
                "Sultan",
                "Leah",
                "Riot",
                "Lex",
                "Alvin",
                "Wendy",
                "Charlotte",
                "Julius",
                "Bomber",
                "Keg",
                "Gus",
                "Lenny",
                "Wendy",
                "Buffy",
                "Caligula",
                "Tater Tot",
                "Ernie",
                "Porter",
                "Pistol",
                "Palmer",
                "Chrono",
                "Zombie",
                "Jacques",
                "Eve",
                "Shrek",
                "Henry",
                "Lexus",
                "Beavis",
                "LeBron",
                "Groove",
                "Dinah",
                "Jedi",
                "Boss",
                "Spur",
                "Cappuccino",
                "Shamu",
                "Dora",
                "Tater Tot",
                "Smooth",
                "Emmitt",
                "Siri",
                "Leaf",
                "Trident",
                "Bear",
                "Shaker",
                "Vino",
                "Cluck",
                "Dingo",
                "Matilda",
                "Coconut",
                "Boots",
                "Sweetie",
                "Coy",
                "Reverb",
                "Elm",
                "Ruff",
                "Reverb",
                "Wilmer",
                "Sly",
                "Newton",
                "Matrix",
                "Matrix",
                "Azure",
                "Gosh",
                "Mace",
                "Rockefeller",
                "Kirby",
                "Nelson",
                "Shorty",
                "Skeletor",
                "Oliver",
                "Fog",
                "Gummy",
                "Skippy",
                "Eve",
                "Boomer",
                "Boss",
                "Tinker",
                "Darwin",
                "Shredder",
                "Polo",
                "Winnie",
                "Gin",
                "Fender",
                "Cleopatra",
                "Daft",
                "King",
                "Peanut",
                "Stinker",
                "Hennessy",
                "Clayton",
                "Bishop",
                "Quick",
                "Lou",
                "Zipper",
                "Shock",
                "Troy",
                "Zen",
                "Spur",
                "Epic",
                "Lola",
                "Tesla",
                "Pipsqueak",
                "Grant",
                "Bowser",
                "Spiral",
                "Shakira",
                "Marble",
                "Lester",
                "Dexter",
                "Jax",
                "Abdul",
                "Skippy",
                "Chleo",
                "Crumb",
                "Fuse",
                "Armani",
                "Chowder",
                "Fozzy",
                "Ewok",
                "Twerp",
                "Berry",
                "Buzz",
                "Chub",
                "Maniac",
                "Chase",
                "Vice",
                "Champ",
                "Azure",
                "Abdul",
                "Escobar",
                "Fidget",
                "Slinky",
                "Alvin",
                "Spock",
                "Pride",
                "Bounty",
                "Florence",
                "Chips",
                "Samantha",
                "Junior",
                "Swag",
                "Taffy",
                "Orchid",
                "Angel",
                "Summer",
                "McKenzie",
                "Nugget",
                "Grunt",
                "RooR",
                "Irvin",
                "Sagan",
                "Geo",
                "Ridley",
                "Babe",
                "Bucktooth",
                "Gretel",
                "Galiga",
                "Fay",
                "Bean",
                "Frasier",
                "Mozzarella",
                "Gummy",
                "Adobe",
                "Biggie",
                "Brady",
                "Lamar",
                "Jade",
                "Sputnik",
                "Ewok",
                "Grumpy",
                "Baloo",
                "Seinfeld",
                "Rupert",
                "Muffin",
                "Twilight",
                "Nina",
                "Gomez",
                "Rigby",
                "Alpha",
                "Fisk",
                "Coffee",
                "Garth",
                "Eve",
                "Winter",
                "Mojo",
                "Shang",
                "Leah",
                "Pop",
                "Mumble",
                "Critter",
                "Heidi",
                "Kitana",
                "Starbuck",
                "Grace",
                "Karma",
                "Mars",
                "Tyrese",
                "Chewbacca",
                "Arby",
                "Oscar",
                "Katrina",
                "Arsenio",
                "Bacardi",
                "Mason",
                "Angus",
                "Mint",
                "Brook",
                "Zap",
                "Elton",
                "Sosa",
                "Widget",
                "Seinfeld",
                "Blitzen",
                "Wayne",
                "Chleo",
                "Cooper",
                "Keller",
                "Ridley",
                "Magnum",
                "Cheddar",
        };
        return names[RandomRange.randInt(0, names.length - 1)];
    }
    public static CatagoriesActivity.Catagory getRandomCatagory()
    {
        return CatagoriesActivity.Catagory.values()[RandomRange.randInt(0, CatagoriesActivity.Catagory.values().length - 1)];
    }
    public static Species getRandomSpecies(CatagoriesActivity.Catagory catagory)
    {
        int zero = 0;
        switch (catagory)
        {
            case Mammals:
                zero = 0;
                break;
            case Birds:
                zero = 3;
                break;
            case Fish:
                zero = 6;
                break;
            case Amphibians:
                zero = 9;
                break;
            case Reptiles:
                zero = 12;
                break;
        }
        return Species.values()[zero + RandomRange.randInt(0, 2)];
    }

}
