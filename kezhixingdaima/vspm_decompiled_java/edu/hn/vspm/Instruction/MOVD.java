/*
 * Decompiled with CFR 0.152.
 */
package edu.hn.vspm.Instruction;

import edu.hn.vspm.Instruction.Instruction;
import edu.hn.vspm.Machine.VSPMachine;

public class MOVD
extends Instruction {
    private final String m_destination;
    private final String m_source;

    public MOVD(VSPMachine m, String destination, String source) {
        super(m);
        this.m_destination = destination;
        this.m_source = source;
    }

    @Override
    public void run() throws Exception {
        byte v = VSPMachine.regfile.getRegValue("PC");
        byte oldv = VSPMachine.regfile.getRegValue("R3");
        VSPMachine.regfile.setRegValue("R3", v);
        byte iPC = VSPMachine.regfile.getRegValue("PC");
        VSPMachine.regfile.setRegValue("PC", (byte)(iPC + 1));
    }

    @Override
    public String getString() {
        return String.format("movd \u001b[95;1m R3 \u001b[0m, \u001b[93;1m PC \u001b[0m", new Object[0]);
    }
}

