/*
 * Copyright (C) 2011-2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * This file is auto-generated. DO NOT MODIFY!
 * The source Renderscript file: C:\\Users\\User\\Desktop\\nature\\Application\\src\\main\\rs\\covnert.rs
 */

package com.example.android.camera2basic;

import android.renderscript.*;
import com.example.android.camera2basic.covnertBitCode;

/**
 * @hide
 */
public class ScriptC_covnert extends ScriptC {
    private static final String __rs_resource_name = "covnert";
    // Constructor
    public  ScriptC_covnert(RenderScript rs) {
        super(rs,
              __rs_resource_name,
              covnertBitCode.getBitCode32(),
              covnertBitCode.getBitCode64());
        __I32 = Element.I32(rs);
        __U8_4 = Element.U8_4(rs);
    }

    private Element __I32;
    private Element __U8_4;
    private FieldPacker __rs_fp_I32;
    private final static int mExportVarIdx_i = 0;
    private int mExportVar_i;
    public synchronized void set_i(int v) {
        setVar(mExportVarIdx_i, v);
        mExportVar_i = v;
    }

    public int get_i() {
        return mExportVar_i;
    }

    public Script.FieldID getFieldID_i() {
        return createFieldID(mExportVarIdx_i, null);
    }

    //private final static int mExportForEachIdx_root = 0;
    private final static int mExportForEachIdx_convertP = 1;
    public Script.KernelID getKernelID_convertP() {
        return createKernelID(mExportForEachIdx_convertP, 59, null, null);
    }

    public void forEach_convertP(Allocation ain, Allocation aout) {
        forEach_convertP(ain, aout, null);
    }

    public void forEach_convertP(Allocation ain, Allocation aout, Script.LaunchOptions sc) {
        // check ain
        if (!ain.getType().getElement().isCompatible(__U8_4)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        // check aout
        if (!aout.getType().getElement().isCompatible(__U8_4)) {
            throw new RSRuntimeException("Type mismatch with U8_4!");
        }
        Type t0, t1;        // Verify dimensions
        t0 = ain.getType();
        t1 = aout.getType();
        if ((t0.getCount() != t1.getCount()) ||
            (t0.getX() != t1.getX()) ||
            (t0.getY() != t1.getY()) ||
            (t0.getZ() != t1.getZ()) ||
            (t0.hasFaces()   != t1.hasFaces()) ||
            (t0.hasMipmaps() != t1.hasMipmaps())) {
            throw new RSRuntimeException("Dimension mismatch between parameters ain and aout!");
        }

        forEach(mExportForEachIdx_convertP, ain, aout, null, sc);
    }

}

