package LinearandBinarySearch.BinarySearch;
import java.util.*;
public class RotationPoint {
    public static void main(String[] args) {
        int arr[]={2,3,4,1,6,7};
        Arrays.sort(arr);
        int n=arr.length;
        int low=0;
        int high=n-1;
        while(low<high){
            for(int i=0;i<n;i++){

            
            int mid=(low+high)/2;
            if(arr[mid]>arr[high]){
                low=mid+1;
            }else if(arr[mid]<high){
                high=mid;
            
            }else{
                arr[i]=mid;
            }
        }
    }
        System.out.println(low + " is rotation point.");


    }
}
