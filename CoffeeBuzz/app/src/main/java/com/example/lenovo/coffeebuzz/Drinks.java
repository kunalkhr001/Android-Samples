package com.example.lenovo.coffeebuzz;


public class Drinks {
    private String name;
    private String desc;
    private int imageID;

    public static final Drinks[] drinks={
            new Drinks("Latte","This is a description for latte",R.drawable.latte),
            new Drinks("Cappucino","This is a description for capuccino",R.drawable.cappuccino),
            new Drinks("Espresso","This is a description for espresso",R.drawable.espresso)
    };


    private Drinks(String name,String desc,int imageID)
    {
        this.name=name;
        this.desc=desc;
        this.imageID=imageID;
    }

    public String getDesc()
    {
        return desc;
    }

    public String getName()
    {
        return name;
    }

    public int getImageID()
    {
        return imageID;
    }

    public String toString()
    {
        return this.name;
    }


}
