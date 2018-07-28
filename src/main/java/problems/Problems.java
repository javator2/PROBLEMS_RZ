package problems;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import javafx.beans.property.IntegerProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Problems {

    public static String last(List<String> strings) {
        Preconditions.checkNotNull(strings);
        Preconditions.checkArgument(strings.size() >= 1);
        return strings.get(strings.size() - 1);
    }

    public static Integer secondLast(List<Integer> numbers) {
        Preconditions.checkNotNull(numbers);
        Preconditions.checkArgument(numbers.size() >= 2);
        return numbers.get(numbers.size() - 2);
    }

    public static int length(List<Object> objects) {
        Preconditions.checkNotNull(objects);
        return objects.size();
    }

    public static List<Integer> reverse(List<Integer> numbers) {
        Preconditions.checkNotNull(numbers);
        return Lists.reverse(numbers);
    }

    public static List<String> duplicate(List<String> strings) {
        Preconditions.checkNotNull(strings);
        List<String> listToDuplicate = new ArrayList<>(strings);
        for(int i = 0; i < listToDuplicate.size(); i += 2) {
            listToDuplicate.add(i + 1, listToDuplicate.get(i));
        }
        return listToDuplicate;
    }

    public static List<String> randomSelect(List<String> strings, int max) {
        Preconditions.checkNotNull(strings);
        Preconditions.checkArgument(max >= 1);
        Preconditions.checkState(strings.size() > 0);
        List<String> randList = new ArrayList<>();
        Random rand = new Random();
        for(int i = 0, randNum; i < max; i ++) {
            randNum = rand.nextInt(strings.size());
            randList.add(strings.get(randNum));
        }
        return randList;
    }

    public static List<Integer> primeNumbers(IntStream intStream) {
        return new ArrayList<>(intStream.filter(val -> (isPrimeNum(val))).boxed().collect(Collectors.toList()));
    }

    private static boolean isPrimeNum(int number) {
        if(number <= 0) return false;
        if(number == 2) return true;

        int counter = 0;
        for(int i = 1; i <= number / 2; i ++) {
            if(number % i == 0) {
                if(++ counter == 2) return false;
            }
        }
        return true;
    }
}
