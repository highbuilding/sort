/**
 * Created by where1993 on 2017/2/23.
 */
public class Heap {
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];a[i]=a[j];a[j]=t;
    }
    private static void show(Comparable[] a){
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
    public static boolean isSorted(Comparable[] a){
        for(int i=1;i<a.length;i++){
            if(less(a[i],a[i-1])) return false;
        }
        return true;
    }
    public static void sort(Comparable[] a){
        int N=a.length;
        for(int i=1;i<N;i++){
            for(int j=i;j>0&&less(a[j],a[j-1]);j--){
                exch(a,j,j-1);
            }
        }
    }
    private static void MinHeapFixup(Comparable[] a,int i){
        int j;
        Comparable temp=a[i];
        j=(i-1)/2;
        while(j>=0&&i!=0){
            if(less(a[j],temp))
                break;
            a[i]=a[j];
            i=j;
            j=(i-1)/2;
        }
        a[i]=temp;
    }

    private static void MinHeapFixdown(Comparable[] a,int i,int N){
        int j;
        Comparable temp=a[i];
        j=2*i+1;
        while(j<N){
            if(j+1<N&&less(a[j+1],a[j]))
                j++;
            if(less(temp,a[j]))
                break;
            a[i]=a[j];
            i=j;
            j=2*i+1;
        }
        a[i]=temp;
    }
    public static void sort(Comparable a[], int n)
    {
        for (int i = n - 1; i >= 1; i--)
        {
            exch(a,i,0);
            MinHeapFixdown(a, 0, i);
        }
    }

    public static void main(String[] args){
        String[] a={"b","a","d","e","g","w","x","t","c"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
