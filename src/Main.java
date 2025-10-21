public class Main {
    public static void main(String[] args) {
        Book[] books = {
                new Book("Война и мир", "Толстой", 4000),
                new Book("Капитанская дочка", "Пушкин", 150),
        };

        Shelf[] shelfs = {
                new Shelf(books)
        };

        Rack[] racks = {
                new Rack(shelfs)
        };

        Library library = new Library(racks);

        System.out.println(library.totalBooks());
        System.out.println(library.findByTitle("Капитанская дочка"));
    }
}
