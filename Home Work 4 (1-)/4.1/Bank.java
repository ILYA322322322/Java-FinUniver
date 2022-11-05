package My.cards;
public abstract class Bank {
    public void fillCard(Card card, double money) {
        card.setSum(card.getSum() + money);
        if (card.isBlocked() && card.getSum() >= 0) {
            card.setBlocked(false);
        }
        System.out.println("На мое аккаунте " + card.getSum() + " я прибавил пару нулей на своем аккаунте.");
    }
}