public class App {

    public static void main(String[] args){

        Chair chair=new Chair();

        System.out.println("Price of Chair is "+ chair.getPrice());

        Bed bed=new Bed();

        List list=new List();

        list.add(chair);
        list.add(bed);
    }    
}
