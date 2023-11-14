import java.security.cert.CertPathBuilder;

public abstract class Player {
    private String name ;
    private int jerseyNumber ;
    protected int speed ;
    // Builder 클래스를 정의하시오. (단, static nested class 로 정의하시오.  )


    public Player(String name, int jerseyNumber, int speed) {
        this.name = name;
        this.jerseyNumber = jerseyNumber;
        this.speed = speed;
    }

    public static class Builder{
        private String name ;
        private int jerseyNumber ;
        protected int speed ;
        protected String playerType;

        public Builder setPlayerType(String type) {
            this.playerType=type;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setJerseyNumber(int jerseyNumber) {
            this.jerseyNumber=jerseyNumber;
            return this;
        }

        public Builder setSpeed(int speed) {
            this.speed = speed;
            return this;
        }

        public Player build() {
            switch (playerType){
                case "forward"-> {
                    return new Forward(name,jerseyNumber,speed);
                }
                case "midfielder"-> {
                    return new Midfielder(name,jerseyNumber,speed);
                }
                case "defender"-> {
                   return new Defender(name,jerseyNumber,speed);
                }
                default -> {
                    return null;
                }
            }
        }

        //Player Name='romelu, JerseyNumber=9, SPEED=110, Forward

    }
    @Override
    public String toString() {
        return "Player " +
                "Name='" + name  +
                ", JerseyNumber=" + jerseyNumber +
                ", ";
    }
    protected abstract int getSpeed() ;
}