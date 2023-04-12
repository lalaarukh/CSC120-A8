import java.util.ArrayList;
import java.util.Random;

public class Bird implements Contract{
    String birdfood;
    String direction;
    int size;
    ArrayList<String> Inventory = new ArrayList<>();
    int x;
    int y;

    //constructor to create birdfood
    public void birdfood(String birdfood){
        this.birdfood = birdfood;
    }

    //constructor to create a Bird
    public Bird(String direction, int size, int x, int y){
        this.direction = direction;
        this.size = size;
        this.x = x;
        this.y = y;
    }

    //method for bird to eat food
    public void eat(String birdfood){
        System.out.println("The bird is eating" + this.birdfood);
    }

    //call on the eat method inside grab method
    public void grab(String birdfood){
        System.out.println("This bird has grabbed" + this.birdfood);
        this.Inventory.add(birdfood);
        System.out.println("The bird now has" + this.Inventory.size() + "amount of birdfood!");   
    }

    public String drop(String birdfood){
        System.out.println("Oh no! The bird dropped" + this.birdfood + "!");
        //remove from inventory arraylist
        this.Inventory.remove(birdfood);
        return this.birdfood;
    }

    public void examine(String birdfood){
        System.out.println("The bird is examining" + this.birdfood);
    }

    public void use(String birdfood){
        //call fly method in here so the bird can use its wings
        System.out.println("The bird is using it's wings to fly.Watch!");
        this.fly(4, 5);
    }

    public boolean walk(String direction){
        int distance = 1; //how much the bird should move
        if(direction.equals("north")){ 
            y-=distance;
        } else if (direction.equals("south")){
            y-=distance;
        } else if (direction.equals("east")){
            y-=distance;
        } else if (direction.equals("west")){
            y-= distance;
        } else {
            System.out.println("The bird cannot move in this direction");
            return false;
        }
        return true;
        }


    public boolean fly(int x, int y){
        Random r = new Random();
        //enable the bird to fly
        int coordX = r.nextInt(10) - 5;
        int coordY = r.nextInt(10) - 5;
        this.x += coordX;
        this.y += coordY;
        // check if the bird is really flying/moving or not
        if(coordX != 0 && coordY != 0){
            return true;
        } else {
            return false;
        }
    }

    public Number shrink(){
        this.size = this.size - 2;
        System.out.println("The bird is hiding from a predator by crouching :(. Lets hope it will be okay!)");
        return size;
    }

    public Number grow(){
        this.eat(this.birdfood);
        this.Inventory.remove(birdfood);
        System.out.println("The bird ate" + birdfood + "and is now growing!");
        this.size = this.size + 5;
        return size;
    }

    public void rest(){
        //reset coordinates such that the bird comes "home"
        this.x = 0;
        this.y = 0;
        System.out.println("The bird is home and is about to sleep.");

    }

    public void undo(){
        System.out.println("Sorry, you can't undo your actions");
    }
    
}
