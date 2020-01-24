class Node{
	char key;
	Node left, right;
	Node(){left = right = null;	}
	Node(char k){
		this();
		key = k;
	}
	Node(char k, Node l, Node r){
		key = k;
		left = l;
		right = r;
	}
}

class Tree {
	Node root;
	
	int ind = 0;
	public Node create(char[] keys) {
		if(keys[ind++]=='\0')return null;
		Node u = new Node(keys[ind-1]);
		u.left = create(keys);
		u.right = create(keys);
		return u;
	}
	
	public void preOrder(Node u) {
		System.out.print(u.key);
		if(u.left!=null)preOrder(u.left);
		if(u.right!=null)preOrder(u.right);
	}
	
	public void inOrder(Node u) {
		if(u.left!=null)inOrder(u.left);
		System.out.print(u.key);
		if(u.right!=null)inOrder(u.right);
	}
	
	public void postOrder(Node u) {
		if(u.left!=null)postOrder(u.left);
		if(u.right!=null)postOrder(u.right);
		System.out.print(u.key);
	}
	
	public void levelOrder(Node root) {
		Node que[] = new Node[50];
		int front = 0;
		int rear = 0;
		que[rear++]=root;
		while(front<rear) {
			Node t = que[front++];
			System.out.print(t.key);
			if(t.left!=null)que[rear++]=t.left;
			if(t.right!=null)que[rear++]=t.right;
		}
	}
	
	public int depth(Node u,int d) {//index from zero
		if(u==null)return d-1;
		return Math.max(depth(u.left,d+1), depth(u.right,d+1));
	}
	
	public int width(Node root) {
		Node que[] = new Node[50];
		int depth[] = new int[50];
		int cnt[] = new int[10];
		int front = 0;
		int rear = 0;
		que[rear]=root;
		depth[rear++]=0;
		while(front<rear) {
			Node t = que[front];
			cnt[depth[front]]++;
			if(t.left!=null) {
				que[rear]=t.left;
				depth[rear++] = depth[front]+1;
			}
			if(t.right!=null) {
				que[rear]=t.right;
				depth[rear++] = depth[front]+1;
			}
			front++;
		}
		int res = 0;
		for(int i = 0;i<10;i++)res = Math.max(res, cnt[i]);
		return res;
	}
	
	int degree[] = new int[3];
	public void cntDegree(Node u) {
		int d = 0;
		if(u.left!=null) {
			cntDegree(u.left);
			d++;
		}
		if(u.right!=null) {
			cntDegree(u.right);
			d++;
		}
		degree[d]++;
	}
}


class BST extends Tree{
	BST(){}
	BST(Node root){this.root = root;}
	
	boolean find(Node u, char c) {
		if(u==null)return false;
		if(c==u.key)return true;
		else if(c<u.key)return find(u.left,c);
		else return find(u.right,c);
	}
	
	void insert(Node u, char c) {
		if(u.key==c)return;
		else if(u.key<c) {
			if(u.right == null)u.right = new Node(c);
			else insert(u.right,c);
		}
		else {
			if(u.left == null)u.left = new Node(c);
			else insert(u.left,c);		
		}
	}
	
	void delete0(Node f, char c) {
		if(root.key==c) {
			if(root.left==null&&root.right==null)root = null;
			else if(root.left ==null)root = root.right;
			else if(root.right==null)root = root.left;
			else {
				Node s = root.left.right;
				if(s==null) {
					root.left.right = root.right;
					root = root.left;
				}
				else {
					Node s0 = root.left;
					while(s.right!=null) {
						s0 = s;
						s = s.right;
					}
					s0.right = null;
					root.key = s.key;
				}
			}
			return;
		}
		delete(root,c);
	}
	void delete(Node f, char c){
		if(f.left!=null&&f.left.key==c) {
			Node u = f.left;
			if(u.left==null&&u.right==null)f.left = null;
			else if(u.left==null) f.left = u.right;
			else if(u.right==null)f.left = u.left;
			else {
				Node s = u.left.right;
				if(s==null) {
					u.left.right = u.right;
					f.left = u.left;
				}
				else {
					Node s0 = root.left;
					while(s.right!=null) {
						s0 = s;
						s = s.right;
					}
					s0.right = null;
					u.key = s.key;
				}
			}
		}
		else if (f.right!=null&&f.right.key==c){
			Node u = f.right;
			if(u.left==null&&u.right==null)f.right = null;
			else if(u.left==null) f.right = u.right;
			else if(u.right==null)f.right = u.left;
			else {
				Node s = u.left.right;
				if(s==null) {
					u.left.right = u.right;
					f.right = u.left;
				}
				else {
					Node s0 = root.left;
					while(s.right!=null) {
						s0 = s;
						s = s.right;
					}
					s0.right = null;
					u.key = s.key;
				}
			}
		}
		else {
			if(c<f.key)delete(f.left,c);
			else if(c>f.key)delete(f.right,c);
		}
	}
}

public class E05{
	public static void main(String args[]) {
		//测试程序
		Tree tree = new Tree();
		char[]keys = {'e','c','b','a','\0','\0','\0','d','\0','\0','f','\0','h','g','\0','\0','\0'};
		tree.root = tree.create(keys);
		System.out.print("先序遍历：");
		tree.preOrder(tree.root);
		System.out.print("\n中序遍历：");
		tree.inOrder(tree.root);
		System.out.print("\n后序遍历：");
		tree.postOrder(tree.root);
		System.out.print("\n\n二叉树的深度："+tree.depth(tree.root, 0));
		System.out.print("\n二叉树的宽度："+tree.width(tree.root));
		tree.cntDegree(tree.root);
		System.out.print("\n二叉树度数为0,1,2的结点数分别为"+tree.degree[0]+"，"+tree.degree[1]+"，"+tree.degree[2]);
		
		BST bst = new BST(tree.root);
		System.out.println("\n\n二叉搜索树中成功搜索结果："+bst.find(bst.root, 'd'));
		System.out.println("二叉搜索树中失败搜索结果："+bst.find(bst.root, 'z'));	
		bst.insert(bst.root, 'z');
		System.out.print("二叉搜索树插入后进行中序遍历：");
		bst.inOrder(bst.root);
		bst.delete0(bst.root,'c');
		System.out.print("\n二叉搜索树删除后进行中序遍历：");
		bst.inOrder(bst.root);
	}
}
