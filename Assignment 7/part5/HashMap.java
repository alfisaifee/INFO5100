package assignment7.part5;

import java.util.LinkedList;

public class HashMap {
    private class Entry{
        private int value;
        private int key;

        public Entry(int value, int key){
            this.value = value;
            this.key = key;
        }
    }

    private LinkedList<Entry>[] entries;
    private int numBuckets = 10000;

    public HashMap(){
        entries = new LinkedList[numBuckets];
    }

    public void put(int key, int value){
        int hash = hash(key);

        if(entries[hash] == null) {
            entries[hash] = new LinkedList<>();
        }

        for(Entry ent : entries[hash]){
            if(ent.key == key) {
                ent.value = value;
                return;
            }
        }

        entries[hash].add(new Entry(key, value));
    }

    public int get(int key){
        int hash = hash(key);
        if(entries[hash] != null){
            for(Entry ent : entries[hash]){
                if(ent.key == key)
                    return ent.value;
            }
        }
        return -1;
    }

    public void remove(int key){
        int hash = hash(key);
        if(entries[hash] != null) {
            entries[hash].removeIf(ent -> ent.key == key);
        }
    }

    private int hash(int key){
        return Integer.hashCode(key) % numBuckets;
    }


    public static void main(String[] args){
        HashMap map = new HashMap();
        map.put(1,1);
        map.put(2,2);
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        map.put(2,1);
        System.out.println(map.get(2));
        map.remove(2);
        System.out.println(map.get(2));
    }
}
