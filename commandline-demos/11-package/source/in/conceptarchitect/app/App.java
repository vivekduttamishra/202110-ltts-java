package in.conceptarchitect.app;

import in.conceptarchitect.data.Table;
import in.conceptarchitect.data.List;
import in.conceptarchitect.furnitures.Chair;
import in.conceptarchitect.data.Dictionary;
import in.conceptarchitect.furnitures.Bed;
import com.javapeople.data.BinarySearch;
import com.javapeople.data.QuickSort;

//import furnitures.Table; //will cause ambiguity

public class App {

    public static void main(String[] args){

        Chair chair=new Chair();
        Bed bed=new Bed();
        List list=new List();
        Table table=new Table();  //data.Table because of import
        Dictionary dictionary=new Dictionary();
        BinarySearch search=new BinarySearch();
        QuickSort sort=new QuickSort();

        in.conceptarchitect.furnitures.Table table2=new in.conceptarchitect.furnitures.Table();


        System.out.println(chair);
        System.out.println(bed);
        System.out.println(list);
        System.out.println(dictionary);
        System.out.println(table);
        System.out.println(table2);

        System.out.println(search);

        System.out.println(sort);
      
        com.javapeople.data.List list2=new com.javapeople.data.List();

        System.out.println(list2);
    }    
}
