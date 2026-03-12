/*
 * Decompiled with CFR 0.152.
 */
package edu.hn.vspm.Instruction;

import edu.hn.vspm.Instruction.Instruction;
import edu.hn.vspm.Machine.VSPMachine;

public class MOVC
extends Instruction {
    private final String m_destination;
    private final String m_source;

    public MOVC(VSPMachine m, String destination, String source) {
        super(m);
        this.m_destination = destination;
        this.m_source = source;
    }

    @Override
    public void run() throws Exception {
        byte address = VSPMachine.regfile.getRegValue(this.m_source);
        byte oldv = VSPMachine.regfile.getRegValue(this.m_destination);
        byte v = (byte)Integer.parseInt(VSPMachine.memory.getMemoryValue(address));
        VSPMachine.regfile.setRegValue(this.m_destination, v);
        byte iPC = VSPMachine.regfile.getRegValue("PC");
        VSPMachine.regfile.setRegValue("PC", (byte)(iPC + 1));
    }

    @Override
    public String getString() {
        return String.format("movc \u001b[95;1m %s \u001b[0m, \u001b[93;1m %s \u001b[0m", this.m_destination, this.m_source);
    }
}

