package positronic.satisfiability.bitstringlookuptable;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;

public class BitStringLookupTableComposer extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = -8766776199474898061L;

	public BitStringLookupTableComposer(IBitString x, IBitString y, 
			IBitStringLookupTable table1, IBitStringLookupTable table2) throws Exception
	{
		IBitString z=new BitString(x.size());
		this.setClauses(new Conjunction(
				new BitStringLookupTabler(x,z,table1),
				new BitStringLookupTabler(z,y,table2)).getClauses());
	}
}
