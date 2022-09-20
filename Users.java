package LockerOOD;

import javax.xml.stream.Location;
import java.sql.Time;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Users {
    String name;
    String userId;
    List<Code> list = new ArrayList<>();

    Users(String name, String userId){
        this.name = name;
        this.userId = userId;
    }
    public void receiveCode( int barCode, Date time, int lockerId, Location location ){ // 收到 pick up 通知
        list.add(new Code(barCode, time));
        System.out.println(
                name + " pick up time is: " + time + " at locker: " +
                        lockerId + " at " + location + " barCode: " + barCode);
    }
    public List<Integer> Expiration(Users users){ // 获得即将过期 还未pick up 的list
        Date currTime = new Date();
        List<Integer> expiredList = new ArrayList<>();
        List<Code> codes = users.list;
        for(Code code : codes){
            if(currTime.getTime() - code.date.getTime() > 3){
                expiredList.add(code.code);
            }
        }
        return expiredList;
    }
}
