import java.util.ArrayList;
import java.util.Scanner;

class Destination {
    String name;
    String date;
    double budget;

    Destination(String name, String date, double budget) {
        this.name = name;
        this.date = date;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Destination: " + name + ", Date: " + date + ", Budget: $" + String.format("%.2f", budget);
    }
}

public class TravelItineraryPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Destination> itinerary = new ArrayList<>();
        boolean exit = false;
        double totalBudget = 0;

        System.out.println("Welcome to the Travel Itinerary Planner!");

        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a destination");
            System.out.println("2. View itinerary");
            System.out.println("3. Calculate total budget");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the destination: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter the date (e.g., 2025-01-18): ");
                    String date = scanner.nextLine();

                    System.out.print("Enter the budget for this destination: $");
                    double budget = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    itinerary.add(new Destination(name, date, budget));
                    System.out.println("Destination added successfully!");
                    break;

                case 2:
                    System.out.println("\nYour Itinerary:");
                    if (itinerary.isEmpty()) {
                        System.out.println("No destinations added yet.");
                    } else {
                        for (Destination dest : itinerary) {
                            System.out.println(dest);
                        }
                    }
                    break;

                case 3:
                    totalBudget = itinerary.stream().mapToDouble(d -> d.budget).sum();
                    System.out.println("Total Budget for the trip: $" + String.format("%.2f", totalBudget));
                    break;

                case 4:
                    exit = true;
                    System.out.println("Thank you for using the Travel Itinerary Planner. Safe travels!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
