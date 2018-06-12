import building.*;

public class Work {
    public static void main(String[] args) {
        Building building = new Building("Building 1");
        building.addRoom("Room 1",100,3);
        building.getRoom("Room 1").add(new Lightbulb(150));
        building.getRoom("Room 1").add(new Lightbulb(250));
        building.getRoom("Room 1").add("Table", 3);
        building.getRoom("Room 1").add("Soft Chair", 2);
        building.addRoom("Room 2",5,2);
        building.describe();
    }
}
