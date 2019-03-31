package controller;

import dao.impl.BookDAOimpl;
import entity.Book;
import java.util.ArrayList;
import java.util.Collections;

import javafx.collections.FXCollections;

public class Sorting {
ArrayList<Book> list = new ArrayList<Book>();
public static ArrayList<String> arr_author = new ArrayList<String>();
public static ArrayList<String> arr_title = new ArrayList<String>();
public static ArrayList<String> arr_year = new ArrayList<String>();
public static ArrayList<String> arr_ISBN = new ArrayList<String>();
public static ArrayList<String> arr_ISBN_string = new ArrayList<String>();
public static ArrayList<String> arr_publisher = new ArrayList<String>();
public static ArrayList<String> arr_LLC = new ArrayList<String>();
public static ArrayList<Integer> arr_ISBN_index = new ArrayList<Integer>();

public ArrayList<Book> local_bookList	;

public ArrayList<String> arr_sorted = new ArrayList<String>();

int length;
int bookNum;
int sortedArrayIndex[];
boolean condition;  

public Sorting() {
	
}

public Sorting(ArrayList<Book> list) {
	this.list = list;
	this.local_bookList = new ArrayList<>(list);
	this.bookNum = list.size();
        this.sortedArrayIndex = new int[bookNum];
}

public void sortbyAuthor() {
	arr_sorted.clear();
	sort(arr_author);
	//arr_author = arr_sorted;
}

public void sortbytitle() {
	arr_sorted.clear();
	sort(arr_title);
	//arr_title = arr_sorted;
}

public void sortbyYear() {
	arr_sorted.clear();
	sort(arr_year);
	//arr_year = arr_sorted;
}

public void sortbyPublisher() {
	arr_sorted.clear();
	sort(arr_publisher);
	//arr_publisher = arr_sorted;
}

public void sortbyLLC() {
	arr_sorted.clear();
	sort(arr_LLC);
	//arr_LLC = arr_sorted;
}
public  void sortbyISBNString() {
	

	arr_sorted.clear();
	sort(arr_ISBN_string);

		
}

public void sortbyISBN() {
	condition=true;
	arr_sorted.clear();
	sort(arr_ISBN_string);
	
	condition=false;
	
}

public int[][] sort(int[][] values) {
	int[][] numbers;
	int number;
	int count = 0;
    // check for empty or null array
    if (values ==null || values[1].length==0){
        return values;
    }
    numbers = values;
    number = values[1].length;
    quicksort(0, number - 1, numbers);
    
    for(int i = 0; i < numbers[1].length; i++) {
    	if(numbers[1][i] != 0) 
            count++;
    }
    int[][] priority = new int[2][count]; 
    count = 0;
    for(int i = numbers[1].length - 1; i >= 0; i--) {
    		if(numbers[1][i] != 0) {   		
                priority[0][count] = numbers[0][i];
                priority[1][count] = numbers[1][i];
                count++;
        	}
    	} 
    return priority;
}

private void quicksort(int low, int high, int[][] numbers) {
    int i = low, j = high;
    // Get the pivot element from the middle of the list
    int pivot = numbers[1][low + (high-low)/2];

    // Divide into two lists
    while (i <= j) {
        // If the current value from the left list is smaller than the pivot
        // element then get the next element from the left list
        while (numbers[1][i] < pivot) {
            i++;
        }
        // If the current value from the right list is larger than the pivot
        // element then get the next element from the right list
        while (numbers[1][j] > pivot) {
            j--;
        }

        // If we have found a value in the left list which is larger than
        // the pivot element and if we have found a value in the right list
        // which is smaller than the pivot element then we exchange the
        // values.
        // As we are done we can increase i and j
        if (i <= j) {
            exchange(i, j, numbers);
            i++;
            j--;
        }
    }
    // Recursion
    if (low < j)
        quicksort(low, j, numbers);
    if (i < high)
        quicksort(i, high, numbers);
}

private void exchange(int i, int j, int[][] numbers) {
    int tempIndex = numbers[0][i];
    int tempPriority=numbers[1][i];
    numbers[0][i] = numbers[0][j];
    numbers[0][j] = tempIndex;
    numbers[1][i] = numbers[1][j];
    numbers[1][j] = tempPriority;
}

void sort(ArrayList<String> array) {
	if (array == null || array.size() == 0)
	 {
		return;
		}
	arr_sorted = new ArrayList<>(array);
	length = array.size();
	
	quickSort(0, length - 1);	
}


void quickSort(int lowerIndex, int higherIndex) {
	int i = lowerIndex;
	int j = higherIndex;
	String pivot = arr_sorted.get(lowerIndex + (higherIndex - lowerIndex) / 2);
	while (i <= j) {
		while (arr_sorted.get(i).compareToIgnoreCase(pivot) < 0) {
			i++;
			}
		
		while (arr_sorted.get(j).compareToIgnoreCase(pivot) > 0) {
		
                    j--;
			}
		if (i <= j) {
			exchangeElements(i, j);
			i++;
			j--;
			}
	}
	//call quickSort recursively
	if (lowerIndex < j) {
		quickSort(lowerIndex, j);}
	if (i < higherIndex) {
		quickSort(i, higherIndex);

	}
	}
void exchangeElements(int i, int j) {
	ArrayList<Book> list = BookDAOimpl.getInstance().getAll();
	
            swapBooks(i,j,local_bookList, list);
            String temp = arr_sorted.get(i);
            arr_sorted.set(i, arr_sorted.get(j));
            arr_sorted.set(j, temp);
        
        
	//if(condition) {
                /*System.out.println("Sucsess 01");
                
                String temp = arr_sorted.get(i);
                arr_sorted.set(i, arr_sorted.get(j));
                arr_sorted.set(j, temp);
                swapBooks(arr_ISBN_index.get(i),arr_ISBN_index.get(j),local_bookList, list);
		int tempi=arr_ISBN_index.get(i);
		arr_ISBN_index.set(i, arr_ISBN_index.get(j));
		arr_ISBN_index.set(j, tempi );}
                System.out.println("Sucsess 02");*/
                
	}


	public void swapBooks(int a, int b, ArrayList<Book> local_bookList, ArrayList<Book> list) {
		
            Book temp = local_bookList.get(a);
		local_bookList.set(a,local_bookList.get(b));
		local_bookList.set(b, temp);
	}
	

}