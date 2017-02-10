package positronic.satisfiability.bitstringlookuptable;
/*
 * IBitStringLookupTable.java	1.0 09/06/08
 *
 * Copyright 2009 Positronic Software.
 *
 *
 */

import positronic.satisfiability.bitstring.IBitString;

public interface IBitStringLookupTable
{
	IBitString getEntry(int i);
	IBitString getKey(int i);
	int getLength();
	String getName();
}
