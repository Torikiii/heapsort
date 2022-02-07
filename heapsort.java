/*
 * Filename: Act10.java
 * Description: Heap Sort
 * Date: 6/2/2022
 * @author Von Profugo
 */

package bsit.heapsort;
import java.util.*;


public class Act10 {
    
    static void swap(int arr[], int x, int y){
        int t = arr[x];  
        arr[x] = arr[y];
        arr[y] = t;
    }
    
    static void heapify(int arr[], int n, int i){       
        int root = 0;
        int l = 2 * i;
        int r = 2 * i + 1;
        
        if ((l <= n) && (arr[l] > arr[i])){
            root = l;
        } else {
            root = i;
        }
        
        if ((r <= n) && (arr[r] > arr[root])){
            root = r;
        }
        
        if (root != i){
            swap(arr, i, root);
            heapify(arr, n, root);
        }
    }
    
    static void tomaxheap(int arr[], int n){
        
        for (int i = n / 2; i >= 0; i--){
            heapify(arr, n, i);
        }
    }
    
    static void heapsort(int arr[]){
        int n = arr.length - 1;
        
        tomaxheap(arr, n);
        
        for (int i = n; i > 0; i--){
            swap(arr, 0, i);
            n = n - 1;
            heapify(arr, n, 0);
        }
    }
    
    public static void main(String args[]){
        int arr[] = {45, 31, 15, 72, 76, 12, 52, 10, 7, 65};
        
        heapsort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}