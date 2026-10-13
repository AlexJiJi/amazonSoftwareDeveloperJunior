
public class Tiger extends Animal implements Eat, Walk {
    private int numOfStripes;
    private int runningSpeed;

    public Tiger() {
        super();
    }

    public Tiger(String animalName, int animalAge, double animalHeight, double animalWeight, int numOfStripes, int runningSpeed) {
        super(animalName, animalAge, animalHeight, animalWeight);
        this.numOfStripes = numOfStripes;
        this.runningSpeed = runningSpeed;
    }

    public int getNumOfStripes() {
        return numOfStripes;
    }

    public void setNumOfStripes(int numOfStripes) {
        if (numOfStripes < 0) {
            this.numOfStripes = 0;
        } else {
            this.numOfStripes = numOfStripes;
        }

    }

    public int getRunningSpeed() {
        return runningSpeed;
    }

    public void setRunningSpeed(int runningSpeed) {
        if (runningSpeed < 0) {
            this.runningSpeed = 0;
        } else {
            this.runningSpeed = runningSpeed;
        }
    }

    // implemented Eat interface unique methods
    @Override
    public void finishEating() {
        System.out.println("Tiger is finished eating.");
    }

    // implemented walk interface method
    @Override
    public void walking() {
        System.out.println("Tiger " + super.getAnimalName() + " is walking at " + this.runningSpeed + " speed!");
    }

    @Override
    public String toString() {
        return "Tiger{" +
                "animalName='" + this.getAnimalName() + '\'' +
                ", animalAge=" + this.getAnimalAge() +
                ", animalWeight=" + this.getAnimalWeight() +
                ", animalHeight=" + this.getAnimalHeight() +
                ", typeOfFood='" + this.getTypeOfFood() +
                ", numOfStripes=" + numOfStripes +
                ", runningSpeed=" + runningSpeed + '\'' +
                '}';
    }

}
