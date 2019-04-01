package ua.nure.timoshenko.practice6.part3;

public class Part3 {

    private static final int QUANTITY_PLACE = 5;

    public static void main(String[] args) {
    Parking parking=new Parking(QUANTITY_PLACE);
    parking.showParking();

    parking.arrive(2,"Opel");
    parking.arrive(2,"BMW");
    parking.arrive(2,"Nissan");
    parking.showParking();

    parking.depart("BMW");
    parking.showParking();
    }
}
