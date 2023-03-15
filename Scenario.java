// a singleton representing the scenario

import java.util.ArrayList;
import java.util.HashMap;


class Scenario {

   // -----------------------------------------------------------\\
   // singleton method
   // -----------------------------------------------------------//
    private static Scenario _instance = null;

    public static Scenario instance(){
        if (_instance == null){
            _instance = new Scenario();
        }
        return _instance;
    }
    
   // -----------------------------------------------------------\\
   // defining scenario objects
   // -----------------------------------------------------------//

    // rooms ......................................................

    public static HashMap<String, Room> rooms = new HashMap<String, Room>() {{
        
        put("Reception", new Room("Reception", "assets/block-01.jpg", 1f, 2f ));
        put("Corridor Block1", new Room("Corridor Block1", "assets/block-01.jpg", 2f, 2f ));
        put("Nurse Station", new Room("Nurse Station", "assets/block-01.jpg", 3f, 2f ));
        put("Corridor Block4", new Room("Corridor Block4", "assets/block-01.jpg", 4f, 2f ));
        put("Laundry", new Room("Laundry", "assets/block-04.jpg", 5f, 2f ));
        put("Corridor Block2", new Room("Corridor Block4", "assets/block-01.jpg", 3f, 1f ));
        put("Corridor Block3", new Room("Corridor Block3", "assets/block-01.jpg", 3f, 0f ));
        put("Private Room1", new Room("Private Room1", "assets/block-02.jpg", 2f, 0f ));
        put("Private BathRoom1", new Room("Private BathRoom1", "assets/block-03.jpg", 1f, 0f ));
        put("Private Room2", new Room("Private Room2", "assets/block-02.jpg", 4f, 0f ));
        put("Private BathRoom2", new Room("Private BathRoom2", "assets/block-03.jpg", 5f, 0f ));
        put("Corridor Block5", new Room("Corridor Block3", "assets/block-01.jpg", 3f, 3f ));
        put("Common Toilet", new Room("Common Toilet", "assets/block-03.jpg", 2f, 3f ));
        put("Medical Room", new Room("Medical Room", "assets/block-06.jpg", 4f, 3f ));
        put("Corridor Block6", new Room("Corridor Block3", "assets/block-01.jpg", 3f, 4f ));
        put("Living Area", new Room("Living Area", "assets/block-08.jpg", 2f, 4f ));
        put("Boardgame Room", new Room("Boardgame Room", "assets/block-08.jpg", 1f, 4f ));
        put("Dining", new Room("Dining", "assets/block-07.jpg", 4f, 4f ));
        put("Kitchen", new Room("Kitchen", "assets/block-05.jpg", 5f, 4f ));
      
        //put("Common Space",  new Room("Common Space", "assets/CommonSpace.jpg", 0f, 1f));
        //put("Common Space2",  new Room("Common Space2", "assets/CommonSpace.jpg", 1f, 2f));
        //put("Kitchen",       new Room("Kitchen",      "assets/Kitchen.jpg",     2f, 1f));
        //put("Bedroom 1",     new Room("Bedroom 1",    "assets/Bedroom1.jpg",    0.5f, 0.0f));
        //put("Bedroom 2",     new Room("Bedroom 2",    "assets/Bedroom2.jpg",    1.5f, 0.0f));
        //put("Washroom",      new Room("Washroom",     "assets/Washroom.jpg",    3f, 1f));

    }}; 

    // characters .................................................

    public static HashMap<String, Character> characters = new HashMap<String, Character>(){{

        put("Jill Smith", new Character("Jill Smith", "assets/characters/mom.png"));
        put("Amy Copper", new Character("Amy Copper", "assets/characters/daughter.png"));
        put("Ben",        new Character("Ben",        "assets/characters/bebe.png"));
        put("Buddy",      new Character("Buddy",      "assets/characters/dog.png"));
        put("V",          new Character("V",          "assets/characters/bf.png"));
        put("Robot",      new Character("Robot",      "assets/characters/robot.png"));

    }};


    // items ......................................................

    public static HashMap<String, Item> items = new HashMap<String, Item>(){{
        put("Credit Card", new Item("Credit Card", "assets/items/credit_card.png")); 
        put("Wallet",      new Item("Wallet", "assets/items/wallet.png")); 
        put("Knife",       new Item("Knife", "assets/items/knife.png")); 
        put("Beer",        new Item("Beer", "assets/items/beer.png")); 
        put("Diary",       new Item("Diary", "assets/items/diary.png")); 

    }};

    
    
    private Scenario(){

        // -----------------------------------------------------------\\
        // creating map        
        // -----------------------------------------------------------//

        // connecting rooms ............................................
        rooms.get("Reception").addConnection(rooms.get("Corridor Block1"));
        rooms.get("Corridor Block1").addConnection(rooms.get("Nurse Station"));
        rooms.get("Nurse Station").addConnection(rooms.get("Corridor Block4"));
        rooms.get("Nurse Station").addConnection(rooms.get("Corridor Block2"));
        rooms.get("Nurse Station").addConnection(rooms.get("Corridor Block5"));
        rooms.get("Corridor Block2").addConnection(rooms.get("Corridor Block3"));
        rooms.get("Corridor Block3").addConnection(rooms.get("Private Room1"));
        rooms.get("Private Room1").addConnection(rooms.get("Private BathRoom1"));
        rooms.get("Corridor Block3").addConnection(rooms.get("Private Room2"));
        rooms.get("Corridor Block4").addConnection(rooms.get("Laundry"));
        rooms.get("Private Room2").addConnection(rooms.get("Private BathRoom2"));
        rooms.get("Corridor Block5").addConnection(rooms.get("Medical Room"));
        rooms.get("Corridor Block5").addConnection(rooms.get("Corridor Block6"));
        rooms.get("Corridor Block6").addConnection(rooms.get("Living Area"));
        rooms.get("Living Area").addConnection(rooms.get("Boardgame Room"));
        rooms.get("Living Area").addConnection(rooms.get("Common Toilet"));
        rooms.get("Corridor Block6").addConnection(rooms.get("Dining"));
        rooms.get("Dining").addConnection(rooms.get("Kitchen"));
        
        
        //rooms.get("Common Space").addConnection(rooms.get("Kitchen"));
        //rooms.get("Common Space").addConnection(rooms.get("Bedroom 1"));
        //rooms.get("Common Space").addConnection(rooms.get("Bedroom 2"));
        //rooms.get("Kitchen")     .addConnection(rooms.get("Washroom"));        
        
        // placing characters ..........................................
        rooms.get("Private Room1").addCharacter(characters.get("Jill Smith"));
        rooms.get("Private BathRoom1").addCharacter(characters.get("Amy Copper"));
        rooms.get("Living Area").addCharacter(characters.get("Ben"));
        rooms.get("Kitchen").addCharacter(characters.get("Buddy"));
        rooms.get("Laundry").addCharacter(characters.get("V"));
        rooms.get("Nurse Station").addCharacter(characters.get("Robot"));


        // placing items .............................................
        rooms.get("Kitchen")     .addItem(items.get("Knife"));
        rooms.get("Private Room1")   .addItem(items.get("Diary"));
        rooms.get("Private Room2").addItem(items.get("Credit Card"));
        rooms.get("Living Area")   .addItem(items.get("Wallet"));
        rooms.get("Dining")    .addItem(items.get("Beer"));       
    }

    public Character getRobot(){
        return characters.get("Robot");
    }
}
