package Basics;

public class loops {
	
	public void forloop() {
	String[] name= {"deepu","ana","gin","gum"};
	
	for(int i=0; i<name.length;i++) {
		System.out.println(name[i]);
		}
	}
	
	public void foreach() {
		String[] name = {"deepu","green","lil"};
		for(String i : name) {
			System.out.println(i);
		}
	}
	
	public void foreachint() {
		int[] n = {10,20,30,40};
		for(int i:n) {
			System.out.println(i);
		}
	}
	
	public static void main(String args[]) {
		loops myobj = new loops();
		myobj.forloop();
		myobj.foreach();
		myobj.foreachint();
	}

}
