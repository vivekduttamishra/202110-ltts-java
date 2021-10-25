public class App1 {

    public static void main(String[] args){

        furnitures.Chair chair=new furnitures.Chair();

        System.out.println("Price of Chair is "+ chair.getPrice());

        furnitures.Bed bed=new furnitures.Bed();

        data.List list=new data.List();

        list.add(chair);
        list.add(bed);

        data.Table table=new data.Table();
        furnitures.Table table2=new furnitures.Table();



        table.add(1,2,table2); //data table?

        System.out.println("price of table is "+table2.getPrice()); //furniture table?

    }    
}
