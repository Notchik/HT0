package building;

import java.util.HashSet;
import java.util.Iterator;

public class Building {
    private String name;
    private HashSet<Room> roomList;

    public Building(String name) {
        this.name = name;
        this.roomList = new HashSet<>();
    }

    public void addRoom(String name, double square, int windowAmount){
        Room room = new Room(name,square,windowAmount);
        roomList.add(room);
    }

    public Room getRoom(String name){
        for (Room room : roomList) {
            if (room.getName().equals(name)) {
                return room;
            }
        }
        return null;
    }

    public void describe(){
        System.out.println(name);
        for(Room room : roomList){
            System.out.println("\t" + room.getName());
            System.out.print("\tLight: " + room.getLight() + " lk " + "(" + room.getWindowAmount() + " windows 700 lk each");
            Iterator<Lightbulb> iter = room.getLightbulbs().iterator();
            if(iter.hasNext()) {
                System.out.print(", lightbulbs of ");
                for (int i = 0; i < room.getLightbulbs().size(); i++) {
                    System.out.print(iter.next().getLk() + " lk");
                    if (iter.hasNext()) {
                        System.out.print(", ");
                    }
                }
                System.out.println(")");
            }
            else {
                System.out.println(")");
            }
            System.out.println("\tSquare: " + room.getSquare() + " m^2 " + "(free:" + (100 - room.getAverageSquare()/room.getSquare()*100) + "% of all space)");
            Iterator<Furniture> iter1 = room.getFurnitures().iterator();
            Iterator<Furniture> iter2 = room.getFurnitures().iterator();
            if(iter1.hasNext()) {
                System.out.println("\tFurniture: ");
                for (int i = 0; i < room.getFurnitures().size(); i++) {
                    System.out.println("\t\t" + iter1.next().getName() + " (" + iter2.next().getSize() + " m^2 )");
                }
            }
            else{
                System.out.println("\tNo furniture!");
            }
        }
    }
}
