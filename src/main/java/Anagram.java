import java.util.*;

class Anagram {

    String word;
    Map<Character, Integer> mappedLetters;

    Anagram(String word){
        this.word = word;
        mappedLetters = mapLetters(word);
    }

    public List<String> match(List<String> words){

        List<String> response = new ArrayList<>();

        for (String newWord : words)
            if(isAnagram(newWord))
                response.add(newWord);

        return response;
    }

    private boolean isAnagram(String compareString) {
        try {

            if(word.equalsIgnoreCase(compareString))
                return false;

            Map<Character, Integer> compareMappedLetters = mapLetters(compareString);

            if(mappedLetters.size() != compareMappedLetters.size())
                return false;

            for (Map.Entry<Character, Integer> entry : mappedLetters.entrySet())
                if(entry.getValue() != compareMappedLetters.get(entry.getKey()))
                    return false;

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    private Map<Character, Integer> mapLetters(String word) {
        Map<Character, Integer> mappedLetters = new HashMap<>();

        for (char letter : word.toLowerCase().toCharArray()) {
            if(!mappedLetters.containsKey(letter))
                mappedLetters.put(letter, 1);
            else
                mappedLetters.put(letter, mappedLetters.get(letter) + 1);
        }

        return mappedLetters;
    }

}