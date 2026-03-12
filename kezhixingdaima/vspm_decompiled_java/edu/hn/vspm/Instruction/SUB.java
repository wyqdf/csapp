/*
 * Decompiled with CFR 0.152.
 */
package edu.hn.vspm.Instruction;

import edu.hn.vspm.Instruction.Instruction;
import edu.hn.vspm.Machine.VSPMachine;

public class SUB
extends Instruction {
    private final String m_destination;
    private final String m_source;

    public SUB(VSPMachine m, String destination, String source) {
        super(m);
        this.m_destination = destination;
        this.m_source = source;
    }

    @Override
    public void run() throws Exception {
        byte v1 = VSPMachine.regfile.getRegValue(this.m_source);
        byte v2 = VSPMachine.regfile.getRegValue(this.m_destination);
        int i = v2 - v1;
        i <<= 24;
        byte result = (byte)(i >>>= 24);
        VSPMachine.regfile.setRegValue(this.m_destination, result);
        byte g = v2 > v1 ? (byte)1 : 0;
        VSPMachine.regfile.setRegValue("G", g);
        byte iPC = VSPMachine.regfile.getRegValue("PC");
        VSPMachine.regfile.setRegValue("PC", (byte)(iPC + 1));
    }

    @Override
    public String getString() {
        return String.format("add \u001b[95;1m %s \u001b[0m, \u001b[93;1m %s \u001b[0m", this.m_destination, this.m_source);
    }
}

