package com.github.javafaker;

import org.junit.Test;

import static com.github.javafaker.matchers.IsStringWithContents.isStringWithContents;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.assertThat;

public class MedicalTest extends AbstractFakerTest {

    @Test
    public void testMedicineName() {
        assertThat(faker.medical().medicineName(), isStringWithContents());
        assertThat(faker.medical().medicineName(true).size(), greaterThan(1));
        assertThat(faker.medical().medicineName(), isIn(faker.medical().medicineName(true)));
    }

    @Test
    public void testDiseaseName() {
        assertThat(faker.medical().diseaseName(), isStringWithContents());
        assertThat(faker.medical().diseaseName(true).size(), greaterThan(1));
        assertThat(faker.medical().diseaseName(), isIn(faker.medical().diseaseName(true)));
    }

    @Test
    public void testHospitalName() {
        assertThat(faker.medical().hospitalName(), isStringWithContents());
        assertThat(faker.medical().hospitalName(true).size(), greaterThan(1));
        assertThat(faker.medical().hospitalName(), isIn(faker.medical().hospitalName(true)));

    }

    @Test
    public void testSymptom() {
        assertThat(faker.medical().symptoms(), isStringWithContents());
        assertThat(faker.medical().symptoms(true).size(), greaterThan(1));
        assertThat(faker.medical().symptoms(), isIn(faker.medical().symptoms(true)));
    }


}