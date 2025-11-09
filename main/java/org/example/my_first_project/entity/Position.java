package org.example.my_first_project.entity;


public enum Position {
    ACTIVE,
    INACTIVE;




    public static Position fromString(String value) {
        for (Position position : Position.values()) {
            if (position.name().equals(value)){
                return position;
            }
        }
        throw new RuntimeException("Invalid Enum " + value);
    }
}