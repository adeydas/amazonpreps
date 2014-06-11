/*
 * Manage a collection of hosts with constant time addition, deletion and return a random host
 */

package ws.abhis.amazonpreps.careercupqs;

import java.util.ArrayList;
import java.util.List;

public class HostManagement {
	public class Host {}
	
	private List<Host> allHosts = new ArrayList<Host>();
	
	public void add(Host host) {
		allHosts.add(host);
	}
	public void delete(Host host){
		//find the element
		int index = 0;
		for (int i=0; i<allHosts.size(); i++) {
			Host h = allHosts.get(i);
			if (h == host) {
				index = i;
				break;
			}
		}
		//deletion now takes constant time
		allHosts.add(index, allHosts.get(allHosts.size()-1));
		allHosts.remove(allHosts.size()-1);
	}
	public Host randomHost(){
		return allHosts.get(returnRandomNumber());
	}
	private int returnRandomNumber() {
		int minimum = 0;
		int maximum = allHosts.size()-1;
		int randomNum = minimum + (int)(Math.random()*maximum);
		return randomNum;
	}
	public void init() {
		Host one = new Host();
		Host two = new Host();
		add(one);
		add(two);
		delete(one);
		System.out.println(randomHost());
	}
	
	public static void main(String[] args) {
		HostManagement obj = new HostManagement();
		
		obj.init();
	}
}
