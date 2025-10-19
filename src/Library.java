public class Library {
    private Rack[] racks;

    public Library(Rack[] racks) {
        this.racks = racks;
    }

    public int racksCount() {
        return racks.length;
    }

    public Rack getRack(int index) {
        if (index < 0 || index >= racks.length) {
            return null;
        }

        return racks[index];
    }

    public int totalBooks() {
        int totalBooks = 0;
        for (var rack : racks) totalBooks += rack.totalBooks();

        return totalBooks;
    }

    public Book findByTitle(String title) {
        for (var rack : racks) {
            for (var shelf : rack.getShelves()) {
                Book book = shelf.findBookByTitle(title);

                if (book != null) return book;
            }
        }

        return null;
    }
}
