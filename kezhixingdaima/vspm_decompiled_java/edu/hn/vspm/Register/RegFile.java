/*
 * Decompiled with CFR 0.152.
 */
package edu.hn.vspm.Register;

import edu.hn.vspm.Register.Register;
import java.util.Vector;

public class RegFile {
    Vector<Register> regs = new Vector();

    public RegFile() {
        this.regs.add(new Register("R0"));
        this.regs.add(new Register("R1"));
        this.regs.add(new Register("R2"));
        this.regs.add(new Register("R3"));
        this.regs.add(new Register("G"));
        this.regs.add(new Register("PC"));
    }

    public void init() throws Exception {
        byte b = 0;
        this.setRegValue("R0", b);
        this.setRegValue("R1", b);
        this.setRegValue("R2", b);
        this.setRegValue("R3", b);
        this.setRegValue("G", b);
        this.setRegValue("PC", b);
    }

    public byte getRegValue(String regname) throws Exception {
        int loop = 0;
        while (loop < this.regs.size()) {
            Register reg = this.regs.get(loop);
            if (regname.compareToIgnoreCase(reg.name) == 0) {
                return reg.value;
            }
            ++loop;
        }
        throw new Exception("\u975e\u6cd5\u7684\u5bc4\u5b58\u5668\u540d\u79f0");
    }

    public void setRegValue(String regname, byte value) throws Exception {
        int loop = 0;
        while (loop < this.regs.size()) {
            Register reg = this.regs.get(loop);
            if (regname.compareToIgnoreCase(reg.name) == 0) {
                reg.value = value;
                return;
            }
            ++loop;
        }
        throw new Exception("\u975e\u6cd5\u7684\u5bc4\u5b58\u5668\u540d\u79f0");
    }
}

