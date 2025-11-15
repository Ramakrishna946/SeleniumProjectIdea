public class CapitalizeWords {

    public static void main(String[] args) {
        String input="nothing is impossible";
        String[] words=input.split(" ");
        StringBuilder sb= new StringBuilder();
        for(String word : words) {
            if(!word.isEmpty()) {
                sb.append(Character.toUpperCase(word.charAt(0))).
                        append(word.substring(1)).append(" ");

            }
        }
        String result= sb.toString().trim();
        System.out.println("The result of the function:"+result);
        System.out.println("The result of the function:"+result);
        System.out.println("The result of the function:"+result);
        System.out.println("The result of the function:"+result);
        System.out.println("The result of the function:"+result);
        System.out.println("The result of the function:"+result);
        System.out.println("The result of the function:"+result);
    }

}
