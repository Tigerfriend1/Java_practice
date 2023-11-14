public class Defender extends Player{

    protected String playerType;
    public Defender(String name, int jerseyNumber, int speed) {
        super(name,jerseyNumber,speed);
        playerType="Defender";
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder(super.toString());
        st.append("Speed=" + getSpeed() + ", ");
        st.append(playerType);
        return st.toString();
    }

    @Override
    protected int getSpeed() {
        return speed-10;
    }
}
