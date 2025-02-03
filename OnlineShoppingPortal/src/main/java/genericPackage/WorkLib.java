package genericPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class WorkLib {

	//To Handle Static DropDown
	
	public void selectByVisibleTextMethod(WebElement dropdown, String VisibleText)
	{
		Select sel = new Select(dropdown);
		sel.selectByVisibleText(VisibleText);
		
		
	}
	public void selectByValueMethod(WebElement dropdown, String value)
	{
		Select sel = new Select(dropdown);
		sel.selectByValue(value);
		
		
	}
	public void selectByIndexMethod(WebElement dropdown, int index)
	{
		Select sel = new Select(dropdown);
		sel.selectByIndex(index);
		
		
	}
	
}
