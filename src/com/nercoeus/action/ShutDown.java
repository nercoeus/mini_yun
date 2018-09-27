//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.nercoeus.action;

import com.opensymphony.xwork2.ActionSupport;

public class ShutDown extends ActionSupport {
    public ShutDown() {
    }

    public String execute() throws Exception {
        Runtime.getRuntime().exec("shutdown -s -t 30");
        return super.execute();
    }
}
