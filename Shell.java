import java.lang.Comparable;
public class Shell {
    public static void sort(Comparable[] a){
        int N = a.length;
        int h = 4;
        while (h >= 1){
            for (int i = h; i < N; i++){
                for (int j = i; j >= h && isless(a[j], a[j-h]); j -= h){
                    swap(a, j, j-h);
                }
            }
        }
    }
}
