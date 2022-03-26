package boys;

import java.util.ArrayList;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BoysFilter {

    public static Map<String, Long> getFilteredBoys(ArrayList<Boy> boys) {
        return boys.stream()
                .filter(boy -> boy.getAge() >= 18)
                .map(Boy::getName)
                .distinct()
                .sorted()
                .limit(4)
                .collect(Collectors.toMap(Function.identity(), name -> boys.stream()
                        .filter(boy -> boy.getName().equals(name)).count() - 1));
    }
}
