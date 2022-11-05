package My.cards;

import java.time.LocalDateTime;

public abstract class Card {
    private static int num = 0;
    private int number;
    int month = LocalDateTime.now().getMonth().getValue();
    private boolean isBlocked = false;
    private int numberOfWays;
    private int remainedWays;
    private double sum;
    private double priceOfOneWay;
    private double monthPay;

    public Card(double monthPay, double priceOfOneWay, int numberOfWays) {
        this.setNumber();
        this.setMonthPay(monthPay);
        this.setSum(0);
        this.setPriceOfOneWay(priceOfOneWay);
        this.setNumberOfWays(numberOfWays);
        this.setRemainedWays(numberOfWays);
    }

    public void setNumber() {
        this.number = Card.num;
        num++;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }

    public int getNumberOfWays() {
        return numberOfWays;
    }

    public void setNumberOfWays(int numberOfWays) {
        this.numberOfWays = numberOfWays;
    }

    public int getRemainedWays() {
        return remainedWays;
    }

    public void setRemainedWays(int remainedWays) {
        this.remainedWays = remainedWays;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public double getPriceOfOneWay() {
        return priceOfOneWay;
    }

    public void setPriceOfOneWay(double priceOfOneWay) {
        this.priceOfOneWay = priceOfOneWay;
    }

    public double getMonthPay() {
        return monthPay;
    }

    public void setMonthPay(double monthPay) {
        this.monthPay = monthPay;
    }

    public void checkMonth() {
        if (!isBlocked) {
            if (LocalDateTime.now().getMonth().getValue() != this.getMonth()) {
                this.setMonth(LocalDateTime.now().getMonth().getValue());
                this.setSum(this.getSum() - this.getMonthPay());
                this.setRemainedWays(this.getNumberOfWays());
                if (this.getSum() < 0) {
                    this.setBlocked(true);
                }
            }
        }
    }
}