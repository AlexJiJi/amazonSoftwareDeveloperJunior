import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        //object creation
        Tiger tiger = new Tiger();
        Dolphin dolphin = new Dolphin();
        Penguin penguin = new Penguin();

        // for loop continuation - 1 represents true
        int continueOuterLoop = 1;
        int continueInnerLoop = 1;

        // for menu choice
        int menuChoice = 1;

        do {
            switch (animalChoiceMenu(keyboard)) {
                case 1:
                    do {
                        System.out.println("The animal which is chosen is : " + tiger.getAnimalName());
                        // get menu choice
                        menuChoice = animalDetailsManipulationMenu(keyboard, tiger);
                        switch (menuChoice) {
                            case 1:
                                // animal attributes
                                System.out.println("Enter the name of the animal");
                                tiger.setAnimalName(keyboard.next());
                                System.out.println("Enter age: ");
                                tiger.setAnimalAge(keyboard.nextInt());
                                System.out.println("Enter height: ");
                                tiger.setAnimalHeight(keyboard.nextDouble());
                                System.out.println("Enter weight: ");
                                tiger.setAnimalWeight(keyboard.nextDouble());
                                System.out.println("Enter " + tiger.getAnimalName() + " type of food:");
                                tiger.setTypeOfFood(keyboard.next());

                                // tiger attributes
                                System.out.println("Enter speed: ");
                                tiger.setRunningSpeed(keyboard.nextInt());
                                System.out.println("Enter the number of stripes: ");
                                tiger.setNumOfStripes(keyboard.nextInt());
                                break;
                            case 2:
                                // animal attributes
                                System.out.println("Name: " + tiger.getAnimalName());
                                System.out.println("Age: " + tiger.getAnimalAge());
                                System.out.println("Height: " + tiger.getAnimalHeight());
                                System.out.println("Weight: " + tiger.getAnimalWeight());
                                System.out.println("Type of food: " + tiger.getTypeOfFood());
                                //tiger attributes
                                System.out.println("Speed: " + tiger.getRunningSpeed());
                                System.out.println("Number of stripes: " + tiger.getNumOfStripes());
                                break;
                            case 3:
                                tiger.walking();
                                break;
                            case 4:
                                tiger.eating();
                                tiger.finishEating();
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }
                        System.out.println("Continue with this animal ? (Enter 1 for yes/ 2 for no):");
                        continueInnerLoop = keyboard.nextInt();
                    } while (continueInnerLoop == 1);
                    break;
                case 2:
                    do {
                        System.out.println("The animal which is chosen is : " + dolphin.getAnimalName());
                        // get menu choice
                        menuChoice = animalDetailsManipulationMenu(keyboard, dolphin);
                        switch (menuChoice) {
                            case 1:
                                //animal common attributes
                                System.out.println("Enter the name of the animal");
                                dolphin.setAnimalName(keyboard.next());
                                System.out.println("Enter age: ");
                                dolphin.setAnimalAge(keyboard.nextInt());
                                System.out.println("Enter height: ");
                                dolphin.setAnimalHeight(keyboard.nextDouble());
                                System.out.println("Enter weight: ");
                                dolphin.setAnimalWeight(keyboard.nextDouble());
                                System.out.println("Enter " + dolphin.getAnimalName() + " type of food:");
                                dolphin.setTypeOfFood(keyboard.next());
                                // dolphin attributes
                                System.out.println("Enter color of dolphin: ");
                                dolphin.setSkinColor(keyboard.next());
                                System.out.println("Enter swimming speed: ");
                                dolphin.setSwimmingSpeed(keyboard.nextDouble());
                                break;
                            case 2:
                                //animal attributes
                                System.out.println("Name: " + dolphin.getAnimalName());
                                System.out.println("Age: " + dolphin.getAnimalAge());
                                System.out.println("Height: " + dolphin.getAnimalHeight());
                                System.out.println("Weight: " + dolphin.getAnimalWeight());
                                System.out.println("Type of food: " + dolphin.getTypeOfFood());
                                // dolphin attributes
                                System.out.println("Color of dolphin: " + dolphin.getSkinColor());
                                System.out.println("Swimming speed: " + dolphin.getSwimmingSpeed());
                                break;
                            case 3:
                                dolphin.swimming();
                                break;
                            case 4:
                                dolphin.eating();
                                dolphin.finishEating();
                                break;
                            default:
                                System.out.println("Invalid choice");

                        }
                        System.out.println("Continue with this animal ? (Enter 1 for yes/ 2 for no):");
                        continueInnerLoop = keyboard.nextInt();
                    } while (continueInnerLoop == 1);
                    break;
                case 3:
                    do {
                        System.out.println("The animal which is chosen is : " + penguin.getAnimalName());
                        // get menu choice
                        menuChoice = animalDetailsManipulationMenu(keyboard, penguin);
                        switch (menuChoice) {
                            case 1:
                                // animal attributes
                                System.out.println("Enter the name of the animal");
                                penguin.setAnimalName(keyboard.next());
                                System.out.println("Enter age: ");
                                penguin.setAnimalAge(keyboard.nextInt());
                                System.out.println("Enter height: ");
                                penguin.setAnimalHeight(keyboard.nextDouble());
                                System.out.println("Enter weight: ");
                                penguin.setAnimalWeight(keyboard.nextDouble());
                                System.out.println("Enter type of food: ");
                                penguin.setTypeOfFood(keyboard.next());
                                // penguin attributes
                                System.out.println("Is the penguin swimming? (true/false) ");
                                penguin.setSwimming(keyboard.nextBoolean());
                                if (penguin.isSwimming()) {
                                    System.out.println("Enter swimming speed: ");
                                    penguin.setSwimmingSpeed(keyboard.nextDouble());
                                } else {
                                    System.out.println("Enter walking speed: ");
                                    penguin.setWalkingSpeed(keyboard.nextDouble());
                                }
                                break;
                            case 2:
                                System.out.println("Name: " + penguin.getAnimalName());
                                System.out.println("Age: " + penguin.getAnimalAge());
                                System.out.println("Height: " + penguin.getAnimalHeight());
                                System.out.println("Weight: " + penguin.getAnimalWeight());
                                System.out.println("Type of food: " + penguin.getTypeOfFood());
                                if (penguin.isSwimming()) {
                                    System.out.println("Swimming speed: " + penguin.getSwimmingSpeed());
                                } else {
                                    System.out.println("Walking speed: " + penguin.getWalkingSpeed());
                                }
                                break;
                            case 3:
                                if (penguin.isSwimming()) {
                                    penguin.swimming();
                                } else {
                                    penguin.walking();
                                }
                                break;
                            case 4:
                                penguin.eating();
                                penguin.finishEating();
                                break;
                            default:
                                System.out.println("Invalid choice");

                        }
                        System.out.println("Continue with this animal ? (Enter 1 for yes/ 2 for no):");
                        continueInnerLoop = keyboard.nextInt();
                    } while (continueInnerLoop == 1);
                    break;
                case 4:
                    saveAnimalToFile(tiger, penguin, dolphin);
                    break;
                case 5:
                    readObjectsFromFile();
                    break;
                case 6:
                    Tiger tigerRead;
                    Dolphin dolphinRead;
                    Penguin penguinRead;
                    tigerRead = retrieveTigerFromFile();
                    dolphinRead = retrieveDolphinFromFile();
                    penguinRead = retrievePenguinFromFile();
                    if (tigerRead != null) {
                        tiger = tigerRead;
                    }
                    if (dolphinRead != null) {
                        dolphin = dolphinRead;
                    }
                    if (penguinRead != null) {
                        penguin = penguinRead;
                    }
                    break;
                case 7:
                    continueOuterLoop = 7;
                    break;
                default:
                    System.out.println("Sorry no such animal available.");
            }

        } while (continueOuterLoop != 7);

    }

    private static int animalChoiceMenu(Scanner keyboard) {
        int choiceGivenByUser;

        System.out.println("******* ZOO ANIMAL choice menu ******");
        System.out.println("1. Tiger");
        System.out.println("2. Dolphin");
        System.out.println("3. Penguin");
        System.out.println("4. Save animals data to file");
        System.out.println("5. Show animals files");
        System.out.println("6. Retrieve Animals data from files");
        System.out.println("7. Exit");

        System.out.println("Enter choice of animal:");
        choiceGivenByUser = keyboard.nextInt();
        return choiceGivenByUser;
    }

    private static int animalDetailsManipulationMenu(Scanner keyboard, Animal animal) {
        int choiceGivenByUser;

        System.out.println("******* ANIMAL details menu for: " + animal.getAnimalName() + " ******");
        System.out.println("1. Set properties");
        System.out.println("2. Display properties");
        System.out.println("3. Display movement");
        System.out.println("4. Display eating");

        System.out.println("Enter choice (1-4):");
        choiceGivenByUser = keyboard.nextInt();
        return choiceGivenByUser;

    }

    public static void saveAnimalToFile(Tiger tiger, Penguin penguin, Dolphin dolphin) {
        if (tiger.getAnimalName().equals("Unknown animal")) {
            System.out.println("Unknown tiger");
        } else {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("animals\\tiger.txt"))) {
                oos.writeObject(tiger);
                System.out.println("tiger's name= " + tiger.getAnimalName());
                System.out.println("Tiger object written to the file successfully.");

            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            }
        }

        if (penguin.getAnimalName().equals("Unknown animal")) {
            System.out.println("Unknown penguin");
        } else {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("animals\\penguin.txt"))) {
                oos.writeObject(penguin);
                System.out.println("penguin's name= " + penguin.getAnimalName());
                System.out.println("Penguin object written to the file successfully.");

            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            }
        }

        if (dolphin.getAnimalName().equals("Unknown animal")) {
            System.out.println("Unknown dolphin");
        } else {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("animals\\dolphin.txt"))) {
                oos.writeObject(dolphin);
                System.out.println("Dolphin's name= " + penguin.getAnimalName());
                System.out.println("Dolphin object written to the file successfully.");

            } catch (IOException ioException) {
                System.out.println(ioException.getMessage());
            }
        }
    }


    public static Tiger retrieveTigerFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("animals\\tiger.txt"))) {

            Object restoredObject = ois.readObject();
            Tiger restoredTiger = (Tiger) restoredObject;
            System.out.println("Tiger retrieved from the file successfully.");
            return restoredTiger;

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Tiger File not found");
        } catch (IOException | ClassNotFoundException ioException) {
            System.out.println(ioException.getMessage());
        }
        return null;
    }

    public static Penguin retrievePenguinFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("animals\\penguin.txt"))) {

            Object restoredObject = ois.readObject();
            Penguin restoredPenguin = (Penguin) restoredObject;
            System.out.println("Penguin retrieved from the file successfully.");
            return restoredPenguin;

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Penguin File not found");
        } catch (IOException | ClassNotFoundException ioException) {
            System.out.println(ioException.getMessage());
        }
        return null;
    }

    public static Dolphin retrieveDolphinFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("animals\\dolphin.txt"))) {

            Object restoredObject = ois.readObject();
            Dolphin restoredDolphin = (Dolphin) restoredObject;
            System.out.println("Delphin retrieved from the file successfully.");
            return restoredDolphin;

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File not found");
        } catch (IOException | ClassNotFoundException ioException) {
            System.out.println(ioException.getMessage());
        }
        return null;
    }

    public static void readObjectsFromFile() {
        System.out.println("\nSaved animals:");
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("animals\\tiger.txt"))) {

            Animal tiger = (Tiger) ois.readObject();
            System.out.println("Tiger successfully read from file");
            System.out.println(tiger);

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Tiger File not found");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("animals\\dolphin.txt"))) {

            Animal dolphin = (Dolphin) ois.readObject();
            System.out.println("Dolphin successfully read from file");
            System.out.println(dolphin);

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Dolphin File not found");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("animals\\penguin.txt"))) {

            Animal penguin = (Penguin) ois.readObject();
            System.out.println("Penguin successfully read from file");
            System.out.println(penguin);

        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Penguin File not found");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}