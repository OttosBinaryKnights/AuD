package Blatt03;

public class RNode {
	
	int data = Integer.MAX_VALUE;
	RNode prev = null; // previous node
	RNode next = null; // next node

	public RNode() {}
	
	@Override
	public String toString() {
		return String.valueOf(data);
	}
	
	public String toText() {
		String res = this.toString();
		RNode tmp = next;
		while (!tmp.equals(this)) {
			res += " " + tmp.toString();
			tmp = tmp.next;
		}
		return res;
	}
	
	public static RNode createRing(int length) {
		if (length < 2)
			return null;
		RNode fst = new RNode();
		RNode tmp = fst;
		for (int i = 1; i < length; i++) {
			RNode tmp2 = new RNode();
			tmp2.data = i;
			tmp.next = tmp2;
			tmp2.prev = tmp;
			tmp = tmp2;
		}
		fst.prev = tmp;
		tmp.next = fst;
		return fst;
	}
	
	public static void insert_before(RNode n, RNode pos) {
		if ((n == null) || (pos == null))
			return;
		if (pos.prev == null) {
			// Einzelne Node -> Ring bilden
			pos.prev = pos.next = n;
			n.prev = n.next = pos;
		} else {
			RNode tmp = pos.prev;
			tmp.next = n;
			n.prev = tmp;
			pos.prev = n;
			n.next = pos;
		}
	}
	
	public static RNode find(RNode ring, int x) {
		if (ring.data == x) {
			return ring;
		}
		RNode tmp = ring;
		do {
			tmp = tmp.next;
			if (tmp.equals(ring))
				break;
		} while (tmp.data != x);
		if (ring.equals(tmp))
			return null;
		return tmp;
	}
	
	public static void main(String[] args) {
		RNode a = createRing(5);
		System.out.println(a.toText());
		RNode b = find(a, 3);
		System.out.println(b.toText());
		RNode c = new RNode();
		c.data = 10;
		insert_before(c, b);
		System.out.println(a.toText());
	}
}
