import java.util.*;

class Room {
    int roomNumber;
    boolean booked;

    Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.booked = false;
    }
}

public class HotelBookingManagementSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            rooms.add(new Room(i));
        }

        while (true) {
            System.out.println("\n===== Hotel Booking System =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewRooms();
                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    cancelBooking();
                    break;
                case 4:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void viewRooms() {
        System.out.println("Available Rooms:");

        for (Room room : rooms) {
            if (!room.booked) {
                System.out.println("Room " + room.roomNumber);
            }
        }
    }

    static void bookRoom() {
        System.out.print("Enter Room Number to Book: ");
        int roomNo = sc.nextInt();

        for (Room room : rooms) {
            if (room.roomNumber == roomNo) {
                if (!room.booked) {
                    room.booked = true;
                    System.out.println("Room booked successfully!");
                } else {
                    System.out.println("Room already booked!");
                }
                return;
            }
        }

        System.out.println("Invalid room number!");
    }

    static void cancelBooking() {
        System.out.print("Enter Room Number to Cancel Booking: ");
        int roomNo = sc.nextInt();

        for (Room room : rooms) {
            if (room.roomNumber == roomNo) {
                if (room.booked) {
                    room.booked = false;
                    System.out.println("Booking cancelled successfully!");
                } else {
                    System.out.println("Room is not booked!");
                }
                return;
            }
        }

        System.out.println("Invalid room number!");
    }
}