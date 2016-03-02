package MaxSelectorModel;
//
// Ulayer
//
//////////////////////////////////////////////////////////////////////
import hierarchyList.treeTraversal;
 import nslj.src.system.*; 
 import nslj.src.cmd.*; 
 import nslj.src.lang.*; 
 import nslj.src.math.*; 
 import nslj.src.display.*; 
import xmlUtility.xmlParser;

public class Ulayer/*(int size)*/  extends NslModule/*()*/{
//inports
public NslDinDouble1 s_in ; /*()*/  
public NslDinDouble0 v_in ; /*()*/
//outports
public NslDoutDouble1 uf ; /*(size)*/

//variables
private NslDouble1 up ; /*(size)*/  //for now; change when nslGetValue available
private NslDouble0 w1 ; /*()*/
private NslDouble0 w2 ; /*()*/
private NslDouble0 h1 ; /*()*/
private NslDouble0 k ; /*()*/
private  double tau;

public  void initModule() {
	//enableAccess(up);
}
  public  void initRun(){
	uf.set(0);
	up.set(0);
	tau = 1.0;
        
        xmlParser parse = new xmlParser();
        parse.setULayer(w1,w2,h1,k);
        
//        treeTraversal print = new treeTraversal();
//        print.printHierarchy();

  }

  public  void simRun(){
	//compute : up=up+((timestep/tu)*du/dt)

	up.set(system.nsldiff.eval(up,tau,
 __nsltmp106=nslj.src.math.NslAdd.eval(__nsltmp106,
 __nsltmp105=nslj.src.math.NslSub.eval(__nsltmp105,
 __nsltmp104=nslj.src.math.NslSub.eval(__nsltmp104,
 __nsltmp103=nslj.src.math.NslAdd.eval(__nsltmp103,
 __nsltmp101=nslj.src.math.NslSub.eval(__nsltmp101,0,up.get()),
 __nsltmp102=nslj.src.math.NslElemMult.eval(__nsltmp102,w1.get(),uf.get())),
 nslj.src.math.NslElemMult.eval(w2.get(),v_in.get())),h1.get()),s_in.get()))) /* rule 108 */;

	uf.set(NslStep.eval(up,k.get(),0,1.0)) /* rule 108 */;

}
	/* nslInitTempModule inserted by NPP */
public void nslInitTempModule() {
	/* Instantiation statements generated by NslPreProcessor */
	/* temporary variables */
	__nsltmp101 = new double[1];
	__nsltmp102 = new double[1];
	__nsltmp103 = new double[1];
	__nsltmp104 = new double[1];
	__nsltmp105 = new double[1];
	__nsltmp106 = new double[1];
	/* end of automatic instantiation statements */
	/* Intialisation statements generated by NslPreProcessor */
	/* temporary variables */
	/* end of automatic intialisation statements */
}

	/* nslInitTempRun inserted by NPP */
public void nslInitTempRun() {
	/* Intialisation statements generated by NslPreProcessor */
	/* temporary variables */
	for (int i = 0; i < __nsltmp101.length; i++) {
		__nsltmp101[i] = 0;
}
	for (int i = 0; i < __nsltmp102.length; i++) {
		__nsltmp102[i] = 0;
}
	for (int i = 0; i < __nsltmp103.length; i++) {
		__nsltmp103[i] = 0;
}
	for (int i = 0; i < __nsltmp104.length; i++) {
		__nsltmp104[i] = 0;
}
	for (int i = 0; i < __nsltmp105.length; i++) {
		__nsltmp105[i] = 0;
}
	for (int i = 0; i < __nsltmp106.length; i++) {
		__nsltmp106[i] = 0;
}
	/* end of automatic intialisation statements */
}

	/* nslInitTempTrain inserted by NPP */
public void nslInitTempTrain() {
	/* Initialisation statements generated by NslPreProcessor */
	/* temporary variables */
	/* end of automatic intialisation statements */
}

	/* Declaration statements generated by NslPreProcessor */
	/* makeinst() declared variables */
	/* temporary variables */
	private  double[] __nsltmp101;
	private  double[] __nsltmp102;
	private  double[] __nsltmp103;
	private  double[] __nsltmp104;
	private  double[] __nsltmp105;
	private  double[] __nsltmp106;
	/* constructor and related methods */
	/* nsl declarations */
	int size;

	 /*GENERIC CONSTRUCTOR:   */
	 public Ulayer(String nslName, NslModule nslParent,int size) {
		super(nslName, nslParent);
		this.size = size;
		initSys();
		makeInst(nslName, nslParent,size);
	}
	public void makeInst(String nslName, NslModule nslParent,int size){ 
	 s_in=new NslDinDouble1 ("s_in",this); //NSLDECLS 
	 v_in=new NslDinDouble0 ("v_in",this); //NSLDECLS 
	 uf=new NslDoutDouble1 ("uf",this,size); //NSLDECLS 
	 up=new NslDouble1 ("up",this,size); //NSLDECLS 
	 w1=new NslDouble0 ("w1",this); //NSLDECLS 
	 w2=new NslDouble0 ("w2",this); //NSLDECLS 
	 h1=new NslDouble0 ("h1",this); //NSLDECLS 
	 k=new NslDouble0 ("k",this); //NSLDECLS 
	}
	/* end of automatic declaration statements */
}
