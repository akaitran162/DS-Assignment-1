import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Stack;

public class CalculatorImplementation extends UnicastRemoteObject implements Calculator{
    private Stack<Integer> serverStack;

    protected CalculatorImplementation() throws RemoteException {
        serverStack = new Stack<>();
    }
    @Override
    public void pushValue(int val) throws RemoteException {
        serverStack.push(val);
        System.out.println("Pushed value: " + serverStack.peek());
    }
    @Override
    public void pushOperation(String operator) throws RemoteException {
        if (serverStack.isEmpty()) {
            throw new IllegalStateException("The stack is empty!");
        }
        int result;
        switch (operator) {
            case "min":
                result = serverStack.stream().min(Integer::compare).get();
                break;
            case "max":
                result = serverStack.stream().max(Integer::compare).get();
                break;
            case "lcm":
                result = lcm(serverStack);
                break;
            case "gcd":
                result = gcd(serverStack);
                break;
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
        serverStack.clear();
        serverStack.push(result);
    }
    @Override
    public int pop() throws RemoteException {
        if (serverStack.isEmpty()) {
            throw new IllegalStateException("The stack is empty!");
        }
        return serverStack.pop();
    }
    @Override
    public boolean isEmpty() throws RemoteException {
        return serverStack.isEmpty();
    }
    @Override
    public int delayPop(int millis) throws RemoteException {
        try {
            Thread.sleep((long)millis);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverStack.pop();
    }
    private int lcm(Stack<Integer> serverStack) {
        return serverStack.stream().reduce(1, (a,b) -> a * (b/ gcd(a,b)));
    }
    private int gcd(Stack<Integer> serverStack) {
        return serverStack.stream().reduce(this::gcd).get();
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
