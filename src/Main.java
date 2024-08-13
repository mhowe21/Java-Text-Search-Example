import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean continueLoop = true;
        // list of US States in a string
        final String USStates = "Alabama, Alaska, Arizona, Arkansas, California, Colorado, Connecticut, Delaware, Florida, Georgia, Hawaii, Idaho, Illinois, Indiana, Iowa, Kansas, Kentucky, Louisiana, Maine, Maryland, Massachusetts, Michigan, Minnesota, Mississippi, Missouri, Montana, Nebraska, Nevada, New Hampshire, New Jersey, New Mexico, New York, North Carolina, North Dakota, Ohio, Oklahoma, Oregon, Pennsylvania, Rhode Island, South Carolina, South Dakota, Tennessee, Texas, Utah, Vermont, Virginia, Washington, West Virginia, Wisconsin, Wyoming";
        Scanner scanner = new Scanner(System.in);

        do {
            // options menu
            System.out.println("Select an Option below:");
            System.out.println("1. List of US States");
            System.out.println("2. Search US States");
            System.out.println("3. Exit");

            int option = scanner.nextInt();
            // switch case logic depending on selected option
            switch (option) {
                case 1:
                    System.out.println(USStates);
                    continueLoop = ConLoop();
                    break;
                case 2:
                    System.out.print("Enter Search Pattern: ");
                    String pattern = scanner.next();
                    // add the main US states string to the algorithm
                    BoyerMooreAlgo boyerMooreAlgo = new BoyerMooreAlgo(USStates);
                    // use the search method to search for the pattern
                    System.out.println(boyerMooreAlgo.search(pattern));

                    break;
                case 3:
                    // exit logic
                    System.out.println("Good Bye!");
                    continueLoop = false;
                    scanner.close();
                    break;
                default:
                    System.out.println("Invalid option please try again");
                    break;
            }

        } while (continueLoop);
    }

    public static boolean ConLoop() {
        // logic to continue or not
        Scanner scanner = new Scanner(System.in);
        System.out.print("would you like to continue y/n?");
        String answer = scanner.nextLine();
        // get user input for yes or y and then exit if not one of those options.
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
            return true;
        } else {
            System.out.println("Good Bye!");
            scanner.close();
            return false;

        }
    }
}
