package com.johannes_mittendorfer.simpleobex.header;

import com.johannes_mittendorfer.simpleobex.header.templates.OBEXHeader;

public class LengthHeader extends OBEXHeader<Integer> {

    public LengthHeader(int length){
        super((byte) 0xc3, length);

        bytes.add((byte) (length >> 3*8));
        bytes.add((byte) (length >> 2*8));
        bytes.add((byte) (length >> 8));
        bytes.add((byte) length);
    }

    public String toString(){
        return "Length: " + value;
    }

    @Override
    public int getLength() {
        return 5;
    }
}
