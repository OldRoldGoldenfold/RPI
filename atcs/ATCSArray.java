package atcs;


public class ATCSArray {
	private KeyValuePair[] kVPArray;
	private int arraySize = 10;
	
	/**
	 * constructs a new Array of KeyValuePairs, with length arraySize
	 */
	public ATCSArray(){
		kVPArray = new KeyValuePair[arraySize];	
		populateArray();
		}
	
	/**
	 * constructor with variable array size
	 * @param i sets array size
	 */
	public ATCSArray(int i){
		arraySize = (i > 0)? i : 10;
		kVPArray = new KeyValuePair[arraySize];	
		populateArray();
	}
	
	/**
	 * returns the length of kVPArray
	 * @return
	 */
	public int getSize()	{ return arraySize;	}
	
	public KeyValuePair getKVP(int i)	{	return (isValidIndex(i))? kVPArray[i] : null;}
	
	public boolean setKVP(int i, KeyValuePair k)	{return (isValidIndex(i))? set(i, k) : false;	}
	
	private boolean isValidIndex(int i)	{ return (i < getSize())? (i >= 0)? true : false : false; }
	
	private boolean set(int i, KeyValuePair k)	{
		kVPArray[i] = k;
		return true;
	}
	
	public KeyValuePair[] getArray()	{ return kVPArray;	}
	
	private void populateArray(){
		for (int i = 0; i < arraySize; i++)	{
			KeyValuePair k = new KeyValuePair();
			k.makeRandom();
			setKVP(i, k);
		}
	}
	public void makeSuspicious( int x)	{
		String[] suspicious = {"FLACCID", "RUBBERY", "RACISM", "MROMNEY"};
		for (int i = 0; i < arraySize; i+= x){	
			String s = suspicious[(int)(Math.random()*suspicious.length)];
			String v = kVPArray[i].toString().substring(9);
			v = v.substring(0, 7 - s.length()) + s + v.substring(v.length() - 1);
			int k = Integer.parseInt(kVPArray[i].toString().substring(0,  8));
			kVPArray[i] = new KeyValuePair(k, v);
		}
	}
}
