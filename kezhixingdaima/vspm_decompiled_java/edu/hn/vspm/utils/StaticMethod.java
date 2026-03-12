/*
 * Decompiled with CFR 0.152.
 */
package edu.hn.vspm.utils;

import edu.hn.vspm.Instruction.ADD;
import edu.hn.vspm.Instruction.HALT;
import edu.hn.vspm.Instruction.IN;
import edu.hn.vspm.Instruction.Instruction;
import edu.hn.vspm.Instruction.JG;
import edu.hn.vspm.Instruction.JMP;
import edu.hn.vspm.Instruction.MOVA;
import edu.hn.vspm.Instruction.MOVB;
import edu.hn.vspm.Instruction.MOVC;
import edu.hn.vspm.Instruction.MOVD;
import edu.hn.vspm.Instruction.MOVI;
import edu.hn.vspm.Instruction.OUT;
import edu.hn.vspm.Instruction.SUB;
import edu.hn.vspm.Machine.VSPMachine;

public class StaticMethod {
    public static String get8BitString(int i) throws Exception {
        String str = "";
        if (i > 127 || i < -128) {
            throw new Exception("\u6574\u6570\u8d85\u51fa\u8303\u56f4");
        }
        str = Integer.toBinaryString(i);
        int k = 8 - str.length();
        while (k > 0) {
            str = "0" + str;
            --k;
        }
        str = String.valueOf(str.substring(0, 4)) + " " + str.substring(4, 8);
        return str;
    }

    public static Instruction getInst(VSPMachine m, String name, String destination, String source) throws Exception {
        Instruction inst;
        if (name.compareToIgnoreCase("MOVA") == 0) {
            inst = new MOVA(m, destination, source);
        } else if (name.compareToIgnoreCase("MOVB") == 0) {
            inst = new MOVB(m, destination, source);
        } else if (name.compareToIgnoreCase("MOVC") == 0) {
            inst = new MOVC(m, destination, source);
        } else if (name.compareToIgnoreCase("MOVD") == 0) {
            inst = new MOVD(m, destination, source);
        } else if (name.compareToIgnoreCase("MOVI") == 0) {
            inst = new MOVI(m, destination, source);
        } else if (name.compareToIgnoreCase("ADD") == 0) {
            inst = new ADD(m, destination, source);
        } else if (name.compareToIgnoreCase("SUB") == 0) {
            inst = new SUB(m, destination, source);
        } else if (name.compareToIgnoreCase("JMP") == 0) {
            inst = new JMP(m, destination, source);
        } else if (name.compareToIgnoreCase("JG") == 0) {
            inst = new JG(m, destination, source);
        } else if (name.compareToIgnoreCase("IN") == 0) {
            inst = new IN(m, destination, source);
        } else if (name.compareToIgnoreCase("OUT") == 0) {
            inst = new OUT(m, destination, source);
        } else if (name.compareToIgnoreCase("HALT") == 0) {
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
                if (name.compareToIgnoreCase("IN") == 0) {
                    destination = substr;
                    source = "";
                    return StaticMethod.getInst(m, name, destination, source);
                } else if (name.compareToIgnoreCase("OUT") == 0) {
                    destination = "";
                    source = substr;
                    return StaticMethod.getInst(m, name, destination, source);
                } else {
                    if (name.compareToIgnoreCase("MOVI") != 0) throw new Exception("\u6307\u4ee4\u683c\u5f0f\u9519\u8bef");
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

