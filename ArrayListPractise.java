import java.util.ArrayList;
import java.util.List;

public class ArrayListPractise {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println(list.get(2));

        for(int x : list){
            System.err.println(x);
        }

    }
}