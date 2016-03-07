package MaxSelectorModel;
//
// Vlayer
//
//////////////////////////////////////////////////////////////////////
import hierarchyList.treeTraversal;
 import nslj.src.system.*; 
 import nslj.src.cmd.*; 
 import nslj.src.lang.*; 
 import nslj.src.math.*; 
 import nslj.src.display.*; 
import xmlUtility.xmlParser;

public class Vlayer/*()*/  extends NslModule/*()*/ {
// ports 
public NslDinDouble1 u_in ; /*()*/ // will look for u_in
public NslDoutDouble0 vf ; /*()*/  // output port
// variables
private NslDouble0 vp ; /*()*/  // neuron potential
private NslDouble0 h2 ; /*()*/
private  double tau;         // time constant


public  void initRun(){
	//vf.set(0);
	//vp.set(0);
      //h2.set(0.5);
     
      //Change the xml values in v1 to change these 3 variables
      xmlParser parseV1 = new xmlParser();
      parseV1.setVLayer(vf, vp, h2);
      tau=1.0;
      
      
     //treeTraversal print = new treeTraversal();
     //print.printHierarchy(); 
      
  }
  public  void simRun(){
	// vp=vp+((timestep/tv)*dv/dt)

	vp.set(system.nsldiff.eval(vp,tau,
 nslj.src.math.NslSub.eval(
 nslj.src.math.NslAdd.eval(nslj.src.math.NslSub.eval(0,vp),NslSum.eval(u_in)),h2.get()))) /* rule 108 */;
	vf.set(NslRamp.eval(vp)) /* rule 108 */;
  }
	/* nslInitTempModule inserted by NPP */
public void nslInitTempModule() {
	/* Instantiation statements generated by NslPreProcessor */
	/* temporary variables */
	/* end of automatic instantiation statements */
	/* Intialisation statements generated by NslPreProcessor */
	/* temporary variables */
	/* end of automatic intialisation statements */
}

	/* nslInitTempRun inserted by NPP */
public void nslInitTempRun() {
	/* Intialisation statements generated by NslPreProcessor */
	/* temporary variables */
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
	/* constructor and related methods */
	/* nsl declarations */

	 /*GENERIC CONSTRUCTOR:   */
	 public Vlayer(String nslName, NslModule nslParent) {
		super(nslName, nslParent);
		initSys();
		makeInst(nslName, nslParent);
	}
	public void makeInst(String nslName, NslModule nslParent){ 
	 u_in=new NslDinDouble1 ("u_in",this); //NSLDECLS 
	 vf=new NslDoutDouble0 ("vf",this); //NSLDECLS 
	 vp=new NslDouble0 ("vp",this); //NSLDECLS 
	 h2=new NslDouble0 ("h2",this); //NSLDECLS 
	}
	/* end of automatic declaration statements */
}
