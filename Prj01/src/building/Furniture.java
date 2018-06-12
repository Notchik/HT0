package building;

class Furniture {
    private String name;
    private double size;

    Furniture(String name, double size) {
        this.name = name;
        this.size = size;
    }

    String getName() {
        return name;
    }

    double getSize() {
        return size;
    }
}
