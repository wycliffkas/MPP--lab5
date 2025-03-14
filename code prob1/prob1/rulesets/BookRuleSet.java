package lesson5.labs.prob1.rulesets;

import java.awt.Component;
import java.awt.print.Book;
import java.util.regex.Pattern;

import lesson5.labs.prob1.gui.BookWindow;


/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Isbn must be numeric and consist of either 10 or 13 characters
 * 3. If Isbn has length 10, the first digit must be 0 or 1
 * 4. If Isbn has length 13, the first 3 digits must be either 978 or 979
 * 5. Price must be a floating point number with two decimal places 
 * 6. Price must be a number greater than 0.49.
 *
 */
public class BookRuleSet implements RuleSet {

	@Override
	public void applyRules(Component ob) throws RuleException {
		if (!(ob instanceof BookWindow)) {
			throw new RuleException("Invalid component");
		}

		BookWindow bookWindow = (BookWindow) ob;

		String isbn = bookWindow.getIsbnValue();
		String title = bookWindow.getTitleValue();
		String price = bookWindow.getPriceValue();

		if(isbn.isEmpty() || title.isEmpty() || price.isEmpty()) {
			throw new RuleException("All fields must be filled");
		}

		if(!Pattern.matches("\\d{10} | \\d{13}", isbn)) {
			throw new RuleException("ISBN must be numeric and consist of either 10 or 13 characters");
		}

		if(isbn.length() == 10 && !(isbn.startsWith("0") || isbn.startsWith("1"))){
			throw new RuleException("If ISBN has length 10, the first digit must be 0 or 1");
		}

		if(isbn.length() == 13 && !(isbn.startsWith("978") || isbn.startsWith("979"))){
			throw new RuleException("If ISBN has length 13, the first 3 digits must be either 978 or 979");
		}

		if(!Pattern.matches("\\d+\\.\\d{2}", price)) {
			throw new RuleException("Price must be a floating point number with two decimal places");
		}

		if(Double.parseDouble(price) <= 0.49) {
			throw new RuleException("Price must be greater than 0.49");
		}

	}

}
