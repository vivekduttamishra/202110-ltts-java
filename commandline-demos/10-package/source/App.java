
import data.Table;
import data.List;
import furnitures.Chair;
import data.Dictionary;
import furnitures.Bed;
import data.BinarySearch;
import data.BubbleSort;

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

        furnitures.Table table2=new furnitures.Table();


        System.out.println(chair);
        System.out.println(bed);
        System.out.println(list);
        System.out.println(dictionary);
        System.out.println(table);
        System.out.println(table2);

        System.out.println(search);

        System.out.println(sort);
      

    }    
}
