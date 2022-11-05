public class Book_info {
    private String name_book;
    private String author_book;

    public Book_info(String name_book, String author_book) {
        this.name_book = name_book;
        this.author_book = author_book;
    }

    public Book_info() {
    }

    public String getName_book() {
        return name_book;
    }

    public void setName_book(String name_book) {
        this.name_book = name_book;
    }

    public String getAuthor_book() {
        return author_book;
    }

    public void setAuthor_book(String author_book) {
        this.author_book = author_book;
    }

    public String getInfo() {
        return "" +
                "Название книги '" + name_book + '\'' +
                ", Автор '" + author_book + '\'' +
                ' ';
    }
}