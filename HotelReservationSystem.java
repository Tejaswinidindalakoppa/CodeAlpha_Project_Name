import java.util.*;

class Room {
    int roomNumber;
    String category;
    boolean isAvailable;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = true;
    }

    void bookRoom() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Room " + roomNumber + " booked successfully!");
        } else {
            System.out.println("Room " + roomNumber + " is already booked.");
        }
    }

    void cancelBooking() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Room " + roomNumber + " booking canceled successfully.");
        } else {
            System.out.println("Room " + roomNumber + " is not booked.");
        }
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Category: " + category + ", Available: " + isAvailable;
    }
}

class Booking {
    String customerName;
    Room room;
    String paymentStatus;

    Booking(String customerName, Room room) {
        this.customerName = customerName;
        this.room = room;
        this.paymentStatus = "Pending";
    }

    void makePayment() {
        this.paymentStatus = "Completed";
        System.out.println("Payment for Room " + room.roomNumber + " is successful.");
    }

    void showBookingDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Room Number: " + room.roomNumber);
        System.out.println("Category: " + room.category);
        System.out.println("Payment Status: " + paymentStatus);
    }
}

public class HotelReservationSystem {

    static List<Room> rooms = new ArrayList<>();
    static List<Booking> bookings = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Initialize rooms
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(103, "Suite"));

        // Start the reservation system
        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. Search Available Rooms");
            System.out.println("2. Make Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Cancel Reservation");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    searchAvailableRooms();
                    break;
                case 2:
                    makeReservation();
                    break;
                case 3:
                    viewBookingDetails();
                    break;
                case 4:
                    cancelReservation();
                    break;
                case 5:
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Search available rooms
    public static void searchAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable) {
                System.out.println(room);
            }
        }
    }

    // Make a reservation
    public static void makeReservation() {
        System.out.print("\nEnter your name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter room number to book: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && room.isAvailable) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom != null) {
            selectedRoom.bookRoom();
            Booking booking = new Booking(customerName, selectedRoom);
            bookings.add(booking);
            System.out.println("Reservation made successfully!");
        } else {
            System.out.println("Room not available or invalid room number.");
        }
    }

    // View booking details
    public static void viewBookingDetails() {
        System.out.print("\nEnter your name to view booking details: ");
        String customerName = scanner.nextLine();

        boolean found = false;
        for (Booking booking : bookings) {
            if (booking.customerName.equalsIgnoreCase(customerName)) {
                booking.showBookingDetails();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No booking found for the provided name.");
        }
    }

    // Cancel a reservation
    public static void cancelReservation() {
        System.out.print("\nEnter your name to cancel reservation: ");
        String customerName = scanner.nextLine();

        boolean found = false;
        for (Booking booking : bookings) {
            if (booking.customerName.equalsIgnoreCase(customerName)) {
                booking.room.cancelBooking();
                bookings.remove(booking);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No booking found for the provided name.");
        }
    }
}
