package positronic.satisfiability.bitstringlookuptable;

import positronic.satisfiability.bitstring.BitString;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.elements.ProblemDenier;
import positronic.satisfiability.exceptions.BitStringLookupTableFixerException;

public class BitStringLookupTableNonselfcomposer extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = 3009232280743509982L;

	public BitStringLookupTableNonselfcomposer(IBitStringLookupTable table) throws Exception
	{
		if(table==null) 
			throw new BitStringLookupTableFixerException("A null IBitStringLookupTable was passed to a constructor.");
	    if(table.getLength()==0) 
	    	throw new BitStringLookupTableFixerException("An empty IBitStringLookupTable was passed to a constructor.");
	    IBitString X=new BitString(table.getEntry(0).size());
	    
	    IProblem res=new Conjunction(new BitStringLookupTableEntryer(X,table),
	    		new ProblemDenier(new BitStringLookupTableKeyer(X,table)));
	    this.setClauses(res.getClauses());
	}
}

