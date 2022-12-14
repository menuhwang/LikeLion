package week3._221005.study.calculator;

public class RandomCalculator extends Calculator{

    public RandomCalculator(int num, NumberCreator randomNumberCreator) {
        super(num, randomNumberCreator.numberCreate());
    }

    public int getRandomNumber() {
        return b;
    }

    @Override
    public double divide() {
        if (b == 0) throw new ArithmeticException("랜덤하게 생성된 숫자가 0입니다.");
        return super.divide();
    }
}
