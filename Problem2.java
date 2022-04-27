import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyHashSet {
    private final int ARRAY_SIZE = 1000;
    private List<List<Integer>> parentList;
    
    
    public MyHashSet() {
        parentList = new ArrayList<>(ARRAY_SIZE);
        for(int i = 0; i < ARRAY_SIZE; i++){
            parentList.add(null);
        }
    }
    
    public void add(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);
        if(childList == null){
            List<Integer> list = new LinkedList<>();
            list.add(key);
            parentList.set(index, list);
        } else {
            if(!childList.contains(key)){
                childList.add(key);
            }
        }
    }
    
    public void remove(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);
        if(childList != null){
            childList.remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        int index = key % ARRAY_SIZE;
        List<Integer> childList = parentList.get(index);
        return childList != null && childList.contains(key);
    }
}

public class Problem2 {
    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(22);
        obj.remove(22);
        boolean param_3 = obj.contains(22);
        System.out.println(param_3);
    }
}
