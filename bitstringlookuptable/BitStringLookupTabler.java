package positronic.satisfiability.bitstringlookuptable;

/*
 * BitStringinaryOperator.java	1.01 09/06/08
 *
 * Copyright 2009 Positronic Software.
 *
 *
 */

import positronic.satisfiability.bitstring.BitStringEqualizer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.exceptions.BitStringLookupTablerException;

/**
 * <p>Title: <tt>BitStringLookupTabler</tt> class</p>
 * <p>Description: This class, an extension of <tt>Problem</tt>, is created from
 * pairs of instances of <tt>Problem</tt> passed to one of the 
 * <tt>BitStringLookupTabler</tt> 
 * constructors. An instance of <tt>BitStringLookupTabler</tt> is satisfied if and 
 * only if for 
 * some pair of <tt>Problem</tt>'s, both <tt>Problem</tt>'s are satisfied. For 
 * instance, suppose we define 
 * <p>
 * <tt>...</tt>
 * <p><tt>IProblem[] ipr1=new IProblem[]{p7,p9,p2};</tt>
 * <p><tt>IProblem[] ipr2=new IProblem[]{p3,p8,p1};
 * <p><tt>IBooleanVariable[] bool=new IBooleanVariable[]{b1,b2};
 * <p><tt>IProblem map1=new BitStringLookupTable(ip1,ipr2,bool);
 * <p><tt>...</tt>
 * </p>
 * <p>Then <tt>map1</tt> will be satisfied when <p>(1) <tt>p7</tt> and <tt>p3</tt> are 
 * both satisfied, or <p>(2) <tt>p9</tt> and <tt>p8</tt> are both satisfied, or <p>(3) 
 * <tt>p2</tt> and <tt>p1</tt> are both satisfied.
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.01
 */

public class BitStringLookupTabler extends MetaProblem implements IProblem
{
  private static final long serialVersionUID = 4593986140646526094L;

	public BitStringLookupTabler(IBitString X, IBitString Y, IBitStringLookupTable table) throws Exception
  {
		if(table==null) 
    	throw new BitStringLookupTablerException("A null IBitStringLookupTable was passed to a constructor.");
    if(table.getLength()==0) 
    	throw new BitStringLookupTablerException("An empty IBitStringLookupTable was passed to a constructor.");
    IProblem[] p1=new IProblem[table.getLength()];
    IProblem[] p2=new IProblem[table.getLength()];
    IProblem res=null;
    for(int i=0;i<p1.length;i++)
    {
    	p1[i]=new BitStringEqualizer(X,table.getKey(i));
    	p2[i]=new BitStringEqualizer(table.getEntry(i),Y);
    	res=new Disjunction(res,new Conjunction(p1[i],p2[i]));
    }
    this.setClauses(res.getClauses());
  }
}


