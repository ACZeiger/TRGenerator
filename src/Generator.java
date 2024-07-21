import java.util.*;
public class Generator {
    static Database db = new Database();
    public static void main(String[] args) {
        menu();
    }
    public static void genTRs(int num) {
        HashSet<TR> trs = new HashSet<>();
        while (trs.size() < num) {
            TR tr = db.getTR();
            trs.add(tr);
        }
        System.out.println("#  Move            Type\n---------------------------");
        for (TR t : trs) {
            if (t.getIndex() < 10) {
                System.out.println("0" + t.getIndex() + t.getName() + t.getType());
            }
            else {
                System.out.println(t.getIndex() + t.getName() + t.getType());
            }
        }
    }
    public static void genByType(int num, String type) {
        HashSet<TR> trs = new HashSet<>();
        HashSet<TR> list = compileByType(type);
        if (num > list.size()) {
            while (trs.size() < list.size()) {
                TR tr = db.getByType(type);
                trs.add(tr);
            }
        }
        else {
            while (trs.size() < num) {
                TR tr = db.getByType(type);
                trs.add(tr);
            }
        }
        System.out.println("#  Move            Type\n---------------------------");
        for (TR t : trs) {
            if (t.getIndex() < 10) {
                System.out.println("0" + t.getIndex() + t.getName() + t.getType());
            }
            else {
                System.out.println(t.getIndex() + t.getName() + t.getType());
            }
        }
    }
    public static HashSet<TR> compileByType(String type) {
        HashSet<TR> list = new HashSet<>();
        for (int i = 0; i <= 99; i++) {
            list.add(db.getByType(type));
        }
        return list;
    }
    public static void listByType(String type) {
        HashSet<TR> trs = compileByType(type);
        System.out.println("#  Move            Type\n---------------------------");
        for (TR t : trs) {
            if (t.getIndex() < 10) {
                System.out.println("0" + t.getIndex() + t.getName() + t.getType());
            }
            else {
                System.out.println(t.getIndex() + t.getName() + t.getType());
            }
        }
    }
    public static void menu() {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Item Generator:\n1. Generate TRs\n2. Generate TRs by Type\n3. List TRs by Type\n0. Quit");
            int option = Integer.parseInt(input.nextLine());
            if (option == 0) {
                System.out.println("Goodbye!");
                input.nextLine();
                break;
            }
            else if (option == 1) {
                System.out.println("Enter number of TRs:");
                option = Integer.parseInt(input.nextLine());
                genTRs(option);
                input.nextLine();
            }
            else if (option == 2) {
                System.out.println("Enter number of TRs:");
                option = Integer.parseInt(input.nextLine());
                System.out.println("Enter TR type:");
                String choice = input.nextLine();
                genByType(option, choice);
                input.nextLine();
            }
            else if (option == 3) {
                System.out.println("Enter TR type:");
                String choice = input.nextLine();
                listByType(choice);
                input.nextLine();
            }
            else {
                System.out.println("Invalid entry. Try againj.");
                input.nextLine();
            }
        }
    }
}