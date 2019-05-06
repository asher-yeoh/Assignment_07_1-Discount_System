import java.util.*;

class DiscountSystem {

    static void newScreen(ArrayList<Screen> alScreen, String name, int price) {
        Screen screen = new Screen(name, price);
        alScreen.add(screen);
    }

    static void newRam(ArrayList<Ram> alRam, String name, int price) {
        Ram ram = new Ram(name, price);
        alRam.add(ram);
    }

    static void newStorage(ArrayList<Storage> alStorage, String name, int price) {
        Storage storage = new Storage(name, price);
        alStorage.add(storage);
    }

    static void newProcessor(ArrayList<Processor> alProcessor, String name, int price) {
        Processor processor = new Processor(name, price);
        alProcessor.add(processor);
    }

    static void newDiscount(ArrayList<Discount> alDiscount, String code, int rate) {
        Discount discount = new Discount(code, rate);
        alDiscount.add(discount);
    }

    static void addLaptop(ArrayList<Cart> alShoppingCart, String nameScreen, int priceScreen, String nameRam, int priceRam, String nameStorage, int priceStorage, String nameProcessor, int priceProcessor, int subtotal) {
        Cart newLaptop = new Cart(nameScreen, priceScreen, nameRam, priceRam, nameStorage, priceStorage, nameProcessor, priceProcessor, subtotal); 
        alShoppingCart.add(newLaptop);
    }

    static void displayScreenOptions(ArrayList<Screen> alScreen) {
        for (int i = 0; i < alScreen.size(); i++) {
            System.out.println("(" + (i) + ") " + alScreen.get(i).name + " - Price: RM " + alScreen.get(i).price);
        }
    }

    static void displayRamOptions(ArrayList<Ram> alRam) {
        for (int i = 0; i < alRam.size(); i++) {
            System.out.println("(" + (i) + ") " + alRam.get(i).name + " - Price: RM " + alRam.get(i).price);
        }
    }

    static void displayStorageOptions(ArrayList<Storage> alStorage) {
        for (int i = 0; i < alStorage.size(); i++) {
            System.out.println("(" + (i) + ") " + alStorage.get(i).name + " - Price: RM " + alStorage.get(i).price);
        }
    }

    static void displayProcessorOptions(ArrayList<Processor> alProcessor) {
        for (int i = 0; i < alProcessor.size(); i++) {
            System.out.println("(" + (i) + ") " + alProcessor.get(i).name + " - Price: RM " + alProcessor.get(i).price);
        }
    }

