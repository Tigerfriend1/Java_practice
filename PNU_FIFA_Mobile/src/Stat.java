class Stat {

    private final String name;

    private final int value;

    public Stat(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    // auto-generated getter and toString methods


    @Override
    public String toString() {
        return name+":"+value;
    }
}