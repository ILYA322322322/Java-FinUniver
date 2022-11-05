public class Reader_in_out {
    public static void main(String[] args) {
        Reader reader_7 = new Reader("Сафронов И.М", 8, "Прикладная Информатика", "21.10.2000", "+79167787231");
        Reader reader_17 = new Reader("Джуливерн Д.Д", 15, "Юридический", "21.10.2000", "+88005555555");
        Reader reader_15 = new Reader("Васечкин В. В.", 12, "Менеджмент", "02.03.2003", "+775767857548");
        Reader[] readers = {reader_7, reader_17, reader_15};

        Book_info book_info_1 = new Book_info("Угрюм река", "Шишков, Вячеслав Яковлевич");
        Book_info book_info_2 = new Book_info("Война и мир", "Лев Николаевич Толстой");
        Book_info book_info_3 = new Book_info("Приключения барона Мюнхгаузена", "Рудольф Эрих Распе");
        Book_info[] bookInfos = {book_info_1, book_info_2, book_info_3};

        printReaders(readers);
        printBooks(bookInfos);

        reader_7.takeBook(3);
        System.out.println();
        reader_17.takeBook("Повелитель мух");
        reader_15.takeBook(book_info_1, book_info_2, book_info_3);

    }

    private static void printBooks(Book_info[] bookInfos) {
        System.out.println("List_of_Books:");
        for (Book_info bookInfo : bookInfos) {
            System.out.println(bookInfo.getInfo());
        }
        System.out.println();
    }

    private static void printReaders(Reader[] readers) {
        System.out.println("List_of_Readers");
        for (Reader reader : readers) {
            System.out.println( reader.getInfo());
        }
        System.out.println();
    }
}