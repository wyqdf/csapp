/*
 * Decompiled with CFR 0.152.
 */
package edu.hn.vspm.Register;

public class Register {
    public String name;
    public byte value;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getValue() {
        return this.value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public Register(String name) {
        this.name = name;
        this.value = 0;
    }

    public String getString() {
        String str = "";
        str = String.valueOf(str) + "\u5bc4\u5b58\u5668\u540d\u79f0:\t\u001b[31;1m" + this.name + "\u001b[0m" + "\n";
        str = String.valueOf(str) + "\u5bc4\u5b58\u5668\u503c:\t\t\u001b[32;1m0x" + Integer.toHexString(this.value) + "\u001b[0m" + "\t\t";
        str = String.valueOf(str) + "\n";
        return str;
    }
}

