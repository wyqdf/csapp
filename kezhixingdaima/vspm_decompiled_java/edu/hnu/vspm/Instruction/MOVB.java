/*
 * Decompiled with CFR 0.152.
 */
package edu.hnu.vspm.Instruction;

import edu.hnu.vspm.Instruction.Instruction;
import edu.hnu.vspm.Machine.VSPMachine;

public class MOVB
extends Instruction {
    private final String m_destination;
    private final String m_source;

    public MOVB(VSPMachine m, String destination, String source) {
        super(m);
        this.m_destination = destination;
        this.m_source = source;
    }

    @Override
    public void run() throws Exception {
        byte v = VSPMachine.regfile.getRegValue(this.m_source);
        byte address = VSPMachine.regfile.getRegValue(this.m_destination);
        byte oldv = (byte)Integer.parseInt(VSPMachine.memory.getMemoryValue(address));
        VSPMachine.memory.setMemoryValue(address, v);
        byte iPC = VSPMachine.regfile.getRegValue("PC");
        VSPMachine.regfile.setRegValue("PC", (byte)(iPC + 1));
    }

    @Override
    public String getString() {
        return String.format("movb \u001b[95;1m %s \u001b[0m, \u001b[93;1m %s \u001b[0m", this.m_destination, this.m_source);
    }
}

