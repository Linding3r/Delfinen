package entities;

import main.Date;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void testJuniorSubscription() {

        //arrange
        Date date = new Date();
        date.setDate("06/10/2020");
        Member member = new Member(date,4,"Ole","Hej",false,2);

        //act
        int subscription = member.subscription();

        //assert
        assertEquals(1200,subscription);

    }


}