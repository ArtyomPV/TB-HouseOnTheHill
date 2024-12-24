package ru.gb.TB_HouseOnTheHill.settings;

public enum Commands {
    START("/start"),
    CONTACTS("/contacts"),
    INFO("/info");

    private final String commandType;

    Commands(String commandType) {
        this.commandType = commandType;
    }

    public String getCommandType(){
        return commandType;
    }
}
