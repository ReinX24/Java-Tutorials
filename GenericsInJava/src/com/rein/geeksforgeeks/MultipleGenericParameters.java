package com.rein.geeksforgeeks;

public class MultipleGenericParameters<T, K> {

	T firstParameter;
	K secondParameter;

	public MultipleGenericParameters(T firstParameter, K secondParameter) {
		this.firstParameter = firstParameter;
		this.secondParameter = secondParameter;
	}

	public T getFirstParameter() {
		return firstParameter;
	}

	public void setFirstParameter(T firstParameter) {
		this.firstParameter = firstParameter;
	}

	public K getSecondParameter() {
		return secondParameter;
	}

	public void setSecondParameter(K secondParameter) {
		this.secondParameter = secondParameter;
	}

}
