package com.codurance;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class TestExample {

    @Test
    void this_is_an_example() {
        assertThat(true ).isEqualTo(true);
    }

    @Test
    void accountServiceTest()
    {
//        Given a client makes a deposit of 1000 on 10-01-2012
//        And a deposit of 2000 on 13-01-2012
//        And a withdrawal of 500 on 14-01-2012
//        When they print their bank statement
//        Then they would see:
//
//        Date       | Amount | Balance
//        14/01/2012 | -500   | 2500
//        13/01/2012 | 2000   | 3000
//        10/01/2012 | 1000   | 1000

        // Arrange
        Printer printerMock = Mockito.mock(Printer.class);
        AccountService sut = new Account(printerMock);
        sut.deposit(1000); // 1000 on 10-01-2012
        sut.deposit(2000); // 2000 on 13-01-2012
        sut.withdraw(500); // 500 on 14-01-2012

        // Act
        sut.printStatement();

        // Assert
        Mockito.inOrder(printerMock);
        Mockito.verify(printerMock).printLine("Date | Amount | Balance");
        Mockito.verify(printerMock).printLine("14/01/2012 | -500   | 2500");
        Mockito.verify(printerMock).printLine("13/01/2012 | 2000   | 3000");
        Mockito.verify(printerMock).printLine("10/01/2012 | 1000   | 1000");

        }
}
