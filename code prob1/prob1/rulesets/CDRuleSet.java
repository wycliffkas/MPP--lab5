package lesson5.labs.prob1.rulesets;

import java.awt.Component;
import java.util.regex.Pattern;

import lesson5.labs.prob1.gui.CDWindow;

/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. Price must be a floating point number with two decimal places 
 *  3. Price must be a number greater than 0.49. 
 */

public class CDRuleSet implements RuleSet {

	@Override
	public void applyRules(Component ob) throws RuleException {
		if(!(ob instanceof CDWindow)) {
			throw new RuleException("Invalid object");
		}

		CDWindow cdwindow = (CDWindow) ob;

		String artist = cdwindow.getArtistValue();
		String title = cdwindow.getTitleValue();
		String price = cdwindow.getPriceValue();

		if(artist.isEmpty() || title.isEmpty() || price.isEmpty()) {
			throw new RuleException("All fields must be nonempty");
		}

		if(!Pattern.matches("\\d+\\.\\d{2}", price)) {
			throw new RuleException("Price must be a floating point number with two decimal places");
		}

		if(Double.parseDouble(price) <= 0.49) {
			throw new RuleException("Price must be greater than 0.49");
		}

		
	}
	
}
