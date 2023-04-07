import java.util.Scanner;

public class App {
    public static Node head = null; // dugumlerim yok bos her iki tarafta
    public static Node tail = null;

    public class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = head;
        }
    }

    public static void findPositionsOfBallons(int data, int index) {
        App app = new App();
        Node head = app.new Node(1);
        Node temp = head;
        int i;
        for (i = 2; i <= data; i++) {
            temp.next = app.new Node(i);
            temp = temp.next;
        }
        temp.next = head;
        while (temp.next != temp) {
            int j;
            for (j = 0; j < index - 1; j++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        System.out.println("Balloon that dont pop " + temp.data);
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of balloons: ");
        int numberOfBallons = input.nextInt();
        System.out.print("Enter the index of ballons: ");
        int indexOfBallons = input.nextInt();

        if (numberOfBallons <= indexOfBallons) {
            System.out.println("You can't do that! Please enter inputs again!");
        }
        findPositionsOfBallons(numberOfBallons, indexOfBallons);
        input.close();
    }
}
