import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateMain {
    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy년 MM월 dd일\nyyyy-MM-dd HH:mm:ss\n오늘은 이 달의 F번째 E요일 입니다.", Locale.KOREA);
        System.out.println(simpleDateFormat.format(date));


    }
}