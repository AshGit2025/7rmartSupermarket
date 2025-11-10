package utilities;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;

public class FakerUtility {

	public static Faker faker=new Faker();
	
	public static String getFirstname()
	{
		return faker.name().firstName();
	}
	
	public static String getPassword()
	{
		return faker.internet().password();
	}
	
	public static IdNumber getIdNumber()
	{
		return faker.idNumber();
	}
	
	public static String getEmailAddress()
	{
		return faker.internet().emailAddress();
	}
	public static Address getAddress()
	{
		return faker.address();
	}
}

