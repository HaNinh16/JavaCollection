import javax.swing.*;
import java.awt.*;

import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

public class Execute {
    static ArrayList<Person> people = new ArrayList<>(Arrays.asList(

            new Person("Vinh", "Vietnam", 28),
            new Person("Lan", "Vietnam", 24),
            new Person("John", "USA", 27),
            new Person("Lee", "China", 67),
            new Person("Kim", "Korea", 22),
            new Person("Long", "Vietnam", 18),
            new Person("Jungho", "Korea", 19),
            new Person("Tian", "China", 20),
            new Person("Clara", "USA", 40),
            new Person("Mikura", "Japan", 27),
            new Person("Sony", "Japan", 29),
            new Person("Xiang", "China", 78),
            new Person("Peter", "France", 18),
            new Person("Haloy", "Malaysia", 20),
            new Person("Magie", "Malaysia", 32)
    ));

    //Bài 1 - Đếm số người của mỗi quốc gia
    public static void EX1() {
        Map<String, Integer> countqg = new HashMap<>();
        for (Person person : people) {
            Integer countPS = countqg.get(person.getNationality());
            if (countPS == null) {
                countqg.put(person.getNationality(), 1);
            } else {
                countqg.put(person.getNationality(), countPS + 1);
            }
        }

        for (String key : countqg.keySet()) {
            System.out.println(key + " : " + countqg.get(key));
        }
    }

    //Bài 2 - Danh sách người trên 25t
    public static void EX2() {
        ArrayList<Person> people25 = new ArrayList<>();
        for (Person person : people) {
            Integer agec = person.getAge();
            if (agec > 25) {
                people25.add(person);
            }
        }
        people25.sort(Comparator.comparing(Person::getAge));

        for (Person s : people25) {
            System.out.println(s.name + " - " + s.nationality + " - " + s.age);
        }

    }

    //Bài 3 - Tính trung bình tuổi của người theo từng quốc gia
    public static void EX3() {
        Map<String, List<Integer>> mapTuoi = new HashMap<>();
        for (Person person : people) {
            if (mapTuoi.containsKey(person.nationality)) {
                List<Integer> arr = mapTuoi.get(person.getNationality());
                arr.add(person.age);
                mapTuoi.put(person.getNationality(), arr);
            } else {
                List<Integer> arr = new ArrayList<>();
                arr.add(person.age);
                mapTuoi.put(person.getNationality(), arr);
            }
        }

        Map<String, Double> TBTuoi = new HashMap<>();
        for (String key : mapTuoi.keySet()) {
            List<Integer> tinhTong = mapTuoi.get(key);
            int tong = 0;
            for (int i = 0; i < tinhTong.size(); i++) {
                tong = tong + tinhTong.get(i);
            }
            double TB = (double) tong / tinhTong.size();
            TBTuoi.put(key, TB);
        }

        for (String key : TBTuoi.keySet()) {
            System.out.println(key + " - " + TBTuoi.get(key));
        }


    }

    //Bài 4 - In ra màn hình đánh giá tuổi mỗi người
    public static void EX4() {
        String danhGia;
        for (Person person : people) {
            Integer agec = person.getAge();
            if (agec < 20) {
                danhGia = "Nổi loạn";
            } else if (20 <= agec && agec <= 30) {
                danhGia = "Việc làm";
            } else if (31 <= agec && agec <= 40) {
                danhGia = "Tuổi sự nghiệp";
            } else {
                danhGia = "Hưởng thụ";
            }
            System.out.println(person.name + " - " + person.nationality + " - " + person.age + " - " + danhGia);
        }
    }

}
