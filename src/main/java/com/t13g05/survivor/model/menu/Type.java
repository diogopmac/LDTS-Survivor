package com.t13g05.survivor.model.menu;

public enum Type {
    START_GAME("Start Game"), OPTIONS("Options"), CONTROLS("Controls"), QUIT("Quit");

    private final String text;

    Type(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
}
