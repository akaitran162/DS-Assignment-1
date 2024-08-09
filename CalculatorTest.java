import org.junit.Test;
import org.junit.Assert;

public class CalculatorTest {
    @Test
    public void testPush() throws Exception {
        CalculatorClient client = new CalculatorClient();
        try {
            System.out.println("Test push value");
            client.pushValue(5);
            client.popValue();
            System.out.println("End test push value");
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    @Test
    public void testPop() throws Exception {
        CalculatorClient client = new CalculatorClient();
        try {
            System.out.println("Test pop value");
            client.pushValue(10);
            int popValue = client.popValue();
            Assert.assertEquals(10, popValue);
            System.out.println("End test pop value");
        }
        catch (Exception e) {
            throw e;
        }
    }
    @Test
    public void testDelayPop() throws Exception {
        CalculatorClient client = new CalculatorClient();
        try {
            System.out.println("Test DelayPop value");
            client.pushValue(100);
            int popValue = client.delayPopValue(500);
            Assert.assertEquals(100, popValue);
            System.out.println("End test DelayPop value");
        }
        catch (Exception e) {
            throw e;
        }
    }
    @Test
    public void testIsEmpty() throws Exception {
        CalculatorClient client = new CalculatorClient();
        try {
            System.out.println("Test Is Empty");
            client.pushValue(100);
            boolean empty = false;
            while (!empty) {
                int popValue = client.popValue();
                empty = client.isEmpty();
            }
            Thread.sleep(600);
            Assert.assertEquals(true, empty);
            System.out.println("End test Is Empty");
        }
        catch (Exception e) {
            throw e;
        }
    }
    @Test
    public void testMin() throws Exception {
        CalculatorClient client = new CalculatorClient();
        try {
            System.out.println("Test Min");
            client.pushValue(100);
            client.pushValue(300);
            client.pushValue(500);
            client.pushOperation("min");
            int popValue = client.popValue();
            Assert.assertEquals(100, popValue);
            System.out.println("End Test Min");
        }
        catch (Exception e) {
            throw e;
        }
    }
    @Test
    public void testMax() throws Exception {
        CalculatorClient client = new CalculatorClient();
        try {
            System.out.println("Test Max");
            client.pushValue(100);
            client.pushValue(300);
            client.pushValue(500);
            client.pushOperation("max");
            int popValue = client.popValue();
            Assert.assertEquals(500, popValue);
            System.out.println("End Test Max");
        }
        catch (Exception e) {
            throw e;
        }
    }
    @Test
    public void testLcm() throws Exception {
        CalculatorClient client = new CalculatorClient();
        try {
            System.out.println("Test LCM");
            client.pushValue(2);
            client.pushValue(6);
            client.pushValue(4);
            client.pushOperation("lcm");
            int popValue = client.popValue();
            Assert.assertEquals(12, popValue);
            System.out.println("End Test LCM");
        }
        catch (Exception e) {
            throw e;
        }
    }
    @Test
    public void testGcd() throws Exception {
        CalculatorClient client = new CalculatorClient();
        try {
            System.out.println("Test GCD");
            client.pushValue(12);
            client.pushValue(18);
            client.pushValue(24);
            client.pushOperation("gcd");
            int popValue = client.popValue();
            Assert.assertEquals(6, popValue);
            System.out.println("End Test GCD");
        }
        catch (Exception e) {
            throw e;
        }
    }
    @Test
    public void testMultipleClientPush() throws Exception {
        CalculatorClient client1 = new CalculatorClient();
        CalculatorClient client2 = new CalculatorClient();
        CalculatorClient client3 = new CalculatorClient();
        try {
            System.out.println("Test Multiple Client Push");
            client1.pushValue(2);
            client2.pushValue(6);
            client3.pushValue(4);
            int popValue = client1.popValue();
            Assert.assertEquals(4, popValue);
            client1.popValue();
            client1.popValue();
            System.out.println("End Test Multiple Client Push");
        }
        catch (Exception e) {
            throw e;
        }
    }
    @Test
    public void testMultipleClientPop() throws Exception {
        CalculatorClient client1 = new CalculatorClient();
        CalculatorClient client2 = new CalculatorClient();
        CalculatorClient client3 = new CalculatorClient();
        try {
            System.out.println("Test Multiple Client Pop");
            client1.pushValue(2);
            client1.pushValue(6);
            client1.pushValue(4);
            int popValue = client2.popValue();
            Assert.assertEquals(4, popValue);
            popValue = client3.popValue();
            Assert.assertEquals(6, popValue);
            client3.popValue();
            System.out.println("End Test Multiple Client Pop");
        }
        catch (Exception e) {
            throw e;
        }
    }
    @Test
    public void testMultipleClientDelayPop() throws Exception {
        CalculatorClient client1 = new CalculatorClient();
        CalculatorClient client2 = new CalculatorClient();
        CalculatorClient client3 = new CalculatorClient();
        try {
            System.out.println("Test Multiple Client Delay Pop");
            client1.pushValue(2);
            client2.pushValue(6);
            client3.pushValue(4);
            int popValue = client2.delayPopValue(500);
            Assert.assertEquals(4, popValue);
            popValue = client2.delayPopValue(500);
            Assert.assertEquals(6, popValue);
            client3.popValue();
            System.out.println("End Test Multiple Client Delay Pop");
        }
        catch (Exception e) {
            throw e;
        }
    }
    @Test
    public void testMultipleClientPushOperationMin() throws Exception {
        CalculatorClient client1 = new CalculatorClient();
        CalculatorClient client2 = new CalculatorClient();
        CalculatorClient client3 = new CalculatorClient();
        try {
            System.out.println("Test Multiple Client Push Operation Min");
            client1.pushValue(2);
            client2.pushValue(6);
            client3.pushValue(4);
            client1.pushOperation("min");
            int popValue = client2.popValue();
            Assert.assertEquals(2, popValue);
            System.out.println("End Test Multiple Client Push Operation Min");

        }
        catch (Exception e) {
            throw e;
        }
    }
    @Test
    public void testMultipleClientPushOperationMax() throws Exception {
        CalculatorClient client1 = new CalculatorClient();
        CalculatorClient client2 = new CalculatorClient();
        CalculatorClient client3 = new CalculatorClient();
        try {
            System.out.println("Test Multiple Client Push Operation Max");
            client1.pushValue(2);
            client2.pushValue(6);
            client3.pushValue(4);
            client1.pushOperation("max");
            int popValue = client2.popValue();
            Assert.assertEquals(6, popValue);
            System.out.println("End Test Multiple Client Push Operation Max");
        }
        catch (Exception e) {
            throw e;
        }
    }
    @Test
    public void testMultipleClientPushOperationLcm() throws Exception {
        CalculatorClient client1 = new CalculatorClient();
        CalculatorClient client2 = new CalculatorClient();
        CalculatorClient client3 = new CalculatorClient();
        try {
            System.out.println("Test Multiple Client Push Operation LCM");
            client1.pushValue(2);
            client2.pushValue(6);
            client3.pushValue(4);
            client1.pushOperation("lcm");
            int popValue = client2.popValue();
            Assert.assertEquals(12, popValue);
            System.out.println("End Test Multiple Client Push Operation LCM");
        }
        catch (Exception e) {
            throw e;
        }
    }
    @Test
    public void testMultipleClientPushOperationGcd() throws Exception {
        CalculatorClient client1 = new CalculatorClient();
        CalculatorClient client2 = new CalculatorClient();
        CalculatorClient client3 = new CalculatorClient();
        try {
            System.out.println("Test Multiple Client Push Operation GCD");
            client1.pushValue(2);
            client2.pushValue(6);
            client3.pushValue(4);
            client1.pushOperation("gcd");
            int popValue = client2.popValue();
            Assert.assertEquals(2, popValue);
            System.out.println("End Test Multiple Client Push Operation GCD");
        }
        catch (Exception e) {
            throw e;
        }
    }
}
