import java.util.Arrays;

public class Shelf {
    private Book[] books;

    public Shelf(Book[] books) {
        this.books = books;
    }

    public int indexOfByTitle(String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getTitle().equals(title))
                return i;
        }

        return -1;
    }

    public Book findBookByTitle(String title) {
        for (var book : books) {
            if (book.getTitle().equals(title)) return book;
        }

        return null;
    }


    public int getBooksLength() {
        return books.length;
    }

    public Book get(int index) {
        if (index < 0 || index >= books.length) {
            return null;
        }

        return books[index];
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "books=" + Arrays.toString(books) +
                '}';
    }
}
