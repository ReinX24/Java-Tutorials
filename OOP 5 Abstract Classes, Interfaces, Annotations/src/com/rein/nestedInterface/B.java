package com.rein.nestedInterface;

public class B implements A.NestedInterface {

	@Override
	public boolean isOdd(int paraInt) {
		return paraInt % 2 != 0;
	}

}
