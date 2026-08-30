package string_methods.assigment_problems;

public class LibraryIsbnValidator {

    public static String normalizeCode(String raw) {
        if (raw == null) {
            return null;
        }

        String trimmed = raw.trim();
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }

        return trimmed.substring(0, 3).toUpperCase() + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        if (code == null || code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must be 10 digits";
            }
        }

        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ");
        sb.append(year).append(" | CATALOG: ");
        sb.append(catalog);

        return sb.toString();
    }

    public static void main(String[] args) {
        String test1 = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(test1));

        String test2 = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(test2));

        String test3 = normalizeCode("abc202399999");
        System.out.println(validateAndFormat(test3));
    }
}
