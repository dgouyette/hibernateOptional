package com.cestpasdur.usertype;

import java.sql.Types;

public class StringOptionType extends OptionUserType {


    @Override
    public int[] sqlTypes() {
        return new int[]{
                Types.VARCHAR
        };
    }

}
