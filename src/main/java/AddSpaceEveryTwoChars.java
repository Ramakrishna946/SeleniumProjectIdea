public class AddSpaceEveryTwoChars {
    public static void main(String[] args) {
        String input = "Ramakrishna chintha";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            result.append(input.charAt(i));

            // Add space after every 2 characters, but avoid extra space at the end
            if ((i + 1) % 2 == 0 && i != input.length() - 1) {
                result.append(" ");
            }
        }

        System.out.println("Original: " + input);
        System.out.println("Modified: " + result.toString());
    }
}
