/**
 * Created by David on 1/14/2016.
 */
import java.util.TreeSet;
public class Tree {

        public static void main(String args[]) {
            // TreeSet of String Type
            TreeSet<String> tset = new TreeSet<String>();

            // Adding elements to TreeSet<String>
            tset.add("ABC");
            tset.add("String");
            tset.add("Test");
            tset.add("Pen");
            tset.add("Ink");
            tset.add("Jack");

            //Displaying TreeSet
            System.out.println("Contents of tset: " + tset);
            System.out.println("Empty: " + tset.isEmpty());
            System.out.println("First element: " + tset.first());
            System.out.println("Last element: " + tset.last());
            tset.add("abc");
            tset.add("Abc");
            tset.add("string");
            tset.add("test");
            tset.add("pen");
            tset.add("ink");
            tset.add("jack");
            System.out.println("Contents of tset: " + tset);
            System.out.println("Size of tset: " + tset.size());
            System.out.println("Elements between 'String' and 'ink': " + tset.subSet("String","ink"));
            try{
                tset.add(null);
            }
            catch(Exception e){
                System.out.println("Error adding null: " + e);
            }
            try{
                tset.add("");
                System.out.println("Added empty string: " + tset);
            }
            catch(Exception e){
                System.out.println("Error adding empty string: " + e);
            }
            try{
                tset.add("jack");
                System.out.println("Added duplicate: " + tset);
            }
            catch(Exception e){
                System.out.println("Error adding duplicate: " + e);
            }
            try{
                tset.remove("jill");
                System.out.println("removed item not in tset: " + tset);
            }
            catch(Exception e){
                System.out.println("Error removing non existing element: " + e);
            }
            System.out.println(tset.comparator());
            try{
                System.out.println("checking to see if it contains 10: " + tset.contains(10));
            }
            catch(Exception e){
                System.out.println("Error checking if tset contains a number: " + e);
            }
            try{
                System.out.println("checking to see if it contains '10': " + tset.contains("10"));
            }
            catch(Exception e){
                System.out.println("Error checking if tset contains a number: " + e);
            }

            // TreeSet of Integer Type
            TreeSet<Integer> tset2 = new TreeSet<Integer>();

            // Adding elements to TreeSet<Integer>
            tset2.add(88);
            tset2.add(7);
            tset2.add(101);
            tset2.add(0);
            tset2.add(3);
            tset2.add(222);
            System.out.println(tset2);
            try{
                tset2.add(null);
            }
            catch(Exception e){
                System.out.println("Error adding null: " + e);
            }
            TreeSet<Integer> tset3 = new TreeSet<Integer>();
            tset3.add(40);
            tset3.add(41);
            tset3.add(42);
            tset3.add(43);
            tset3.add(44);
            try{
                tset2.addAll(tset3);
                System.out.println("addAll from tset3 to tset2: " + tset2);
            }
            catch(Exception e){
                System.out.println("Error adding tset to tset2: " + e);
            }
        }
    
}
