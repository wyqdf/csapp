/*
 * Decompiled with CFR 0.152.
 */
package edu.hn.vspm.Memory;

import java.util.Vector;

public class Memory {
    private Vector<String> m = new Vector();

    public Memory() {
        this.m.setSize(256);
        int i = 0;
        while (i < 256) {
            this.m.set(i, "");
            ++i;
        }
    }

    public void init() throws Exception {
        int i = 0;
        while (i < 256) {
            this.m.set(i, "");
            ++i;
        }
    }

    public String getMemoryValue(byte address) throws Exception {
        String str = this.m.get(address);
        if (str.length() == 0) {
            str = "0";
        }
        return str;
    }

    public void setMemoryValue(byte address, String s) throws Exception {
        this.m.set(address, s);
    }

    public void setMemoryValue(byte address, byte b) throws Exception {
        String s = Integer.toString(b);
        this.m.set(address, s);
    }
}

