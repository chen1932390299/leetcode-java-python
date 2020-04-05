package loop;

public class forloop {
    public static void main(String[] args) {

        //for(init exp;bool exp;step++ exp)
        int sums=0;
        for (int i = 0; i <100 ; i++) {
            if (i%2==0) {
                sums +=i;
            }
        }
        System.out.println(sums);
    }
}
