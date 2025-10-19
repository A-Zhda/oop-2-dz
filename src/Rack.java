public class Rack {
    private Shelf[] shelves;

    public Rack(Shelf[] shelves) {
        this.shelves = shelves;
    }

    public Shelf[] getShelves() {
        return shelves;
    }

    public Shelf getShelf(int index) {
        if (index < 0 || index >= shelves.length) {
            return null;
        }

        return shelves[index];
    }

    public int totalBooks() {
        int total = 0;

        for (Shelf shelf : shelves) {
            total += shelf.getBooksLength();
        }

        return total;
    }

    public int findFirstByTitle(String title) {
        for (int i = 0; i < shelves.length; i++) {
            var shelf = shelves[i];

            if (shelf.indexOfByTitle(title) != -1) return i;
        }

        return -1;
    }
}
