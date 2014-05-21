
public class Shell_sort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
/*[java]
//Shell Sorting

SHELL(new Sortable() { 
    public <T extends Comparable<T>> void sort(T[] array, boolean ascend) { 
        int length = array.length; 
        int gap = 1; 
 
        // use the most next to length / 3 as the first gap 
        while (gap < length / 3) { 
            gap = gap * 3 + 1; 
        } 
 
        while (gap >= 1) { 
            for (int i = gap; i < length; i++) { 
                T next = array[i]; 
                int j = i; 
                while (j >= gap) { 
                    int compare = array[j - gap].compareTo(next); 
                    // already find its position 
                    if (compare == 0 || compare < 0 == ascend) { 
                        break; 
                    } 
 
                    array[j] = array[j - gap]; 
                    j -= gap; 
                } 
                if (j != i) { 
                    array[j] = next; 
                } 
            } 
            gap /= 3; 
        } 
 
    } 
}) */