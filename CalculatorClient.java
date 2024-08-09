import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalculatorClient {
    private CalculatorClient() {}

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry();
            Calculator stub = (Calculator) registry.lookup("Calculator");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            scanner.close();
            String response = get_response(input, stub);
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
        }
    }
    public static String get_response(String input, Calculator stub) {
        try {
            switch (input) {
                case "pop":
                    return String.valueOf(stub.pop());

                case "pushvalue":
                    Scanner scanner = new Scanner(System.in);
                    Integer value = Integer.parseInt(scanner.nextLine());
                    scanner.close();    
                    stub.pushValue(value);
                    return "Value pushed!";

                case "pushoperation":
                    Scanner scanner = new Scanner(System.in);
                    String value = scanner.nextLine();
                    scanner.close();
                    stub.pushOperation(input);
                    return 

                case "delaypop":

                case "isempty":
                    Scanner scanner = new Scanner(System.in);
                    Integer value = Integer.parseInt(scanner.nextLine());
                    scanner.close();    
                    stub.isEmpty();
                    return "";


                default:
                return "Wrong input! Please try again.";
            }
        }
        catch (Exception e) {
            System.err.println(e.toString());
            return "Error detected!";
        }
    }
}