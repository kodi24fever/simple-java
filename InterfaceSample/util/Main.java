package util;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args){
        ArrayList<Drivable> listOfDrivableObjects = new ArrayList<>();

        Drivable temp = new Car("Nissan");
        temp.accelerate(20);
        listOfDrivableObjects.add(temp);

        for (Drivable drive: listOfDrivableObjects)
             System.out.println(drive.toString() + " speeds to: " + drive.getSpeed() + " km/h");

    }

}
