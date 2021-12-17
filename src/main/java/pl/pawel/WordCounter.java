package pl.pawel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCounter {
    public static List<Map.Entry<String, Integer>> countWords(String text){
        HashMap<String, Integer> countedWords = new HashMap<>();
        String[] keysToCount = text.toLowerCase().split("\\s+");
        for (int i = 0; i < keysToCount.length; i++) {
            keysToCount[i] = keysToCount[i].replaceAll("\\.|,|\\?|\\(|\\)", "");
        }
        for(String key : keysToCount){
            if(key != null) {
                countedWords.compute(key, (k, oldValue) -> {
                    if (oldValue == null) {
                        return 1;
                    } else {
                        return oldValue + 1;
                    }
                });
            }
        }

        List<Map.Entry<String, Integer>> sortedList = sortMap(countedWords);
        System.out.println("Lista:\n" + sortedList);
        return sortedList;
    }
    public static List<Map.Entry<String, Integer>> sortMap(Map<String, Integer> mapTosSort){
        List<Map.Entry<String, Integer>> result = mapTosSort.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).collect(Collectors.toList());
        return result;
    }
}
