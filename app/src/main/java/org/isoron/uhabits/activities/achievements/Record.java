package org.isoron.uhabits.activities.achievements;


public class Record {

    private String name;
    private String time;
    private int value;

    Record(String name, String time, int value) {
        this.name = name;
        this.time = time;
        this.value = value;
    }

    public String getName() { return name; }

    public String getTime() { return time; }

    public int getValue() { return value; }
}
