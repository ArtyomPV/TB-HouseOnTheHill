package ru.gb.TB_HouseOnTheHill.settings;

import java.util.HashSet;
import java.util.Set;

import static ru.gb.TB_HouseOnTheHill.settings.Commands.*;

public class CommandTypes {
    public Set<String> types(){
        Set<String> types = new HashSet<>();
        types.add(START.getCommandType());
        types.add(CONTACTS.getCommandType());
        types.add(INFO.getCommandType());

        return types;
    }
}