    static int checkOutCart(ArrayList<Cart> alShoppingCart, int basePrice, int grandTotal) {
        for (int i = 0; i < alShoppingCart.size(); i++) {
            System.out.println("\nItem (" + (i+1) + ")");
            System.out.println("Laptop base price: RM " + basePrice);
            System.out.println("Selected Screen: " + alShoppingCart.get(i).nameScreen + " - Price: RM " + alShoppingCart.get(i).priceScreen);
            System.out.println("Selected RAM: " + alShoppingCart.get(i).nameRam + " - Price: RM " + alShoppingCart.get(i).priceRam);
            System.out.println("Selected Storage: " + alShoppingCart.get(i).nameStorage + " - Price: RM " + alShoppingCart.get(i).priceStorage);
            System.out.println("Selected Processor: " + alShoppingCart.get(i).nameProcessor + " - Price: RM " + alShoppingCart.get(i).priceProcessor);
            System.out.println("Subtotal: RM " + alShoppingCart.get(i).subtotal);

            grandTotal += alShoppingCart.get(i).subtotal;
        }

        return grandTotal;
    }
    public static void main(String args[]){

        ArrayList<Screen> alScreen = new ArrayList<Screen>();

        newScreen(alScreen, "1080p", 400);
        newScreen(alScreen, "4k", 600);
        newScreen(alScreen, "Touchscreen", 800);

        ArrayList<Ram> alRam = new ArrayList<Ram>();
        newRam(alRam, "8 GB", 100);
        newRam(alRam, "16 GB", 200);
        newRam(alRam, "32 GB", 300);

        ArrayList<Storage> alStorage=new ArrayList<Storage>();
        newStorage(alStorage, "1TB HDD", 1400);
        newStorage(alStorage, "128GB SSD", 600);
        newStorage(alStorage, "256GB SSD", 800);
        newStorage(alStorage, "512 GB SSD", 1000);

        ArrayList<Processor> alProcessor = new ArrayList<Processor>();
        newProcessor(alProcessor, "i3", 200);  
        newProcessor(alProcessor, "i5", 500);  
        newProcessor(alProcessor, "i7", 900); 

        ArrayList<Discount> alDiscount = new ArrayList<Discount>();
        newDiscount(alDiscount, "50OFF", 50);
        newDiscount(alDiscount, "100OFF", 100);
        newDiscount(alDiscount, "150OFF", 150);
        newDiscount(alDiscount, "200OFF", 200);
        newDiscount(alDiscount, "250OFF", 250);

        ArrayList<Cart> alShoppingCart = new ArrayList<Cart>();

        String selectedScreenName = "";
        int selectedScreenPrice = 0;
        String selectedRamName = "";
        int selectedRamPrice = 0;
        String selectedStorageName = "";
        int selectedStoragePrice = 0;
        String selectedProcessorName = "";
        int selectedProcessorPrice = 0;
        int subtotal = 0;

        int basePrice = 1000;
        int grandTotal = 0;

        boolean shopping = true;
        boolean shoppingCart = false;
        boolean isDiscount = false;
        boolean enterDiscount = true;

        System.out.println("----------------------------------------------------------------------");
        System.out.println("Please customize your laptop.\n");

        while (shopping) {
            System.out.println("Laptop base price: RM " + basePrice + "\n");

            displayScreenOptions(alScreen);
     
            System.out.println("\nPlease select Resolution:");
            Scanner inputScreen = new Scanner(System.in);
            Integer selectedScreen = Integer.parseInt(inputScreen.nextLine());

            for (int i = 0; i < alScreen.size(); i++) {
                if (selectedScreen == i) {
                    System.out.println("\nSelected Screen: (" + (i) + ") " + alScreen.get(i).name + " - Price: RM " + alScreen.get(i).price);
                    selectedScreenName = alScreen.get(i).name;
                    selectedScreenPrice = alScreen.get(i).price;
                }
            }

            System.out.println("----------------------------------------------------------------------");

            displayRamOptions(alRam);

            System.out.println("\nPlease select RAM:");
            Scanner inputRam = new Scanner(System.in);
            Integer selectedRam = Integer.parseInt(inputRam.nextLine());

            for (int i = 0; i < alRam.size(); i++) {
                if (selectedRam == i) {
                    System.out.println("\nSelected RAM: (" + (i) + ") " + alRam.get(i).name + " - Price: RM " + alRam.get(i).price);
                    selectedRamName = alRam.get(i).name;
                    selectedRamPrice = alRam.get(i).price;
                }
            }

            System.out.println("----------------------------------------------------------------------");

            displayStorageOptions(alStorage);

            System.out.println("\nPlease select Storage:");
            Scanner inputStorage = new Scanner(System.in);
            Integer selectedStorage = Integer.parseInt(inputStorage.nextLine());

            for (int i = 0; i < alStorage.size(); i++) {
                if (selectedStorage == i) {
                    System.out.println("\nSelected Storage: (" + (i) + ") " + alStorage.get(i).name + " - Price: RM " + alStorage.get(i).price);
                    selectedStorageName = alStorage.get(i).name;
                    selectedStoragePrice = alStorage.get(i).price;
                }
            }

            System.out.println("----------------------------------------------------------------------");

            displayProcessorOptions(alProcessor);

            System.out.println("\nPlease select Processor:");
            Scanner inputProcessor = new Scanner(System.in);
            Integer selectedProcessor = Integer.parseInt(inputProcessor.nextLine());

            for (int i = 0; i < alProcessor.size(); i++) {
                if (selectedProcessor == i) {
                    System.out.println("\nSelected Processor: (" + (i) + ") " + alProcessor.get(i).name + " - Price: RM " + alProcessor.get(i).price);
                    selectedProcessorName = alProcessor.get(i).name;
                    selectedProcessorPrice = alProcessor.get(i).price;
                }
            }

            subtotal = basePrice + selectedScreenPrice + selectedRamPrice + selectedStoragePrice + selectedProcessorPrice;

            System.out.println("----------------------------------------------------------------------");
            System.out.println("Laptop base price: RM " + basePrice);
            System.out.println("Selected Screen: "+ selectedScreenName + " - Price: RM " + selectedScreenPrice);
            System.out.println("Selected RAM: "+ selectedRamName + " - Price: RM " + selectedRamPrice);
            System.out.println("Selected Storage: "+ selectedStorageName + " - Price: RM " + selectedStoragePrice);
            System.out.println("Selected Processor: "+ selectedProcessorName + " - Price: RM " + selectedProcessorPrice);
            System.out.println("Subtotal: RM " + subtotal);

            System.out.println("\nDo you want to add this customized laptop to the shopping cart?");
            System.out.println("(0) Yes");
            System.out.println("(1) No");
            Scanner inputAddLaptop = new Scanner(System.in);
            Integer addLaptop = Integer.parseInt(inputAddLaptop.nextLine());
            if (addLaptop == 0) {
                addLaptop(alShoppingCart, selectedScreenName, selectedScreenPrice, selectedRamName, selectedRamPrice, selectedStorageName, selectedStoragePrice, selectedProcessorName, selectedProcessorPrice, subtotal);

                System.out.println("\nLaptop is added to the shopping cart.");
                shoppingCart = true;
            }

            else if (addLaptop == 1) {
                System.out.println("\nPrevious selection has been discarded.");
            }
            
            System.out.println("----------------------------------------------------------------------");

            System.out.println("Do you want to continue shopping?");
            System.out.println("(0) Yes");
            System.out.println("(1) No");
            Scanner inputShopping = new Scanner(System.in);
            Integer isShopping = Integer.parseInt(inputShopping.nextLine());
            if (isShopping == 0) {
                System.out.println("----------------------------------------------------------------------");
                System.out.println("Please customize your laptop.\n");
            }
            else if (isShopping == 1) {
                shopping = false;
            }

        }

        if (shoppingCart) {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("You are now at the checkout page.");
            System.out.println("\nCurrent item(s) in the shopping cart:");

            grandTotal = checkOutCart(alShoppingCart, basePrice, grandTotal);

            System.out.println("\nTotal item(s) in the shopping cart: " + alShoppingCart.size());
            System.out.println("Grand Total: RM " + grandTotal);

            while (enterDiscount) {
                System.out.println("\nDo you want to use any promo code?");
                System.out.println("(0) Yes");
                System.out.println("(1) No");
                Scanner inputHaveDiscount = new Scanner(System.in);
                Integer haveDiscountCode = Integer.parseInt(inputHaveDiscount.nextLine());

                System.out.println("----------------------------------------------------------------------");

                if (haveDiscountCode == 0) {
                    System.out.println("Please enter the promo code.");
                    Scanner inputDiscountCode = new Scanner(System.in);
                    String discountCode = inputDiscountCode.nextLine();

                    
                    for (int i = 0; i < alDiscount.size(); i++) {
                        if (discountCode.equals(alDiscount.get(i).code)) {
                            grandTotal -= alDiscount.get(i).rate;
                            isDiscount = true;
                            enterDiscount = false;

                            System.out.println("\nThe promo code entered is valid.");
                            System.out.println("You have obtained RM " + alDiscount.get(i).rate + " off.");
                            System.out.println("\nGrand Total after discount: RM " + grandTotal);
                            System.out.println("\nPlease proceed for payment. Thank you.");
                        }
                    }

                    if (!isDiscount) {
                        System.out.println("\nThe promo code entered is invalid.");
                    }
                    
                }

                else if (haveDiscountCode == 1) {
                    enterDiscount = false;

                    System.out.println("You have not used any promo code.");
                    System.out.println("\nGrand Total: RM " + grandTotal);
                    System.out.println("\nPlease proceed for payment. Thank you.");
                }

            }
        }

        else {
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Thanks for shopping with Dell. Good bye.");
        }

        System.out.println("----------------------------------------------------------------------");

    }
}

