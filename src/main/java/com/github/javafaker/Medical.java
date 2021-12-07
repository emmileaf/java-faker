package com.github.javafaker;

import java.util.Arrays;
import java.util.List;

public class Medical {

    private final Faker faker;

    protected Medical(Faker faker) {
        this.faker = faker;
    }

    public String medicineName() {
        return faker.fakeValuesService().resolve("medical.medicine_name", this, faker);
    }

    public List<String>  medicineName(Boolean returnAll) {
        if (returnAll) {
            return faker.fakeValuesService().resolveAll("medical.medicine_name", this, faker);
        } else {
            return Arrays.asList(medicineName());
        }
    }

    public String diseaseName() {
        return faker.fakeValuesService().resolve("medical.disease_name", this, faker);
    }

    public List<String>  diseaseName(Boolean returnAll) {
        if (returnAll) {
            return faker.fakeValuesService().resolveAll("medical.disease_name", this, faker);
        } else {
            return Arrays.asList(diseaseName());
        }
    }

    public String hospitalName() {
        return faker.fakeValuesService().resolve("medical.hospital_name", this, faker);
    }

    public List<String>  hospitalName(Boolean returnAll) {
        if (returnAll) {
            return faker.fakeValuesService().resolveAll("medical.hospital_name", this, faker);
        } else {
            return Arrays.asList(hospitalName());
        }
    }

    public String symptoms() {
        return faker.fakeValuesService().resolve("medical.symptoms", this, faker);
    }

    public List<String> symptoms(Boolean returnAll) {
        if (returnAll) {
            return faker.fakeValuesService().resolveAll("medical.symptoms", this, faker);
        } else {
            return Arrays.asList(symptoms());
        }
    }
}
