package com.macro.pattern;

/**
 * Created by zhenghong on 2017/12/1.
 */
public class Invoker {
    private Command command;

    public void action() {
        command.execute();
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
