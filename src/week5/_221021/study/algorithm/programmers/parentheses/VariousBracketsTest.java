package week5._221021.study.algorithm.programmers.parentheses;

public class VariousBracketsTest {
    public static void main(String[] args) {
        VariousBrackets variousBrackets = new VariousBrackets();

        String case1 = "{}()[](({))"; // false
        String case2 = "{}()[](({}))"; // true

        System.out.println(variousBrackets.solution1(case1));
        System.out.println(variousBrackets.solution1(case2));
    }
}
