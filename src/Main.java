import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Use main to run and test the below functions
    }

    /**
     * Puts the elements in the arrayList in sorted order from smallest to greatest.
     * This function uses selection sort to sort the arrayList.
     * @param arrayList the ArrayList to be sorted. arrayList cannot contain duplicates
     */
    public static void selectionSort(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size() - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(j) < arrayList.get(index))
                    index = j;
            }

            int smallerNumber = arrayList.get(index);
            arrayList.set(index, arrayList.get(i));
            arrayList.set(i, smallerNumber);
        }
    }

    /**
     * Returns the index that value is located in the arrayList. This function searches linearly in
     * the arrayList to find the value.
     * @param arrayList the ArrayList containing the list of values to search. arrayList cannot contain duplicates
     * @param value the value we are looking for in the array list
     */
    public static int linearSearch(ArrayList<Integer> arrayList, int value) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == value)
                return i;
        }
        return -1;
    }

    /**
     * Returns the index that value is located in the arrayList. This function uses binary search in
     * the arrayList to find the value.
     * @param arrayList the ArrayList containing the list of values to search. THIS ARRAYLIST MUST BE
     *                  IN SORTED ORDER. arrayList cannot contain duplicates
     * @param value the value we are looking for in the array list
     */
    public static int binarySearch(ArrayList<Integer> arrayList, int value) {
        if (arrayList.size() == 0) {
            return -1;
        }
        int low = 0;
        int high = (arrayList.size() - 1);

        while(low <= high ) {
            int middle = (low+high) /2;
            if (value > arrayList.get(middle) ){
                low = middle +1;
            } else if (value < arrayList.get(middle)){
                high = middle -1;
            } else {
                return arrayList.indexOf(value);
            }
        }
        return -1;
    }

    /**
     * Puts the elements in the arrayList in sorted order from smallest to greatest.
     * This function uses MergeSort to sort the arrayList.
     * @param arrayList the ArrayList to be sorted. arrayList cannot contain duplicates
     */
    public static void mergeSort(ArrayList<Integer> arrayList) {
        sort(arrayList, 0, arrayList.size());
        merge(arrayList,0, arrayList.size()/2, arrayList.size());
    }

    /**
     * This function is a helper function used to help you implement mergeSort.
     * The function sorts the portion of arrayList specified by the range [lo, hi). The range
     * includes lo but excludes hi (arrayList[lo] is the first element in the range, but
     * arrayList[hi] is the first element after the last element in the range).
     * @param arrayList the ArrayList to be sorted.
     * @param lo the index of the first element in the range
     * @param hi the index of the last element in the range + 1.
     */
    public static void sort(ArrayList<Integer> arrayList, int lo, int hi) {
        if(hi - lo <= 1)
            return;
        int mid = (hi + lo) / 2;
        sort(arrayList, lo, mid);
        sort(arrayList, mid, hi);
        merge(arrayList, lo, mid, hi);
    }

    /**
     * This function is a helper function used to help you implement mergeSort.
     * The function merges two consecutive, sorted ranges in the arrayList into one sorted range. The ranges
     * are specified as [lo, mid) and [mid, hi). Each range includes the first element, but excludes
     * the last element (the same way as in sort()).
     * @param arrayList the ArrayList to be sorted.
     * @param lo the index of the first element in the first range
     * @param mid the boundary point of the two ranges. arrayList[mid] is in the second range.
     * @param hi the index of the last element in the second range + 1.
     */
    public static void merge(ArrayList<Integer> arrayList, int lo, int mid, int hi) {
        int[] newArr = new int[arrayList.size()];
        for (int i = lo; i <= hi; i++) {
            newArr[i] = arrayList.get(i);
        }

        int newArrLeft = lo;
        int newArrRight = mid+1;
        int current = lo;

        while (newArrLeft <= mid && newArrRight <= hi) {
            if(newArr[newArrLeft] <= newArr[newArrRight]){
                arrayList.set(current, newArr[newArrLeft]);
                newArrLeft++;

            }

            else {
                arrayList.set(current, newArr[newArrRight]);
                newArrRight++;
            }
            current ++;
        }

        int remaining = mid - newArrLeft;
        for (int i = 0; i <= remaining; i++) {
            arrayList.set(current+i, newArr[newArrLeft+ i]);
        }
    }
    }