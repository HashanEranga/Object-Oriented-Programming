import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int room_selected;
        boolean isParking, isTv, isKitchen, isWifi, isGarden, isAc, isBalcony;
        NumberFormat formatter=NumberFormat.getCurrencyInstance(Locale.US);

//        create room_charge_calc instance
        RoomChargeCalculator room_charge_calc = new RoomChargeCalculator();

//        created the initial menu
        System.out.print("Room Charge Calculator");
        System.out.println();
        System.out.print("1. Delux-Double");
        System.out.println();
        System.out.print("2. Standard-Family");
        System.out.println();
        System.out.print("3. Standard-Single");
        System.out.println();
        System.out.print("Quit");
        System.out.println();

//        your choice section
        Scanner scan_value = new Scanner(System.in);
        System.out.print("Enter your choice(1-4) : ");
        room_selected = scan_value.nextInt();
        System.out.println();

//        input validation
        switch (room_selected) {
            case 1 :
                try{
                    System.out.println("Delux-Double is Selected");
                    System.out.print("Is parking is used (true or false) : ");
                    isParking = scan_value.nextBoolean();
                    System.out.println();
                    System.out.print("Is balcony is used (true or false) : ");
                    isBalcony = scan_value.nextBoolean();
                    System.out.println();
                    System.out.print("Is tv is used (true or false) : ");
                    isTv = scan_value.nextBoolean();
                    System.out.println();
                    System.out.print("Is kitchen used (true or false) : ");
                    isKitchen = scan_value.nextBoolean();
                    System.out.println();
                    System.out.print("Is wifi is used (true or false) : ");
                    isWifi = scan_value.nextBoolean();
                    System.out.println();
                    System.out.println("Total Fee : " + formatter.format(room_charge_calc.getChargeDeluxDouble(isBalcony, isParking, isTv, isKitchen, isWifi)));

                }
                catch (InputMismatchException ex){
                    System.out.println("Input true or false only");
                    System.out.println(ex.getMessage());
                    System.exit(-1);
                }
                break;


            case 2 :
                try{
                    System.out.println("Standard-Family is Selected");
                    System.out.print("Is parking is used (true or false) : ");
                    isParking = scan_value.nextBoolean();
                    System.out.println();
                    System.out.print("Is kitchen is used (true or false) : ");
                    isKitchen = scan_value.nextBoolean();
                    System.out.println();
                    System.out.print("Is garden is used (true or false) : ");
                    isGarden = scan_value.nextBoolean();
                    System.out.println();
                    System.out.println("Total Fee : " + formatter.format(room_charge_calc.getChargeStandardFamily(isParking, isKitchen, isGarden)));

                }
                catch (InputMismatchException ex){
                    System.out.println("Input true or false only");
                    System.out.println(ex.getMessage());
                    System.exit(-1);
                }
                break;


            case 3 :
                try{
                    System.out.println("Standard-Single is Selected");
                    System.out.print("Is parking is used (true or false) : ");
                    isParking = scan_value.nextBoolean();
                    System.out.println();
                    System.out.print("Is AC is used (true or false) : ");
                    isAc = scan_value.nextBoolean();
                    System.out.println();
                    System.out.print("Is wifi is used (true or false) : ");
                    isWifi = scan_value.nextBoolean();
                    System.out.println();
                    System.out.println("Total Fee : " + formatter.format(room_charge_calc.getStandardSingle(isParking, isAc, isWifi)));

                }
                catch (InputMismatchException ex) {
                    System.out.println("Input true or false only");
                    System.out.println(ex.getMessage());
                    System.exit(-1);
                }
                break;


            case 4 : System.exit(0);
            default :
                System.out.println("Invalid Input");
                System.exit(-1);

        }

        scan_value.close();
    }
}

//    room charge calculator class definition
class RoomChargeCalculator {

    int FixedFee;
    int balconyFee;
    int parkingFee;
    int tvFee;
    int kitchenFee;
    int wifiFee;
    int acFee;
    int gardenFee;
    int totalFee;

    int getChargeDeluxDouble(boolean isBalcony, boolean isParking, boolean isTv, boolean isKitchen, boolean isWifi){
        FixedFee = 5000;
        balconyFee = 500;
        parkingFee = 200;
        tvFee = 200;
        kitchenFee = 1000;
        wifiFee = 100;

        totalFee = FixedFee;

        if(isBalcony) totalFee += balconyFee;
        if(isParking) totalFee += parkingFee;
        if(isTv) totalFee += tvFee;
        if(isKitchen) totalFee += kitchenFee;
        if(isWifi) totalFee += wifiFee;

        return totalFee;
    }

    int getChargeStandardFamily(boolean isParking, boolean isKitchen, boolean isGarden){
        FixedFee = 3000;
        parkingFee = 200;
        kitchenFee = 500;
        gardenFee = 200;

        totalFee = FixedFee;

        if(isParking) totalFee += parkingFee;
        if(isKitchen) totalFee += kitchenFee;
        if(isGarden) totalFee += gardenFee;

        return totalFee;
    }

    int getStandardSingle(boolean isParking, boolean isAc, boolean isWifi){
        FixedFee = 2000;
        parkingFee = 200;
        acFee = 500;
        wifiFee = 100;

        totalFee = FixedFee;

        if(isParking) totalFee += parkingFee;
        if(isAc) totalFee += acFee;
        if(isWifi) totalFee += wifiFee;

        return totalFee;
    }
}
