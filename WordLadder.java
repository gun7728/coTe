import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(words);
        WordLadder a = new WordLadder();
        System.out.println(a.solve("hit","cog",wordList));
        
    }

    public int solve(String begin, String end, List<String> wordList){
        if(wordList == null || !wordList.contains(end))
            return 0;
            
        
        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);


        queue.offer(begin);
        dict.add(end);
        dict.remove(begin);

        int level = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String str = queue.poll();
                if(str.equals(end)){
                    return level;
                }
                for(String neighbor : neighbors(str,wordList)){
                    queue.offer(neighbor);
                }
            }
            level++;
        }

        return level;
    }

    public List<String> neighbors(String s, List<String> wordList){
        List<String> res = new LinkedList<>();
        Set<String> dict = new HashSet<>(wordList);

        for(int i=0;i<s.length();i++){
            char[] chars = s.toCharArray();
            for(char ch='a'; ch<='z' ; ch++){
                chars[i]=ch;//ait ~ zit
                String word = new String(chars);
                if(dict.remove(word)){
                    res.add(word);
                }
            }
        }
        return res;
    }
}
