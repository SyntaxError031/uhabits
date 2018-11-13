package org.isoron.uhabits.activities.achievements;

public enum Medals {

    ONE(10), TWO(100), THREE(500), FOUR(1000);
    private final int achievePoint;
    private Status status;

    Medals(int points) {
        achievePoint = points;
        status = Status.LOCKED;
    }

    public Status getStatus() {
        return status;
    }

    public void changeStatus(int points) {
        if(points >= achievePoint) {
            status = Status.ACHIEVED;
        }
    }
}

enum Status {
    ACHIEVED, LOCKED
}
