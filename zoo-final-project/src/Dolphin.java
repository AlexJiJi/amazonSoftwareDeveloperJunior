
public class Dolphin extends Animal implements Eat, Swim{
    private String skinColor;
    private double swimmingSpeed;

    public Dolphin() {
        super();
    }
    public Dolphin(String animalName, int animalAge, double animalWeight, double animalHeight, String skinColor, double swimmingSpeed) {
        super(animalName, animalAge, animalWeight, animalHeight);
        this.skinColor = skinColor;
        this.swimmingSpeed = swimmingSpeed;
    }

    // setter and getters
    public String getSkinColor() {
        return skinColor;
    }
    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }
    public double getSwimmingSpeed() {
        return swimmingSpeed;
    }
    public void setSwimmingSpeed(double swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
    }

    // implemented remaining Eat method
    @Override
    public void finishEating() {
        System.out.println("Dolphin is finished eating.");
    }

    // swim interface implementation
    @Override
    public void swimming() {
        System.out.println(super.getAnimalName() + "dolphin is swimming at " + this.getSwimmingSpeed() + " speed!");
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "animalName='" + this.getAnimalName() + '\'' +
                ", animalAge=" + this.getAnimalAge() +
                ", animalWeight=" + this.getAnimalWeight() +
                ", animalHeight=" + this.getAnimalHeight() +
                ", typeOfFood='" + this.getTypeOfFood() +
                ", skinColor=" + skinColor +
                ", swimmingSpeed=" + swimmingSpeed + '\'' +
                '}';
    }
}
