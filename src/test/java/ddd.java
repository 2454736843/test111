import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ddd {
    public static void main(String[] args) throws ParseException {
        String busDateTime="20191228151455";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        Date parse = formatter.parse(busDateTime);
        System.out.println(parse);
        System.out.println(parse.getTime()/1000);
    }
}
