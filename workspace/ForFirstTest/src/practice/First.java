// package ForFirstTest.src.practice;
package practice;
import java.util.ArrayList;
import java.util.List;


// public static void main(String... var0) { ArrayList var1 = new ArrayList(); var1.add("Hi"); Object[] var2 = new Long[10]; var2[0] = Long.valueOf(1L); }
// public static void main(String... var0) { ArrayList var1 = new ArrayList(); var1.add("Hi"); Long[] var2 = new Long[10]; var2[0] = Long.valueOf(1L); }

public class First{

    public static void main(String... args) {
        List<String> list = new ArrayList<>();
        list.add("Hi");
        
        Object[] array = new Long[10];
        array[0] = 1L;
        
        if (array instanceof Object){
            System.out.println("맞다");
        }
    }

	// public static void main(String... var0) { 
    //     ArrayList var1 = new ArrayList(); 
    //     var1.add("Hi"); 
        
    //     Object[] var2 = new Long[10]; 
    //     var2[0] = Long.valueOf(1L); 
    //     }


    // public static void main(String... var1) { 
    //     ArrayList var1 = new ArrayList(); 
    //     var1.add("Hi");
        
    //     Long[] var2 = new Long[10]; 
    //     var2[0] = Long.valueOf(1L); 
    //     }
}