package sayantan;

public class LimitsConfiguration {

	int minimum;
	int maximum;

	public LimitsConfiguration() {
		super();
	}

	public LimitsConfiguration(int minimum, int maximum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
}
