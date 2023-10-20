package netcracker;

public class StringManipulation {

    public static void main(String[] args) {
        String paragraph = "Ram is employee of ABC company, RAM is from Pune, RAM! is good in java.";
        String[] words = paragraph.replaceAll("\\W+", " ").split("\\s+");
        String result = paragraph.replaceAll("\\W+", " ");
        for (String str : words) {
            //System.out.print(str + " ");
        }

        Integer i = 100;
        Integer j = 100;
        System.out.println(i == j);

    }
}
