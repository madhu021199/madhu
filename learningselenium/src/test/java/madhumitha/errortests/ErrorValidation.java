package madhumitha.errortests;

import org.testng.Assert;
import org.testng.annotations.Test;


import madhumitha.testcomponents.BaseTest;

public class ErrorValidation extends BaseTest {
	
	//@SuppressWarnings("deprecation")
	@Test()
	public void submitOrder()
	{
		lp.loginPage("abcd@gmail.com","Ruvik@0211");
	Assert.assertEquals(lp.getErrorMsg(),"Incorrect email or password.");
	}

}
