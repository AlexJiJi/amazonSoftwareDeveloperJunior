import java.io.Serializable;

abstract public class Animal implements Eat, Serializable {
    private static final long serialVersionUID = 1L;

    // animal's common attributes
    private String animalName;
    private int animalAge;
    private double animalWeight;
    private double animalHeight;
    private String typeOfFood;

    public Animal() {
        this.animalName = "Unknown animal";
    }
    // constructor
    public Animal(String animalName, int animalAge, double animalWeight, double animalHeight) {
        this.animalName = animalName;
        this.animalAge = animalAge;
        this.animalWeight = animalWeight;
        this.animalHeight = animalHeight;
    }

    // getters y setters
    public String getAnimalName() {
        return animalName;
    }
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getAnimalAge() {
        return animalAge;
    }
    public void setAnimalAge(int animalAge) {
        if (animalAge < 0){
            this.animalAge = 0;
        } else {
            this.animalAge = animalAge;
        }
    }

    public double getAnimalWeight() {
        return animalWeight;
    }
    public void setAnimalWeight(double animalWeight) {
        if (animalWeight < 0){
            this.animalWeight = 0;
        } else {
            this.animalWeight = animalWeight;
        }
    }

    public double getAnimalHeight() {
        return animalHeight;
    }
    public void setAnimalHeight(double animalHeight) {
        if (animalHeight < 0){
            this.animalHeight = 0;
        } else {
            this.animalHeight = animalHeight;
        }
    }
    public String getTypeOfFood() {
        return this.typeOfFood;
    }
    public void setTypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    // common animal's implemented methods
    public void eating(){
        System.out.println(this.animalName + " is eating");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalName='" + animalName + '\'' +
                ", animalAge=" + animalAge +
                ", animalWeight=" + animalWeight +
                ", animalHeight=" + animalHeight +
                ", typeOfFood='" + typeOfFood + '\'' +
                '}';
    }
}
