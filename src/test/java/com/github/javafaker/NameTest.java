package com.github.javafaker;

import com.github.javafaker.repeating.Repeat;
import org.junit.Test;

import static com.github.javafaker.matchers.MatchesRegularExpression.matchesRegularExpression;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.Matchers.isIn;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.List;


public class NameTest  extends AbstractFakerTest{

    @Test
    public void testName() {
        assertThat(faker.name().name(), matchesRegularExpression("([\\w']+\\.?( )?){2,3}"));
        List<String> allNames = faker.name().name(true);
        List<String> oneName = faker.name().name(false);
        assertThat(oneName.size(), lessThan(allNames.size()));
        assertThat(oneName.size(), equalTo(1));
    }

    @Test
    public void testNameWithMiddle() {
        assertThat(faker.name().nameWithMiddle(), matchesRegularExpression("([\\w']+\\.?( )?){3,4}"));
        List<String> allNames = faker.name().nameWithMiddle(true);
        List<String> oneName = faker.name().nameWithMiddle(false);
        assertThat(oneName.size(), lessThan(allNames.size()));
        assertThat(oneName.size(), equalTo(1));
    }

    @Test @Repeat(times = 10)
    public void testNameWithMiddleDoesNotHaveRepeatedName() {
        String nameWithMiddle = faker.name().nameWithMiddle();
        String[] splitNames = nameWithMiddle.split(" ");
        String firstName = splitNames[0];
        String middleName = splitNames[1];
        assertThat(firstName, not(equalTo(middleName)));
    }

    @Test
    public void testFullName() {
        assertThat(faker.name().fullName(), matchesRegularExpression("([\\w']+\\.?( )?){2,4}"));
        List<String> allNames = faker.name().fullName(true);
        List<String> oneName = faker.name().fullName(false);
        assertThat(oneName.size(), lessThan(allNames.size()));
        assertThat(oneName.size(), equalTo(1));
    }

    @Test
    public void testFirstName() {
        assertThat(faker.name().firstName(), matchesRegularExpression("\\w+"));
        List<String> allNames = faker.name().firstName(true);
        List<String> oneName = faker.name().firstName(false);
        assertThat(oneName.size(), lessThan(allNames.size()));
        assertThat(oneName.size(), equalTo(1));
        assertThat(faker.name().firstName(), isIn(allNames));
    }

    @Test
    public void testLastName() {
        assertThat(faker.name().lastName(), matchesRegularExpression("[A-Za-z']+"));
        List<String> allNames = faker.name().lastName(true);
        List<String> oneName = faker.name().lastName(false);
        assertThat(oneName.size(), lessThan(allNames.size()));
        assertThat(oneName.size(), equalTo(1));
        assertThat(faker.name().lastName(), isIn(allNames));
    }

    @Test
    public void testPrefix() {
        assertThat(faker.name().prefix(), matchesRegularExpression("\\w+\\.?"));
        List<String> allNames = faker.name().prefix(true);
        List<String> oneName = faker.name().prefix(false);
        assertThat(oneName.size(), lessThan(allNames.size()));
        assertThat(oneName.size(), equalTo(1));
        assertThat(faker.name().prefix(), isIn(allNames));
    }

    @Test
    public void testSuffix() {
        assertThat(faker.name().suffix(), matchesRegularExpression("\\w+\\.?"));
        List<String> allNames = faker.name().suffix(true);
        List<String> oneName = faker.name().suffix(false);
        assertThat(oneName.size(), lessThan(allNames.size()));
        assertThat(oneName.size(), equalTo(1));
        assertThat(faker.name().suffix(), isIn(allNames));
    }

    @Test
    public void testTitle() {
        assertThat(faker.name().title(), matchesRegularExpression("(\\w+\\.?( )?){3}"));
        List<String> allNames = faker.name().title(true);
        List<String> oneName = faker.name().title(false);
        assertThat(oneName.size(), lessThan(allNames.size()));
        assertThat(oneName.size(), equalTo(1));
        assertThat(faker.name().title(), isIn(allNames));
    }

    @Test
    public void testUsername() {
        assertThat(faker.name().username(), matchesRegularExpression("^(\\w+)\\.(\\w+)$"));
        List<String> allNames = faker.name().username(true);
        List<String> oneName = faker.name().username(false);
        assertThat(oneName.size(), lessThan(allNames.size()));
        assertThat(oneName.size(), equalTo(1));
    }

    @Test
    public void testUsernameWithSpaces() {
        final Name name = spy(new Name(faker));
        doReturn("Compound Name").when(name).firstName();
        doReturn(name).when(faker).name();
        assertThat(faker.name().username(), matchesRegularExpression("^(\\w+)\\.(\\w+)$"));
    }
    
    @Test
    public void testBloodGroup() {
        assertThat(faker.name().bloodGroup(), matchesRegularExpression("(A|B|AB|O)[+-]"));
        List<String> allBloodGroups = faker.name().bloodGroup(true);
        for (String group : allBloodGroups) {
            assertThat(group, matchesRegularExpression("(A|B|AB|O)[+-]"));
        }
    }

}
