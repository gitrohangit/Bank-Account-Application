// An API which can be used to get the benchmark rate.

package bankaccountapp;

public interface IBaseRate {

	default double getBaseRate() {
		return 2.5;
	}
	
	
}
