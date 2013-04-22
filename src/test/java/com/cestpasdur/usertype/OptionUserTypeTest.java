package com.cestpasdur.usertype;

import fj.data.Option;
import org.junit.Test;

import java.sql.PreparedStatement;

import static org.mockito.Mockito.*;

public class OptionUserTypeTest {


    public static final String EXPECTED_EMAIL = "john.doe@gmail.com";
    public static final int INDEX = 1;
    private PreparedStatement preparedStatementMock = mock(PreparedStatement.class, RETURNS_MOCKS);

    @Test
    public void testNullSafeSet() throws Exception {

        Object o = Option.fromString(EXPECTED_EMAIL);

        OptionUserType optionUserType = new OptionUserType();
        optionUserType.nullSafeSet(preparedStatementMock, o, INDEX);

        verify(preparedStatementMock).setString(1, EXPECTED_EMAIL);

    }
}
