package CodingChallenge;

import java.io.IOException;
import java.net.URL;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

interface name{

}

public class Day10 {
    public static void main(String[] args) throws IOException {
        var timeZone= ZoneId.of("America/Toronto");
        var DubaiTimeZone=ZoneId.of("Asia/Dubai");
        var takeOfTime= LocalDateTime.of(2021, Month.JUNE,16,21,45);
        var zoneTakeOfTime= ZonedDateTime.of(takeOfTime,timeZone);
        var timeDuration= Duration.ofHours(12).plusMinutes(45);
        var arrivalTime=zoneTakeOfTime.plus(timeDuration);
        var ZonedArrivalTime=arrivalTime.toInstant().atZone(DubaiTimeZone);
        var formattedTime= DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                .format(ZonedArrivalTime);
        System.out.println(formattedTime);
        var url=new URL("http://www.oracle.com/");
        var conn=url.openConnection();
        System.out.println(conn);
    }
}
