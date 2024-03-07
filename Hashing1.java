
	
	public class Hashing1 {
	    private Integer[] hashTable;
	    private int N;
	    private int size;

	    public Hashing1(int capacity) {
	        this.size = capacity;
	  
	        this.hashTable = new Integer[capacity];
	        
	        this.N = 13; 
	    }

	    private int hashFunction(int key) {
	        return key % N;
	    }

	    // Method to add a key to the hash table
	    public void add(int key) {
	        int ip = hashFunction(key);
	        int q = key / N;
	        int offset = (q % N != 0) ? q : 4; // Simplified for demonstration; adjust 4 or the prime calculation as needed

	        // Find the next available slot in case of collision
	        while (hashTable[ip] != null) {
	            ip = (ip + offset) % size; // Use capacity for wrapping around the table
	        }

	        // Insert the key into the hash table
	        hashTable[ip] = key;
	    }

	    // Method to display the hash table
	    public void displayHashTable() {
	        for (int i = 0; i < size; i++) {
	            if (hashTable[i] == null) {
	                System.out.println("Slot " + i + ": Empty");
	            } else {
	                System.out.println("Slot " + i + ": " + hashTable[i]);
	            }
	        }
	    }

	    public static void main(String[] args) {
	        Hashing1 dh = new Hashing1(13); // Assuming a table size of 13 for simplicity

	        // Add given keys
	        int[] keys = {27, 53, 13, 10, 138, 109, 49, 174, 26, 24};
	        for (int key : keys) {
	            dh.add(key);
	        }

	        // Display the hash table
	        dh.displayHashTable();
	    }
	}


