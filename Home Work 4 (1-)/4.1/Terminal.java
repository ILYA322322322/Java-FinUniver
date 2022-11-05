package My.cards;

import java.util.Scanner;

public class Terminal {
    int cards = 0;
    int freePasses = 0;
    double money = 0;
    int passes = 0;
    double studentMonthPay;
    double studentPrice;
    int studentNumber;
    int socialNumber;

    public Terminal() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите месячную оплату студенческого билета");
        this.studentMonthPay = scanner.nextDouble();
        System.out.println("Введите 1 способ оплаты студенческого билета");
        this.studentPrice = scanner.nextDouble();

        System.out.println("Введите количество поездок для студенческого билета");
        this.studentNumber = scanner.nextInt();

        this.socialNumber = -1; //для соц карты сделаем безлимитные поездки
    }

    public Card createNewCard() {
        Card card = null;
        boolean isCorrect = false;
        while (!isCorrect) {
            System.out.println("Введите тип вашей карты:");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            switch (s) {
                case "Студент":
                    card = new Student(studentMonthPay, studentPrice, studentNumber);
                    isCorrect = true;
                    break;
                default:
                    System.out.println("Непонятный тип");
            }
        }
        return card;
    }

    public void pass(Card card) {
        card.checkMonth();
        this.cards++;
        this.passes++;
        if (!card.isBlocked()) {
            if (card.getRemainedWays() != 0) {
                card.setRemainedWays(card.getRemainedWays() - 1);
                this.freePasses++;
                System.out.println("Ну проходи, ну давай я пройду,http://www.youtube.com/watch?v=ukhSQ-k9Udc.");
            } else {
                if (card.getSum() >= card.getPriceOfOneWay()) {
                    card.setSum(card.getSum() - card.getPriceOfOneWay());
                    this.money += card.getPriceOfOneWay();
                    System.out.println("Все окей, контролеры не штрафанут.");
                } else {
                    this.passes--;
                    System.out.println("Ты не скрудж макдак((((");
                }
            }
        } else {
            this.passes--;
            System.out.println("До зп еще 13 дней, а ты уже все потратил -_-.");
        }
    }

    public String getStatistics() {
        return String.format("Number of cards: %d;%sNumber of free passes: %d;%sNumber of taken money: %f;%sNumber of all passes: %d.",
                this.cards, System.lineSeparator(), this.freePasses, System.lineSeparator(), this.money, System.lineSeparator(), this.passes);
    }
}