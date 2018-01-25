import java.util.Scanner;


public class UF {

	int[] id;
	int count;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.print("指定数组大小:");
		int i = new Scanner(System.in).nextInt(); 
		UF uf = new UF(i);
		boolean ture = true;
		while (ture) {
			System.out.print("第一个连接数:");
			int p = new Scanner(System.in).nextInt(); 
			System.out.print("第二个连接数:");
			int q = new Scanner(System.in).nextInt();
			uf.union(p, q);
			uf.print();
		}
		uf.union(0, 9);
		uf.print();
	}
	public UF(int n) {
		id = new int[n];
		for(int i=0;i<n;i++){
			id[i] = i;
		}
		this.count = n;
	}
	public boolean connected(int p,int q) {
		return id[p]==id[q];
	}
	public void union(int p,int q) {
		if(id[p]==id[q]){
			return;
		}
		int temp = id[p];
		for(int i=0;i<id.length;i++){
			//System.out.print(id[i]);
			//System.out.println(id[p]);
			if(temp==id[i]){
				//System.out.print(id[p]);
				id[i] = id[q];
				count--;
				//System.out.print(count);
			}
		}
	}
	public void print() {
		int i=0;
		System.out.print("数据结构：");
		for(i=0;i<id.length-1;i++){
			System.out.print(id[i]+"-");
		}
		System.out.println(id[i]);
		System.out.println("数据分为"+count+"部分");
	}

}
