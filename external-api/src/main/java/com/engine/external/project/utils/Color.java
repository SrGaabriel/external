package com.engine.external.project.utils;

public enum Color {


    BLACK("0", "\u001B[30m"),
    RESET("r", "\u001B[0m"),
    WHITE("f", "\u001B[97m"),
    BLUE("1", "\u001B[34m"),
    CYAN("3", "\u001B[36m"),
    GREEN("2", "\u001B[32m"),
    RED("4", "\u001B[31m"),
    PURPLE("5", "\u001B[35m"),
    YELLOW("6", "\u001B[33m"),
    LIGHT_GRAY("7", "\u001B[37m"),
    GRAY("8", "\u001B[90m"),
    LIGHT_BLUE("9", "\u001B[94m"),
    LIGHT_GREEN("a", "\u001B[92m"),
    LIGHT_CYAN("b", "\u001B[96m"),
    LIGHT_RED("c", "\u001B[91m"),
    LIGHT_PURPLE("d", "\u001B[95m"),
    LIGHT_YELLOW("e", "\u001B[93m");


    private final String code;
    private final String ansi;

    Color(String colorCode, String colorAnsi) {
        this.code = colorCode;
        this.ansi = colorAnsi;
    }

    public String getCode() {
        return code;
    }

    public String getAnsi() {
        return ansi;
    }
}
