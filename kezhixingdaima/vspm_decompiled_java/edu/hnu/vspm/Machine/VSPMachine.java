/*
 * Decompiled with CFR 0.152.
 */
package edu.hnu.vspm.Machine;

import edu.hnu.vspm.Memory.Memory;
import edu.hnu.vspm.Register.RegFile;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class VSPMachine {
    public static final RegFile regfile = new RegFile();
    public static final Memory memory = new Memory();
    public int stauts;

    public void init() throws Exception {
        regfile.init();
        memory.init();
        this.stauts = 1;
    }

    public int Load(String strFilename) throws Exception {
        FileInputStream fin = new FileInputStream(strFilename);
        InputStreamReader reader = new InputStreamReader(fin);
        BufferedReader buffReader = new BufferedReader(reader);
        String strTmp = "";
        strTmp = buffReader.readLine();
        int iDataSize = Integer.parseInt(strTmp);
        if (iDataSize > 64) {
            throw new Exception("\u6570\u636e\u6bb5\u4e3a" + strTmp + ",\u8d85\u51fa\u9650\u5236\uff0c\u6700\u5927\u4e3a64\u5b57\u8282!");
        }
        regfile.setRegValue("PC", (byte)iDataSize);
        int index = iDataSize;
        while ((strTmp = buffReader.readLine()) != null) {
            if ((strTmp = strTmp.trim()).startsWith("#") || 0 == strTmp.length()) continue;
            memory.setMemoryValue((byte)index, strTmp);
            ++index;
        }
        buffReader.close();
        return index - iDataSize;
    }
}

