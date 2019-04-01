package ua.nure.timoshenko.practice6.part3;


import java.util.Arrays;

public class Parking {
    private Object[] cars;

    public Parking(int quantityPlace) {
        this.cars = new Object[quantityPlace];
    }


    public boolean arrive(int pos, @NotNull Object car) {
        boolean result = false;
        if ((pos >= 0) && (pos < cars.length - 1) && (!isEmptyPos(pos, car))) {
            for (int i = ++pos; i < cars.length; i++) {
                result = isEmptyPos(i, car);
                if (result) {
                    break;
                }
            }
        }
        return result;
    }

    private boolean isEmptyPos(int pos, Object car) {
        if (cars[pos] == (null)) {
            cars[pos] = car;
            return true;
        } else {
            return false;
        }
    }

    public boolean depart(Object car) {
        boolean result = false;
        if (car != null) {
            for (int i = 0; i < cars.length; i++) {
                if (car.equals(cars[i])) {
                    cars[i] = null;
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public void showParking() {
        System.out.println(Arrays.toString(cars));
    }

}
