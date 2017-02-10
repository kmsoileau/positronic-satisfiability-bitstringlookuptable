package positronic.satisfiability.bitstringlookuptable;

import positronic.satisfiability.bitstring.BitStringFixer;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.exceptions.BitStringLookupTableFixerException;

public class BitStringLookupTableFixer extends MetaProblem implements IProblem
{
  private static final long serialVersionUID = 7571104700318829937L;

  public BitStringLookupTableFixer(IBitStringLookupTable table, String[] keys, String[] entries) throws Exception
  {
	if(table==null) 
    	throw new BitStringLookupTableFixerException("A null IBitStringLookupTable was passed to a constructor.");
    if(table.getLength()==0) 
    	throw new BitStringLookupTableFixerException("An empty IBitStringLookupTable was passed to a constructor.");
    IProblem[] p1=new IProblem[table.getLength()];
    IProblem[] p2=new IProblem[table.getLength()];
    IProblem res=null;
    for(int i=0;i<p1.length;i++)
    {
    	p1[i]=new BitStringFixer(table.getKey(i),keys[i]);
    	p2[i]=new BitStringFixer(table.getEntry(i),entries[i]);
    	res=new Conjunction(res,p1[i],p2[i]);
    }
    this.setClauses(res.getClauses());
  }
}

