package com.service;

import org.springframework.stereotype.Service;

import com.dto.Corona;
import com.dto.Person;
import com.enums.Country;

@Service
public class Detect {
	
	public String detectCorona(Person person) {

		float sum = 0;

		if (person.getAge() > 50)
			sum += Corona.getAgeImpactPercentage() * person.getAge() - (person.getAge() - 1);

		if (person.getGender().equalsIgnoreCase("male")) // male
			sum += Corona.getGenderImpactPercentage();
		else if (person.getGender().equalsIgnoreCase("female")) // female
			sum += Corona.getGenderImpactPercentage() / 2;

		for (Country.countryList dng : Corona.getDangerCountry()) {
			if (person.getNationality().equals(dng)) {
				sum += Corona.getNationalityImpactPercentage();
				break;
			}
		}

		if (person.getFeverDegree() > 99.5)
			sum += Corona.getFeverDegreeImpactPercentage();

		if (person.isCough())
			sum += Corona.getCoughImpactPercentage();

		if (person.isFetigue())
			sum += Corona.getFetigueImpactPercentage();

		if (person.isCoughingUpSputum())
			sum += Corona.getCoughingUpSputumImpactPercentage();

		if (person.isShortnessOfBreath())
			sum += Corona.getShortnessOfBreathImpactPercentage();

		if (person.isBoneOrJointPain())
			sum += Corona.getBoneOrJointPainImpactPercentage();

		if (person.isHeadache())
			sum += Corona.getHeadacheImpactPercentage();

		if (person.isSoreThroat())
			sum += Corona.getSoreThroatImpactPercentage();

		if (person.isChills())
			sum += Corona.getChillsImpactPercentage();

		if (person.isNauseaOrVomiting())
			sum += Corona.getNauseaOrVomitingImpactPercentage();

		if (person.isStuffyNose())
			sum += Corona.getStuffyNoseImpactPercentage();

		if (person.isSpecialDiseases())
			sum += Corona.getDiarrheaImpactPercentage();

		if (person.isDiarrhea())
			sum += Corona.getSpecialDiseasesImpactPercentage();

		String result = "";
		result += String.valueOf(sum);
		result += " of ";
		result += String.valueOf(Corona.getSumImpactPercentage());
		result += " : (";
		result += Math.round(sum / Corona.getSumImpactPercentage() * 100);
		result += "% probability positive)";

		return result;
	}

}
