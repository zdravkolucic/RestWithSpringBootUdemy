package de.zlucic.converter;

import de.zlucic.converter.mock.MockPerson;
import de.zlucic.data.model.Person;
import de.zlucic.data.vo.PersonVO;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DozerConverterTest {
    private static MockPerson inputObject;

    @BeforeAll // until JUnit4 this was @Before
    static void setup() { // must be static!
        inputObject = new MockPerson();
    }

    @Test
    @DisplayName("Parse Entity to VO test")
    void parseEntityToVOTest() {
        PersonVO output = DozerConverter.parseObject( inputObject.mockEntity(), PersonVO.class);

        Assertions.assertAll(
                () -> assertEquals( Long.valueOf( 0L), output.getId()),
                () -> assertEquals( "Street_0; City_0", output.getAddress()),
                () -> assertEquals( "Firstname_0", output.getFirstName()),
                () -> assertEquals( "Lastname_0", output.getLastName()),
                () -> assertEquals( "Male", output.getGender())
        );
    }

    @Test
    @DisplayName("Parse EntityList to VO test")
    void parseEntityListToVoTest() {
        List<Person> personMock = inputObject.mockEntityList(14);
        List<PersonVO> outputList = DozerConverter.parseListObject( personMock, PersonVO.class);


        PersonVO test1 = outputList.get(1);
        Assertions.assertAll(
                () -> assertEquals(Long.valueOf(1L), outputList.get(1).getId()),
                () -> assertEquals("Street_1; City_1", outputList.get(1).getAddress()),
                () -> assertEquals("Firstname_1", outputList.get(1).getFirstName()),
                () -> assertEquals("Lastname_1", outputList.get(1).getLastName()),
                () -> assertEquals("Female", outputList.get(1).getGender())
        );

        PersonVO test7 = outputList.get(6);
        Assertions.assertAll(
                () -> assertEquals(Long.valueOf(6L), outputList.get(6).getId()),
                () -> assertEquals("Street_6; City_6", outputList.get(6).getAddress()),
                () -> assertEquals("Firstname_6", outputList.get(6).getFirstName()),
                () -> assertEquals("Lastname_6", outputList.get(6).getLastName()),
                () -> assertEquals("Male", outputList.get(6).getGender())
        );
    }

    @Test
    @DisplayName("Parse VO to Entity test")
    void parseVOToEntityTest() {
        Person output = DozerConverter.parseObject( inputObject.mockVO(), Person.class);

        Assertions.assertAll(
                () -> assertEquals( Long.valueOf( 0L), output.getId()),
                () -> assertEquals( "Street_0; City_0", output.getAddress()),
                () -> assertEquals( "Firstname_0", output.getFirstName()),
                () -> assertEquals( "Lastname_0", output.getLastName()),
                () -> assertEquals( "Male", output.getGender())
        );
    }

    @Test
    @DisplayName("Parse VOList to EntityList test")
    void parseVOListToEntityTest() {
        List<Person> outputList = DozerConverter.parseListObject(inputObject.mockVOList(14), Person.class);


        Person test1 = outputList.get(1);
        Assertions.assertAll(
                () -> assertEquals(Long.valueOf(1L), outputList.get(1).getId()),
                () -> assertEquals("Street_1; City_1", outputList.get(1).getAddress()),
                () -> assertEquals("Firstname_1", outputList.get(1).getFirstName()),
                () -> assertEquals("Lastname_1", outputList.get(1).getLastName()),
                () -> assertEquals("Female", outputList.get(1).getGender())
        );

        Person test7 = outputList.get(6);
        Assertions.assertAll(
                () -> assertEquals(Long.valueOf(6L), outputList.get(6).getId()),
                () -> assertEquals("Street_6; City_6", outputList.get(6).getAddress()),
                () -> assertEquals("Firstname_6", outputList.get(6).getFirstName()),
                () -> assertEquals("Lastname_6", outputList.get(6).getLastName()),
                () -> assertEquals("Male", outputList.get(6).getGender())
        );
    }
}
