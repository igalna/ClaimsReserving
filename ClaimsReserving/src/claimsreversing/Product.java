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
	private Integer originYear;
	@Getter
	private Integer developmentYear;
	@Getter
	private Double incrementValue;
}
