/*
 * Decompiled with CFR 0.152.
 */
package edu.hnu.vspm.Memory;

import java.util.Vector;

public class Memory {
    private Vector<String> m = new Vector();

    public Memory() {
        this.m.setSize(256);
        for (int i = 0; i < 256; ++i) {
            this.m.set(i, "");
        }
    }

    public void init() throws Exception {
        for (int i = 0; i < 256; ++i) {
            this.m.set(i, "");
        }
    }

    public String getMemoryValue(byte address) throws Exception {
        String str = this.m.get(address);
        if (0 == str.length()) {
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

