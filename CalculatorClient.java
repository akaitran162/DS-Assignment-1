import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class CalculatorClient {
    Calculator stub;
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

    public CalculatorClient() throws Exception {
        Registry registry = LocateRegistry.getRegistry();
        stub = (Calculator) registry.lookup("Calculator");
    }

    public void pushValue(String value) {
        try {
            Registry registry = LocateRegistry.getRegistry();
            Calculator stub = (Calculator) registry.lookup("Calculator");
            String response = get_response(value, stub);
            System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
        }
    }
    public static String get_response(String input, Calculator stub) {
        try {

            Scanner scanner;
            switch (input) {
                case "pop":
                    return String.valueOf(stub.pop());

                case "pushvalue":
                    scanner = new Scanner(System.in);
                    Integer value = Integer.parseInt(scanner.nextLine());
                    scanner.close();
                    stub.pushValue(value);
                    return "Value pushed!";

                case "pushoperation":
                    scanner = new Scanner(System.in);
                    System.out.println("Enter an operation: min, max, lcm, gcd");
                    String operation = scanner.nextLine();
                    scanner.close();
                    stub.pushOperation(operation);
                    return "Operation pushed and processed!";

                case "delaypop":
                    scanner = new Scanner(System.in);
                    System.out.println("Enter the delay in milliseconds: ");
                    int delay = Integer.parseInt(scanner.nextLine());
                    scanner.close();
                    int delayedValue = stub.delayPop(delay);
                    return "Delayed pop returned: " + delayedValue;

                case "isempty":
                    return stub.isEmpty() ? "Stack is empty." : "Stack is not empty.";
                default:
                return "Wrong input! Please try again.";
            }
        }
        catch (Exception e) {
            System.err.println(e.toString());
            return "Error detected!";
        }
    }
    public void pushValue (int input) {
        try {
            stub.pushValue(input);
        }
        catch (Exception e) {
            System.err.println(e.toString());
        }
    }
    public int popValue () throws RemoteException {
        try {
            return stub.pop();
        }
        catch (Exception e) {
            System.err.println(e.toString());
            throw e;
        }
    }
    public int delayPopValue(int millis) throws RemoteException {
        try {
            return stub.delayPop(millis);
        }
        catch (Exception e) {
            System.err.println(e.toString());
            throw e;
        }
    }
    public boolean isEmpty() throws RemoteException {
        try {
            return stub.isEmpty();
        }
        catch (Exception e) {
            System.err.println(e.toString());
            throw e;
        }
    }
    public void pushOperation(String operation) throws RemoteException {
        try {
            stub.pushOperation(operation);
        }
        catch (Exception e) {
            System.err.println(e.toString());
            throw e;
        }
    }

}