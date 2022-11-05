public class Reader {
    private String SNP;//ФИО_пользователя
    private int id_number;// номер_читательского_билета
    private String department;// факультет
    private String DoB;// дата_рождения
    private String phone_number;// номер_телефон

    public Reader(String name, int id_number, String department, String DoB, String phone_number) {//создаем массив инф
        this.SNP = name;
        this.id_number = id_number;
        this.department = department;
        this.DoB = DoB;
        this.phone_number = phone_number;
    }

    public Reader() {
    }

    public String getName() {
        return SNP;
    }

    public void setName(String name) {
        this.SNP = name;
    }

    public int getId_number() {
        return id_number;
    }

    public void setId_number(int id_number) {
        this.id_number = id_number;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(String doB) {
        this.DoB = doB;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void takeBook(int number) {
        System.out.println(this.SNP + " взял/-ла " + number + " книги.");//выводит кол-во взятых книг
    }

    public void takeBook(String... books) {//кто и какие книги взял
        System.out.println(this.SNP + " взял/-ла следующие книги:");
        for (String book : books) {
            System.out.println(book);
        }
        System.out.println();
    }

    public void takeBook(Book_info... bookInfos) {//кто какие книги и с каким автором
        System.out.println(this.SNP + " взял/-ла следующие книги:");
        for (Book_info bookInfo : bookInfos) {
            System.out.println(bookInfo.getName_book() + ", автор - " + bookInfo.getAuthor_book());
        }
        System.out.println();
    }

    public void returnBook(int number) {//какое кол-во книг вернул читатель
        System.out.println(this.SNP + " вернул/-ла " + number + " книги.");
    }

    public void returnBook(String... books) {//кто и какие книги вернул по названию
        System.out.println(this.SNP + " вернул/-ла следующие книги:");
        for (String book : books) {
            System.out.println(book);
        }
        System.out.println();
    }

    public void returnBook(Book_info... bookInfos) {//кто, какие книги и с каким автором вернул
        System.out.println(this.SNP + " вернул/-ла следующие книги:");
        for (Book_info bookInfo : bookInfos) {
            System.out.println(bookInfo.getName_book() + ", автор - " + bookInfo.getAuthor_book());
        }
        System.out.println();
    }

    public String getInfo() {
        return "" +
                "ФИО '" + SNP + '\'' +
                ", Номер читательского билета " + id_number +
                ", Факультет '" + department + '\'' +
                ", Дата рождения '" + DoB + '\'' +
                ", Телефон '" + phone_number + '\'' +
                ' ';
    }
}