package model;

import java.util.Random;

public class Die {
	
	private int value;
	
	/**
	 * @param value
	 */
	public Die() {
		setRandom();
	}

	/**
	 * @param value
	 */
	public Die(int value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(int value) {
		this.value = value;
	}
	
	public void setRandom() {
		Random random = new Random();
		this.value = random.nextInt(6) + 1;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Die [value=" + value + "]";
	}
	

}
