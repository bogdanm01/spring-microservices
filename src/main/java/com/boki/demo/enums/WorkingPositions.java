package com.boki.demo.enums;

public enum WorkingPositions {
    ENTRY_DEVELOPER(1,"Entry developer"),
    JUNIOR_DEVELOPER(2,"Junior developer"),
    MEDIOR_DEVELOPER(3, "Medior developer"),
    SENIOR_DEVELOPER(4, "Senior developer"),
    TEAM_LEAD(5, "Team lead");

    public long id;
    public String name;

    WorkingPositions(long id, String name){
        this.id = id;
        this.name = name;
    }
}
