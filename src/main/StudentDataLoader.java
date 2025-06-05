package main;

import java.util.*;

public class StudentDataLoader {
    public static void loadIntoDoubleLinkedList(List<String[]> lines, DoubleLinkedList list) {
        for (int i = 1; i < lines.size(); i++) {
            String[] l = lines.get(i);
            if (l.length < 16) continue;

            StudentData s = new StudentData(
                    l[0],
                    Integer.parseInt(l[1]),
                    l[2],
                    Float.parseFloat(l[3]),
                    Float.parseFloat(l[4]),
                    Float.parseFloat(l[5]),
                    Boolean.parseBoolean(l[6]),
                    Float.parseFloat(l[7]),
                    Float.parseFloat(l[8]),
                    l[9],
                    Integer.parseInt(l[10]),
                    l[11],
                    l[12],
                    Integer.parseInt(l[13]),
                    Boolean.parseBoolean(l[14]),
                    Float.parseFloat(l[15])
            );
            list.add(s);
        }
    }
}