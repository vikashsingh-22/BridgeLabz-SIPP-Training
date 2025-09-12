package LinkedList;

import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

public class SocialMedia {
    private User head = null;

    // Add a new user
    public void addUser(int userId, String name, int age) {
        if (getUserById(userId) != null) {
            System.out.println("User with ID already exists.");
            return;
        }

        User newUser = new User(userId, name, age);
        newUser.next = head;
        head = newUser;
        System.out.println("User added successfully.");
    }

    // Search user by ID or Name
    public void searchUser(int id, String name) {
        User temp = head;
        boolean found = false;
        while (temp != null) {
            if ((id != -1 && temp.userId == id) || (name != null && temp.name.equalsIgnoreCase(name))) {
                printUser(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) System.out.println("User not found.");
    }

    // Add friend connection
    public void addFriend(int id1, int id2) {
        if (id1 == id2) {
            System.out.println("Cannot add yourself as friend.");
            return;
        }

        User user1 = getUserById(id1);
        User user2 = getUserById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!user1.friendIds.contains(id2)) user1.friendIds.add(id2);
        if (!user2.friendIds.contains(id1)) user2.friendIds.add(id1);

        System.out.println("Friend connection added.");
    }

    // Remove friend connection
    public void removeFriend(int id1, int id2) {
        User user1 = getUserById(id1);
        User user2 = getUserById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }

        user1.friendIds.remove(Integer.valueOf(id2));
        user2.friendIds.remove(Integer.valueOf(id1));

        System.out.println("Friend connection removed.");
    }

    // Display all friends of a user
    public void displayFriends(int userId) {
        User user = getUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println("Friends of " + user.name + ":");
        if (user.friendIds.isEmpty()) {
            System.out.println("No friends.");
            return;
        }

        for (int fid : user.friendIds) {
            User friend = getUserById(fid);
            if (friend != null) {
                System.out.println("- " + friend.name + " (ID: " + friend.userId + ")");
            }
        }
    }

    // Find mutual friends between two users
    public void mutualFriends(int id1, int id2) {
        User user1 = getUserById(id1);
        User user2 = getUserById(id2);

        if (user1 == null || user2 == null) {
            System.out.println("User not found.");
            return;
        }

        Set<Integer> set1 = new HashSet<>(user1.friendIds);
        Set<Integer> set2 = new HashSet<>(user2.friendIds);

        set1.retainAll(set2); // Intersection

        System.out.println("Mutual Friends:");
        if (set1.isEmpty()) {
            System.out.println("No mutual friends.");
        } else {
            for (int id : set1) {
                User mutual = getUserById(id);
                if (mutual != null)
                    System.out.println("- " + mutual.name + " (ID: " + mutual.userId + ")");
            }
        }
    }

    // Count number of friends for each user
    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friend(s).");
            temp = temp.next;
        }
    }

    // Helper: get user by ID
    private User getUserById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Helper: print user
    private void printUser(User user) {
        System.out.println("ID: " + user.userId + ", Name: " + user.name + ", Age: " + user.age);
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialMedia sm = new SocialMedia();

        while (true) {
            System.out.println("\n--- Social Media Menu ---");
            System.out.println("1. Add User");
            System.out.println("2. Search User");
            System.out.println("3. Add Friend Connection");
            System.out.println("4. Remove Friend Connection");
            System.out.println("5. Display Friends of User");
            System.out.println("6. Find Mutual Friends");
            System.out.println("7. Count Friends for Each User");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt(); sc.nextLine();

            int id1, id2, age;
            String name;

            switch (ch) {
                case 1:
                    System.out.print("Enter User ID: ");
                    id1 = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    age = sc.nextInt();
                    sm.addUser(id1, name, age);
                    break;

                case 2:
                    System.out.print("Enter ID (-1 to skip): ");
                    id1 = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name (blank to skip): ");
                    name = sc.nextLine();
                    sm.searchUser(id1, name.isEmpty() ? null : name);
                    break;

                case 3:
                    System.out.print("Enter Your ID: ");
                    id1 = sc.nextInt();
                    System.out.print("Enter Friend ID: ");
                    id2 = sc.nextInt();
                    sm.addFriend(id1, id2);
                    break;

                case 4:
                    System.out.print("Enter Your ID: ");
                    id1 = sc.nextInt();
                    System.out.print("Enter Friend ID to Remove: ");
                    id2 = sc.nextInt();
                    sm.removeFriend(id1, id2);
                    break;

                case 5:
                    System.out.print("Enter User ID: ");
                    id1 = sc.nextInt();
                    sm.displayFriends(id1);
                    break;

                case 6:
                    System.out.print("Enter First User ID: ");
                    id1 = sc.nextInt();
                    System.out.print("Enter Second User ID: ");
                    id2 = sc.nextInt();
                    sm.mutualFriends(id1, id2);
                    break;

                case 7:
                    sm.countFriends();
                    break;

                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
