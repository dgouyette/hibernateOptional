package com.cestpasdur.usertype;


import fj.data.Option;
import org.apache.commons.lang.ObjectUtils;
import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class OptionUserType implements UserType {


    @Override
    public int[] sqlTypes() {
        return new int[]{
                Types.NULL
        };
    }

    @Override
    public Class returnedClass() {
        return Option.class;
    }

    @Override
    public boolean equals(Object o, Object o2) throws HibernateException {
        return ObjectUtils.equals(o, o2);

    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        assert (o != null);
        return o.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
        return Option.fromString(rs.getString(names[0]));
    }



    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index) throws SQLException {

        if (value != null) {
            if (value instanceof Option) {
                Option optionalValue = (Option) value;
                if (optionalValue.isSome()) {
                    System.out.println("SOME");
                    st.setString(index, optionalValue.some().toString());
                } else {
                    System.out.println("else Some");
                }

            } else {
                //TODO replace with Preconditions guava
                throw new IllegalArgumentException(value + " is not implemented");

            }
        } else {
            st.setString(index, null);

        }


    }

    @Override
    public Object deepCopy(Object o) throws HibernateException {
        return o;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object o) throws HibernateException {
        return (Serializable) o;
    }

    @Override
    public Object assemble(Serializable serializable, Object o) throws HibernateException {
        return serializable;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }
}
