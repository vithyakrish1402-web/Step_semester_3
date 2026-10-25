package arrays_and_complexity.class_problems;

import java.util.ArrayList;
import java.util.List;

public class LibraryCatalogLookup {

    public static class Book {
        private String isbn;
        private String title;

        public Book(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }

        public String getIsbn() {
            return isbn;
        }

        public String getTitle() {
            return title;
        }
    }

    public static String findBook(List<Book> catalog, String targetIsbn) {
        if (catalog == null || targetIsbn == null) {
            return "Not Found";
        }
        int low = 0;
        int high = catalog.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            Book midBook = catalog.get(mid);
            int cmp = midBook.getIsbn().compareTo(targetIsbn);
            if (cmp == 0) {
                return midBook.getTitle();
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return "Not Found";
    }

    public static String findBook(String[][] catalog, String targetIsbn) {
        if (catalog == null || targetIsbn == null) {
            return "Not Found";
        }
        int low = 0;
        int high = catalog.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = catalog[mid][0].compareTo(targetIsbn);
            if (cmp == 0) {
                return catalog[mid][1];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        List<Book> catalog = new ArrayList<>();
        catalog.add(new Book("0001112223", "Introduction to Algebra"));
        catalog.add(new Book("0002223334", "Beginning Python"));
        catalog.add(new Book("0003334445", "Classic Mythology"));
        catalog.add(new Book("0004445556", "Data and Society"));
        catalog.add(new Book("0005556667", "European History"));

        System.out.println(findBook(catalog, "0003334445"));
        System.out.println(findBook(catalog, "0009998887"));

        String[][] rawCatalog = {
            {"0001112223", "Introduction to Algebra"},
            {"0002223334", "Beginning Python"},
            {"0003334445", "Classic Mythology"},
            {"0004445556", "Data and Society"},
            {"0005556667", "European History"}
        };
        System.out.println(findBook(rawCatalog, "0003334445"));
        System.out.println(findBook(rawCatalog, "0009998887"));
    }
}
