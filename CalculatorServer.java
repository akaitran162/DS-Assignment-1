import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public static void main(String[] args) {
        CalculatorServer server = new CalculatorServer();
        server.run();
    }

    public void run() {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);

            Calculator calculatorSkeleton = new CalculatorImplementation();

            registry.rebind("Calculator", calculatorSkeleton);

            while(true) {
                System.out.println("Server is running...");
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            System.out.println("Calculator Server failed: " + e);
        }

    }
}
