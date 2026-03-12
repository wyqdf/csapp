/*
 * Decompiled with CFR 0.152.
 */
package edu.hn.vspm.Instruction;

import edu.hn.vspm.Instruction.Instruction;
import edu.hn.vspm.Machine.VSPMachine;
import java.util.Scanner;

public class IN
extends Instruction {
    private final String m_destination;
    private final String m_source;

    public IN(VSPMachine m, String destination, String source) {
        super(m);
        this.m_destination = destination;
        this.m_source = source;
    }

    @Override
    public void run() throws Exception {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        try {
            byte v = (byte)Integer.parseInt(s);
            byte oldv = VSPMachine.regfile.getRegValue(this.m_destination);
            VSPMachine.regfile.setRegValue(this.m_destination, v);
            byte iPC = VSPMachine.regfile.getRegValue("PC");
            VSPMachine.regfile.setRegValue("PC", (byte)(iPC + 1));
        }
        catch (Exception e) {
            System.out.println("\u8f93\u5165\u7684\u53c2\u6570\u683c\u5f0f\u9519\u8bef!\u8bf7\u91cd\u65b0\u8f93\u5165...");
        }
    }

    @Override
    public String getString() {
        return String.format("in \u001b[95;1m %s \u001b[0m", this.m_destination);
    }
}

