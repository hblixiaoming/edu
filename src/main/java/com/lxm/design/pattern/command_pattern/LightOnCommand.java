package com.lxm.design.pattern.command_pattern;

/**
 * Created by LXM on 2017/6/3.
 */
public class LightOnCommand implements Command{

    Light light;

    public LightOnCommand(Light light){
        this.light=light;
    }

    @Override
    public void execute() {
        light.lightOn();
    }

}
