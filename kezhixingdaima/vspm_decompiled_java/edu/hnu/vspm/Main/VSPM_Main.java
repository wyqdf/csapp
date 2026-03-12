/*
 * Decompiled with CFR 0.152.
 */
package edu.hnu.vspm.Main;

import edu.hnu.vspm.Machine.VSPMachine;
import edu.hnu.vspm.utils.StaticMethod;
import java.util.HexFormat;
import java.util.Scanner;

public class VSPM_Main {
    /*
     * Unable to fully structure code
     */
    public static void main(String[] args) throws Exception {
        System.out.println("\u001b[94;1mVSPM-\u975e\u5e38\u7b80\u5355\u539f\u578b\u673a\t1.0");
        System.out.println("\u001b[91;1mVSPM \u001b[0m start ...");
        System.out.println("\u001b[91;1mVSPM \u001b[0m info:");
        System.out.println("\t\u5730\u5740\u4f4d\u6570\uff1a\u001b[1m 8 \u001b[0m bit\uff0c\u5171 \u001b[1m 256 \u001b[0m \u5b57\u8282");
        System.out.println("\t\u001b[1m 6 \u001b[0m \u4e2a\u5bc4\u5b58\u5668\uff1a\u001b[1mR0~R3,G,PC  \u001b[0m");
        m = new VSPMachine();
        m.init();
        System.out.println("\u521d\u59cb\u5316\u5185\u5b58......\t\u001b[35;1mOK!\u001b[0m");
        System.out.println("\u521d\u59cb\u5316\u5bc4\u5b58\u5668......\t\u001b[35;1mOK!\u001b[0m");
        if (0 == args.length) {
            System.out.println("\u6307\u4ee4\u6587\u4ef6\u7f3a\u5931\uff0c\u65e0\u6cd5\u88c5\u8f7d\u6307\u4ee4\uff01");
            return;
        }
        i = m.Load(args[0]);
        System.out.println("\u5206\u914d\u6570\u636e\u6bb5......\t\u001b[35;1mOK!\u001b[0m");
        System.out.println("\t\u6570\u636e\u6bb5\u5927\u5c0f\u4e3a\uff1a\u001b[1m" + VSPMachine.regfile.getRegValue("PC") + "\u001b[0m\u4e2a\u5b57\u8282,\u001b[1m0000 0000 ~ " + StaticMethod.get8BitString(VSPMachine.regfile.getRegValue("PC")) + "\u001b[0m");
        System.out.println("\u88c5\u8f7d\u6307\u4ee4......\t\u001b[35;1mOK!\u001b[0m");
        System.out.println("\t\u5171\u001b[1m" + i + "\u001b[0m\u6761\u6307\u4ee4");
        System.out.println("\u51c6\u5907\u6267\u884c\u6307\u4ee4,\u7b2c\u4e00\u6761\u6307\u4ee4\u6240\u5728\u5730\u5740\u53ca\u6307\u4ee4\u5185\u5bb9\u4e3a:");
        System.out.println("\t\u001b[0;37;34m" + StaticMethod.get8BitString(VSPMachine.regfile.getRegValue("PC")) + "\u001b[0m\t\t" + VSPMachine.memory.getMemoryValue(VSPMachine.regfile.getRegValue("PC")));
        hex = HexFormat.of();
        scanner = new Scanner(System.in);
        inst = null;
        block4: while (true) lbl-1000:
        // 11 sources

        {
            if (0 == m.stauts) {
                System.out.println("\u001b[91;1m\u7a0b\u5e8f\u6267\u884c\u7ed3\u675f\uff0c\u539f\u578b\u673a\u505c\u673a\u3002\u001b[0m");
                break;
            }
            System.out.print("\u001b[91;1mVM> \u001b[0m");
            cmd = scanner.nextLine();
            cmd = cmd.trim();
            if (0 == cmd.compareToIgnoreCase("q") || 0 == cmd.compareToIgnoreCase("quit")) {
                System.out.println("\u539f\u578b\u673a\u9000\u51fa");
                break;
            }
            if (0 == cmd.compareToIgnoreCase("h") || 0 == cmd.compareToIgnoreCase("help")) {
                System.out.println("\t\u001b[34;1mhelp or h\t \u5e2e\u52a9\u001b[0m");
                System.out.println("\t\u001b[34;1msi (N)\t\t \u6267\u884c\u4e00\u6761\u6216\u591a\u6761\u6307\u4ee4\u001b[0m");
                System.out.println("\t\u001b[34;1mc\t\t \u8fde\u7eed\u6267\u884c\u591a\u6761\u6307\u4ee4\u76f4\u5230\u7a0b\u5e8f\u7ed3\u675f\u001b[0m");
                System.out.println("\t\u001b[34;1mi r\t\t \u67e5\u770b\u5bc4\u5b58\u5668\u503c\u001b[0m");
                System.out.println("\t\u001b[34;1mx (N) address\t \u67e5\u770b\u5185\u5b58\u7a7a\u95f4\u001b[0m");
                System.out.println("\t\u001b[34;1mq or quit\t \u9000\u51fa\u001b[0m");
                continue;
            }
            if (0 == cmd.compareToIgnoreCase("i r")) {
                System.out.println("\t\u001b[32;1mR0\t\u001b[0m\u001b[34;1m" + VSPMachine.regfile.getRegValue("R0") + "\t0x" + hex.toHexDigits(VSPMachine.regfile.getRegValue("R0")) + "\u001b[0m");
                System.out.println("\t\u001b[32;1mR1\t\u001b[0m\u001b[34;1m" + VSPMachine.regfile.getRegValue("R1") + "\t0x" + hex.toHexDigits(VSPMachine.regfile.getRegValue("R1")) + "\u001b[0m");
                System.out.println("\t\u001b[32;1mR2\t\u001b[0m\u001b[34;1m" + VSPMachine.regfile.getRegValue("R2") + "\t0x" + hex.toHexDigits(VSPMachine.regfile.getRegValue("R2")) + "\u001b[0m");
                System.out.println("\t\u001b[32;1mR3\t\u001b[0m\u001b[34;1m" + VSPMachine.regfile.getRegValue("R3") + "\t0x" + hex.toHexDigits(VSPMachine.regfile.getRegValue("R3")) + "\u001b[0m");
                System.out.println("\t\u001b[32;1mG\t\u001b[0m\u001b[34;1m" + VSPMachine.regfile.getRegValue("G") + "\t0x" + hex.toHexDigits(VSPMachine.regfile.getRegValue("G")) + "\u001b[0m");
                System.out.println("\t\u001b[32;1mPC\t\u001b[0m\u001b[34;1m" + VSPMachine.regfile.getRegValue("PC") + "\t0x" + hex.toHexDigits(VSPMachine.regfile.getRegValue("PC")) + "\u001b[0m");
                continue;
            }
            if (cmd.startsWith("x")) {
                strs = cmd.split(" ");
                if (3 != strs.length) {
                    System.out.println("\u65e0\u6cd5\u8bc6\u522b\u7684\u547d\u4ee4");
                }
                if (0 != strs[0].compareToIgnoreCase("x")) {
                    System.out.println("\u65e0\u6cd5\u8bc6\u522b\u7684\u547d\u4ee4");
                }
                try {
                    i = Integer.parseInt(strs[1]);
                    loop = j = Integer.parseInt(strs[2], 2);
                    while (true) {
                        if (loop >= i + j) ** GOTO lbl-1000
                        str = VSPMachine.memory.getMemoryValue((byte)loop);
                        if ("" == str) {
                            str = "0";
                        }
                        System.out.println("\t\u001b[32;1m" + StaticMethod.get8BitString(loop) + "\u001b[0m\t\t\u001b[34;1m" + str + "\u001b[0m");
                        ++loop;
                    }
                }
                catch (Exception e) {
                    System.out.println("\u65e0\u6cd5\u8bc6\u522b\u7684\u547d\u4ee4");
                }
                continue;
            }
            if (cmd.startsWith("si")) {
                strs = cmd.split(" ");
                if (1 == strs.length) {
                    inst = StaticMethod.getInst(m, VSPMachine.memory.getMemoryValue(VSPMachine.regfile.getRegValue("PC")));
                    inst.run();
                    System.out.println("\t\u001b[0;37;34m" + StaticMethod.get8BitString(VSPMachine.regfile.getRegValue("PC")) + "\u001b[0m\t\t" + VSPMachine.memory.getMemoryValue(VSPMachine.regfile.getRegValue("PC")));
                    continue;
                }
                if (2 == strs.length) {
                    try {
                        i = Integer.parseInt(strs[1]);
                        for (loop = 0; loop < i; ++loop) {
                            inst = StaticMethod.getInst(m, VSPMachine.memory.getMemoryValue(VSPMachine.regfile.getRegValue("PC")));
                            inst.run();
                        }
                        System.out.println("\t\u001b[0;37;34m" + StaticMethod.get8BitString(VSPMachine.regfile.getRegValue("PC")) + "\u001b[0m\t\t" + VSPMachine.memory.getMemoryValue(VSPMachine.regfile.getRegValue("PC")));
                    }
                    catch (Exception e) {
                        System.out.println("\u65e0\u6cd5\u8bc6\u522b\u7684\u547d\u4ee4");
                    }
                    continue;
                }
                System.out.println("\u65e0\u6cd5\u8bc6\u522b\u7684\u547d\u4ee4");
                continue;
            }
            if (0 == cmd.compareToIgnoreCase("c")) {
                while (true) {
                    if (0 == m.stauts) continue block4;
                    inst = StaticMethod.getInst(m, VSPMachine.memory.getMemoryValue(VSPMachine.regfile.getRegValue("PC")));
                    inst.run();
                }
            }
            System.out.println("\u65e0\u6cd5\u8bc6\u522b\u7684\u547d\u4ee4");
        }
    }
}

