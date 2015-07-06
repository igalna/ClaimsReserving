package claimsreversing;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor(staticName = "of")
@ToString
public class Product {

	@Getter
	private String product;
	@Getter
	private String originYear;
	@Getter
	private String developmentYear;
	@Getter
	private String incrementValue;
}