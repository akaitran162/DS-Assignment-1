Open Terminal
Change directory to the Assignment folder. For example: cd Assignment1
Compile all classes using the following command
javac -cp "./lib/*" *.java

Open another Terminal
Change directory to the Assignment folder. For example: cd Assignment1
Start Server with the following command:
java -cp . CalculatorServer

Open another Terminal
Change directory to the Assignment folder. For example: cd Assignment1
Run the JUnit Test with following command:
java -cp "./:./lib/*" org.junit.runner.JUnitCore CalculatorTest