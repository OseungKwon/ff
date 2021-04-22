import java.util.Iterator;
import java.util.*;


class CartForSongs{
    ArrayList<Song> cart = new ArrayList<Song>();
    public double calculateTotalPrice(){
        double total=0.0;
        Iterator<Song> itr = cart.iterator();

        while(itr.hasNext()){
            Song s=itr.next();
            total=total+s.getPrice();
        }
        return total;
    }
    public void add(Song s){
        cart.add(s);
    }
}

class Song{
    private DiscountMode mode;
    public void setMode(DiscountMode mode){
        this.mode=mode;
    }
    public double getPrice(){
        return 10.0 - (10.0 * this.mode.getDiscountRate());
    }
}

abstract class DiscountMode{
    public abstract double getDiscountRate();
}
class NonDiscounted extends DiscountMode{
    public double getDiscountRate(){
        return 0.0;
    }
}
class OnSale extends DiscountMode{
    @Override
    public double getDiscountRate() {
        return 0.1;
    }
}
class TodayEvent extends DiscountMode{
    @Override
    public double getDiscountRate() {
        return 0.3;
    }
}


public class chap2Song {
    public static void main(String[] args){
        Song s1 = new Song();
        s1.setMode(new NonDiscounted());
        Song s2 = new Song();
        s2.setMode(new NonDiscounted());
        Song s3 = new Song();
        s3.setMode(new OnSale());
        Song s4 = new Song();
        s4.setMode(new TodayEvent());

        CartForSongs c = new CartForSongs();
        c.add(s1);
        c.add(s2);
        c.add(s3);
        c.add(s4);

        System.out.println(c.calculateTotalPrice());
    }
}
