package positronic.satisfiability.bitstringlookuptable;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.BitStringUnequalizer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;

public class BitStringLookupTableDifferencer extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = -7454223596908326832L;

	public BitStringLookupTableDifferencer(IBitString X,IBitString Y,
			IBitStringLookupTable table1, IBitStringLookupTable table2) throws Exception
	{
		IBitString Z=new BitString(X.size());
		this.setClauses(new Conjunction(
				new BitStringLookupTabler(X,Y,table1),
				new BitStringLookupTabler(X,Z,table2),
				new BitStringUnequalizer(Y,Z)
		).getClauses());
	}
	
	public BitStringLookupTableDifferencer(IBitString X,
			IBitStringLookupTable table1, IBitStringLookupTable table2) throws Exception
	{
		this(X,new BitString(X.size()),table1,table2);
	}
	
	public BitStringLookupTableDifferencer(
			IBitStringLookupTable table1, 
			IBitStringLookupTable table2) throws Exception
	{
		this(new BitString(table1.getKey(0).size()),
				new BitString(table1.getEntry(0).size()),
				table1,table2);
	}
}
