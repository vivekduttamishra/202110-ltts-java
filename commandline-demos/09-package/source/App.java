
import data.*;
import furnitures.*;
import data.Table;

public class App {

    public static void main(String[] args){

        Chair chair=new Chair();

        System.out.println("Price of Chair is "+ chair.getPrice());

        Bed bed=new Bed();

        List list=new List();

        list.add(chair);
        list.add(bed);

        Table table=new Table();  //data.Table because of import

        furnitures.Table table2=new furnitures.Table(); //furniture Table because of qualified name



        table.add(1,2,table2); //data table?

        System.out.println("price of table is "+table2.getPrice()); //furniture table?

    }    
}
