public class MedianTwoSortedArrays {
    //elemnets is no of elements
    public int solveUtil(int a[], int b[], int start, int end, int elements){
        // find the middle elements for both arrays
        int mid1 = start + (end -start)/2;
        int mid2 = (elements+1)/2 - mid1-2;


        //if elements are on left side and equal to one of the middle values

        if(a[mid1]<=b[mid2+1] && b[mid2]<=a[mid1+1]) {
            if(elements%2==0)
            return (Integer.max(a[mid1], b[mid2]) + Integer.min(a[mid1 + 1], b[mid2 + 1])) / 2;
            else
                return Integer.max(a[mid1],b[mid2]);
        }

        if(a[mid1]>b[mid2+1])
            return solveUtil(a,b,start,mid1,elements);

        return solveUtil(a,b,mid1+1,end,elements);

    }
    public double solve(int a[], int b[]){
        //determining whether values are odd or even
        return solveUtil(a,b,0,a.length-1,a.length+b.length);

    }

    public static void main(String[] args) {
        int a [] = {1,3,6};
        int b[] = {2,4,5};
        System.out.println(new MedianTwoSortedArrays().solve(a,b));

    }
}
