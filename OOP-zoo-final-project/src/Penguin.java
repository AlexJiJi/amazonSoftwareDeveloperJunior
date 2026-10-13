
public class Penguin extends Animal implements Eat, Walk, Swim {
    private String bellyColor;
    private double walkingSpeed;
    private double swimmingSpeed;
    private boolean isSwimming;

    public Penguin() {
        super();
    }

    // constructor
    public Penguin(String animalName, int animalAge, double animalWeight, double animalHeight, String bellyColor, double walkingSpeed, double swimmingSpeed) {
        super(animalName, animalAge, animalWeight, animalHeight);
        this.bellyColor = bellyColor;
        this.walkingSpeed = walkingSpeed;
        this.swimmingSpeed = swimmingSpeed;
    }

    //getters and setters
    public String getBellyColor() {
        return bellyColor;
    }

    public void setBellyColor(String bellyColor) {
        this.bellyColor = bellyColor;
    }

    public double getWalkingSpeed() {
        return walkingSpeed;
    }

    public void setWalkingSpeed(double walkingSpeed) {
        this.walkingSpeed = walkingSpeed;
    }

    public double getSwimmingSpeed() {
        return swimmingSpeed;
    }

    public void setSwimmingSpeed(double swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    public boolean isSwimming() {
        return isSwimming;
    }

    public void setSwimming(boolean swimming) {
        this.isSwimming = swimming;
    }

    // overridden unique Eat method interface
    @Override
    public void finishEating() {
        System.out.println("Penguin finished eating.");
    }

    // implemented interfaces
    @Override
    public void swimming() {
        System.out.println("Penguin " + super.getAnimalName() + " is swimming!");
    }

    @Override
    public void walking() {
        System.out.println("Penguin " + super.getAnimalName() + " is walking!");
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "animalName='" + this.getAnimalName() + '\'' +
                ", animalAge=" + this.getAnimalAge() +
                ", animalWeight=" + this.getAnimalWeight() +
                ", animalHeight=" + this.getAnimalHeight() +
                ", typeOfFood='" + this.getTypeOfFood() +
                ", bellyColor=" + bellyColor +
                ", walkingSpeed=" + walkingSpeed +
                "' swimmingSpeed=" + swimmingSpeed +
                "' isSwimming= " + isSwimming + '\'' +
                '}';
    }
}
