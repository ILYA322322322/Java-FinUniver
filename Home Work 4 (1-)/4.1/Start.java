package My.cards;
public class Start {
    public static void main(String[] args) {
        Terminal terminal = new Terminal();
        Card mycard = terminal.createNewCard();
        Reload atm = new Reload();
        atm.fillCard(mycard, 1000000);
        for (int i = 0; i < 10; i++) {
            terminal.pass(mycard);
        }
        System.out.println("________________");
        System.out.println(terminal.getStatistics());
        System.out.println();
    }
}