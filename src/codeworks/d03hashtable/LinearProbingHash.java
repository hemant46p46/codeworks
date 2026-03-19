package codeworks.d03hashtable;

public class LinearProbingHash {
	private int[] table;
	private int size;
	private int count;
	public LinearProbingHash(int size) {
		super();
		this.size = size;
		this.table = new int[size];
		this.count = 0;
		for(int i=0;i<size;i++) {
			table[i] = -1;
		}
	}
	
	private int hashF(int key) {
		return key%this.size;
	}
	
	public void insert(int key) {
		if(count == size) {
			System.out.println("Hashtable is full");
			return;
		}
		int index = hashF(key);
		
		while(table[index]!=-1 && table[index]!=-2) {
			index = (index+1)%size;
		}
		table[index] = key;
		count++;
	}
	
	public boolean search(int key) {
		int index = hashF(key);
		int start = index;
		
		while(table[index] != -1) {
			if(table[index]==key) {
				return true;
			}
			index = (index + 1) % size;
			
			if(index==start) {
				break;
			}
		}
		return false;
	}
	
	public void delete(int key) {
		int index = hashF(key);
		int start = index;
		
		while(table[index] != -1) {
			if(table[index]== key) {
				table[index] = -2;
				count--;
				return;
			}
			index = (index + 1)%size;
			
			if(index==start) {
				break;
			}
		}
		System.out.println("Key not found");
	}
	
	public void print() {
		 for(int i=0;i<size;i++){
            if(table[i] == -1)
                System.out.println(i+" -> EMPTY");
            else if(table[i] == -2)
                System.out.println(i+" -> DELETED");
            else
                System.out.println(i+" -> "+table[i]);
        }
	}
}
