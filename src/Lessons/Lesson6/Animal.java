package Lessons.Lesson6;

public  class Animal {
    protected String name;
    protected int age;
    protected String color;
    protected int limitSwimMeters;
    protected int limitRunMeters;

    public Animal(String name, int age, String color){
        this.name = name;
        this.age = age;
        this.color = color;
    }
    public Animal(String name, String color){
        this.name = name;
        this.color = color;
        this.age = 0;
    }
    public Animal(String color){
        this.name = "Unknown";
        this.color = color;
        this.age = 0;
    }

    public void run(int meters){
        if(limitRunMeters == 0)
            System.out.println(name + " cannot run");
        else if(meters > limitRunMeters) {
            System.out.println(name + " run " + limitRunMeters + " meters");
        }
        else
            System.out.println(name + " run " + meters + " meters");
    }

    public  void swim(int meters){
        if(limitSwimMeters == 0)
            System.out.println(name + " cannot swim");
        else if(meters > limitSwimMeters)
            System.out.println(name + " swim " + limitSwimMeters + " meters");
        else
            System.out.println(name + " swim " + meters + " meters");
    }

}

