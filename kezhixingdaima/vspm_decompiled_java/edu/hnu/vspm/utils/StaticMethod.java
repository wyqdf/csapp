/*
 * Decompiled with CFR 0.152.
 */
package edu.hnu.vspm.utils;

import edu.hnu.vspm.Instruction.ADD;
import edu.hnu.vspm.Instruction.HALT;
import edu.hnu.vspm.Instruction.IN;
import edu.hnu.vspm.Instruction.Instruction;
import edu.hnu.vspm.Instruction.JG;
import edu.hnu.vspm.Instruction.JMP;
import edu.hnu.vspm.Instruction.MOVA;
import edu.hnu.vspm.Instruction.MOVB;
import edu.hnu.vspm.Instruction.MOVC;
import edu.hnu.vspm.Instruction.MOVD;
import edu.hnu.vspm.Instruction.MOVI;
import edu.hnu.vspm.Instruction.OUT;
import edu.hnu.vspm.Instruction.SUB;
import edu.hnu.vspm.Machine.VSPMachine;

public class StaticMethod {
    public static String get8BitString(int i) throws Exception {
        Object str = "";
        if (i > 127 || i < -128) {
            throw new Exception("\u6574\u6570\u8d85\u51fa\u8303\u56f4");
        }
        str = Integer.toBinaryString(i);
        for (int k = 8 - ((String)str).length(); k > 0; --k) {
            str = "0" + (String)str;
        }
        str = ((String)str).substring(0, 4) + " " + ((String)str).substring(4, 8);
        return str;
    }

    public static Instruction getInst(VSPMachine m, String name, String destination, String source) throws Exception {
        Instruction inst;
        if (0 == name.compareToIgnoreCase("MOVA")) {
            inst = new MOVA(m, destination, source);
        } else if (0 == name.compareToIgnoreCase("MOVB")) {
            inst = new MOVB(m, destination, source);
        } else if (0 == name.compareToIgnoreCase("MOVC")) {
            inst = new MOVC(m, destination, source);
        } else if (0 == name.compareToIgnoreCase("MOVD")) {
            inst = new MOVD(m, destination, source);
        } else if (0 == name.compareToIgnoreCase("MOVI")) {
            inst = new MOVI(m, destination, source);
        } else if (0 == name.compareToIgnoreCase("ADD")) {
            inst = new ADD(m, destination, source);
        } else if (0 == name.compareToIgnoreCase("SUB")) {
            inst = new SUB(m, destination, source);
        } else if (0 == name.compareToIgnoreCase("JMP")) {
            inst = new JMP(m, destination, source);
        } else if (0 == name.compareToIgnoreCase("JG")) {
            inst = new JG(m, destination, source);
        } else if (0 == name.compareToIgnoreCase("IN")) {
            inst = new IN(m, destination, source);
        } else if (0 == name.compareToIgnoreCase("OUT")) {
            inst = new OUT(m, destination, source);
        } else if (0 == name.compareToIgnoreCase("HALT")) {
            inst = new HALT(m, destination, source);
        } else {
            throw new Exception("\u6307\u4ee4\u9519\u8bef");
        }
        return inst;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Instruction getInst(VSPMachine m, String inststr) throws Exception {
        String source;
        String destination;
        String name;
        Object inst = null;
        int index = inststr.indexOf("#");
        String str = index > 0 ? inststr.substring(0, inststr.indexOf("#") - 1) : inststr;
        index = (str = str.trim()).indexOf(" ");
        if (index < 0) {
            name = str;
            destination = "";
            source = "";
            return StaticMethod.getInst(m, name, destination, source);
        } else {
            name = str.substring(0, index);
            String substr = str.substring(index, str.length());
            int index2 = (substr = substr.trim()).indexOf(",");
            if (index2 < 0) {
                if (0 == name.compareToIgnoreCase("IN")) {
                    destination = substr;
                    source = "";
                    return StaticMethod.getInst(m, name, destination, source);
                } else if (0 == name.compareToIgnoreCase("OUT")) {
                    destination = "";
                    source = substr;
                    return StaticMethod.getInst(m, name, destination, source);
                } else {
                    if (0 != name.compareToIgnoreCase("MOVI")) throw new Exception("\u6307\u4ee4\u683c\u5f0f\u9519\u8bef");
                    destination = "R0";
                    source = substr;
                }
                return StaticMethod.getInst(m, name, destination, source);
            } else {
                destination = substr.substring(0, index2);
                destination = destination.trim();
                source = substr.substring(index2 + 1, substr.length());
                source = source.trim();
            }
        }
        return StaticMethod.getInst(m, name, destination, source);
    }
}