class Screen {
    String name;
    int price;

    Screen(String name,int price) {
        this.name = name;
        this.price = price;
    }
}

class Ram {
    String name;
    int price;

    Ram(String name,int price) {
        this.name = name;
        this.price = price;
    }
}

class Storage {
    String name;
    int price;

    Storage(String name,int price) {
        this.name = name;
        this.price = price;
    }
}

class Processor {
    String name;
    int price;

    Processor(String name,int price) {
        this.name = name;
        this.price = price;
    }
}

class Cart {
    String nameScreen;
    int priceScreen;
    String nameRam;
    int priceRam;
    String nameStorage;
    int priceStorage;
    String nameProcessor;
    int priceProcessor;
    int subtotal;

    Cart(String nameScreen, int priceScreen, String nameRam, int priceRam, String nameStorage, int priceStorage, String nameProcessor, int priceProcessor, int subtotal) {
        this.nameScreen = nameScreen;
        this.priceScreen = priceScreen;
        this.nameRam = nameRam;
        this.priceRam = priceRam;
        this.nameStorage = nameStorage;
        this.priceStorage = priceStorage;
        this.nameProcessor = nameProcessor;
        this.priceProcessor = priceProcessor;
        this.subtotal = subtotal;
    }
}

class Discount {
    String code;
    int rate;

    Discount(String code,int rate) {
        this.code = code;
        this.rate = rate;
    }
}