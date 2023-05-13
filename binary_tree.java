//Please remove the package name before executing.

package JAVA.Binary_tree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.HashMap;

public class binary_tree 
{
    public Treenode root;

    public class Treenode
    {
        public int data;
        public Treenode left;
        public Treenode right;

        public Treenode(int data)
        {
            this.data = data;
            left = right = null;        
        }
    }

    static class Pair
    {
      Treenode first;
      int second;
      public int hd;

      public Pair(Treenode first , int second)
      {
        this.first = first;
        this.second = second;
      }
    }

    public void createbinaryTree()
    {
        Treenode first = new Treenode(1);
        Treenode second = new Treenode(2);
        Treenode third = new Treenode(3);
        Treenode forth = new Treenode(4);
        Treenode fifth = new Treenode(5);

        root = first;
        first.left = second;
        first.right = third;
        second.left = forth;
        second.right = fifth;
    }

    public void preOrder(Treenode root) //recursive preOrder
    {
        if(root == null)
        return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrder() //iterative preOrder
    {
      if(root == null)
      return;

      Stack<Treenode> stack = new Stack<>();
      stack.push(root);

      while(!stack.isEmpty())
      {
        Treenode temp = stack.pop();
        System.out.print(temp.data + " ");

        if(temp.right != null)
        stack.push(temp.right);
        
        if(temp.left != null)
        stack.push(temp.left);

      }
    }

    public void inOrder(Treenode root) //recursive inOrder
    {
        if(root == null)
        return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void inOrder() //iterative inOrder
    {
        if (root == null) 
           return;
        
        Stack<Treenode> stack = new Stack<>();
        Treenode temp = root;
  
        while (!stack.isEmpty() || temp != null) 
        {
           if (temp != null) 
           {
              stack.push(temp);
              temp = temp.left;
           } 
           else 
           {
              temp = stack.pop();
              System.out.print(temp.data + " ");
              temp = temp.right;
           }
        }
     }
    
    public void postOrder(Treenode root) //recursive postOrder
    {
        if(root == null)
        return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }
    
    public void postOrder() //iterative postOrder using 1 stack
    {
        Treenode current = root;
        Stack<Treenode> stack = new Stack<>();
  
        while (current != null || !stack.isEmpty())
         {
           if (current != null) 
           {
              stack.push(current);
              current = current.left;
           } 
           else 
           {
              Treenode temp = stack.peek().right;
              if (temp == null) 
              {
                 temp = stack.pop();
                 System.out.print(temp.data + " ");
                 while (!stack.isEmpty() && temp == stack.peek().right)
                  {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                 }
              } 
              else 
              {
                 current = temp;
              }
           }
        }
     }
 
    public void postorder() //iterative postOrder using 2 stack // some error 
    {
       Stack <Treenode> s1 = new Stack<Treenode>();
       Stack <Treenode> s2 = new Stack<Treenode>();
   
       if(root == null)
       return;

       s1.push(root);
       while(!s1.isEmpty())
       {
         Treenode temp = s1.pop();
         s2.push(temp);

         if(temp.left != null)
         s1.push(temp.left);
      
         if(temp.right != null)
         s1.push(root.right);
       }

       while(!s2.isEmpty())
       {
         Treenode temp = s2.pop();
         System.out.print(temp.data +" ");
       }
    }
   
    public void allTraversal(Treenode root) //all DFS traversal using one stack
    {
       
        // Stores preorder traversal
        ArrayList<Integer> pre = new ArrayList<>();
 
        // Stores inorder traversal
        ArrayList<Integer> in = new ArrayList<>();
 
        // Stores postorder traversal
        ArrayList<Integer> post = new ArrayList<>();

        Stack<Pair> s = new Stack<>();
        s.push(new Pair(root, 1));
        while (!s.empty())
        {
            Pair p = s.peek();
            if (p.second == 1)
            {
                s.peek().second++;
                pre.add(p.first.data);
                if (p.first.left != null)
                {
                    s.push(new Pair(p.first.left, 1));
                }
            }
            else if (p.second == 2) {
                s.peek().second++;
                in.add(p.first.data);
                if (p.first.right != null) {
                    s.push(new Pair(p.first.right, 1));
                }
            }
            else {
                post.add(p.first.data);
                s.pop();
            }
        }
 
        System.out.print("Preorder Traversal: ");
        for (int i : pre) {
            System.out.print(i + " ");
        }
        System.out.println();
 
        // Printing Inorder
        System.out.print("Inorder Traversal: ");
        for (int i : in) {
            System.out.print(i + " ");
        }
        System.out.println();
 
        // Printing Postorder
        System.out.print("Postorder Traversal: ");
        for (int i : post) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
 
    public void levelOrder() //level order BFS
    {

        if (root == null) 
           return;
  
        Queue<Treenode> queue = new LinkedList<>();
        queue.offer(root);
  
        while (!queue.isEmpty()) 
        {
           Treenode temp = queue.poll();
           System.out.print(temp.data + " ");
           if (temp.left != null)
              queue.offer(temp.left);

           if (temp.right != null) 
              queue.offer(temp.right);
        }
     }
  
 /* public int findMax() // finding maximum
    {
        return findMax(root);
    }*/
  
    public int findMax(Treenode root)// finding maximum 
     {
        if (root == null) 
           return Integer.MIN_VALUE;
  
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
  
        if (left > result) 
           result = left;
  
        if (right > result) 
           result = right;
  
         return result;
     }
  
     public int depth(Treenode root) //finding depth 
     {
         if(root == null )
         return 0;
 
         int lh = depth(root.left);
         int rh = depth(root.right);
 
         return (1 + Math.max(lh , rh));
     }
     
     public boolean isBalanced(Treenode root) // checking for balanced tree
    {
        return Height(root) != 1;
    }

    public int Height(Treenode root) //comparing left and right depth
    {
        if(root == null)
        return 0;

        int lh = Height(root.left);
        if(lh == -1)
        return -1;

        int rh = Height(root.right);
        if(rh == -1)
        return -1;

        if(Math.abs(lh - rh) > 1)
        return -1;

        return Math.max(lh , rh ) + 1;
    }

    public int diaheight(Treenode node , int[] dia)
    {
      if(node == null)
      return 0;

      int l = diaheight(node.left, dia);
      int r = diaheight(node.right, dia);
      dia[0] = Math.max(dia[0], r+l+1);
      return (1 + Math.max(l, r));
    }

    public int diameter(Treenode root) //checking diameter of a tree
    {
        int[] d = new int[1];
        diaheight(root, d);
        return  d[0];
    }

    public int maxpathsum(Treenode root) //finding maxsum 
    {
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];

    }

    public int maxPathDown(Treenode node, int maxValue[])
    {
        if (node == null) 
        return 0;
        int left = Math. max(0, maxPathDown(node. left, maxValue));
        int right = Math. max(0, maxPathDown(node. right, maxValue));
        maxValue[0] = Math.max(maxValue[0], left + right + node.data);
        return Math.max(left, right) + node.data;
    }
   
    public boolean isSametree(Treenode t1 , Treenode t2) //checking for same tree
    {
      if(t1 == null || t2 == null)
        return ( t1 == t2);
      return (t1.data == t2.data) && isSametree(t1.left, t2.left) && isSametree(t1.right, t2.right);
    }
    
    public ArrayList<Integer> zigZagTraversal(Treenode root) //zigzag traversal
        {
            ArrayList<Integer> ans = new ArrayList<Integer>();
            if (root == null)
                return ans;
            Queue<Treenode> q = new LinkedList<Treenode>();
            q.add(root);  
            boolean leftToRight = true;
            while (q.size() > 0) 
            {
                int size = q.size();
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    Treenode curr = q.poll();
                    if (curr.left != null)
                        q.add(curr.left);
                    if (curr.right != null)
                        q.add(curr.right);
                    temp.add(curr.data);
                }
                if (leftToRight);
                else
                 {
                    Collections.reverse(temp);
                 }
                 for (int i = 0; i < temp.size(); i++)
                 {
                    ans.add(temp.get(i));
                 }
                 leftToRight = !(leftToRight);
            }
            return ans;
        }
    
    public Boolean isLeaf(Treenode root) 
        {
            return (root.left == null) && (root.right == null);
        }
    
    public void addLeftBoundary(Treenode root, ArrayList < Integer > res) 
    {
            Treenode cur = root.left;
            while (cur != null) {
                if (isLeaf(cur) == false) res.add(cur.data);
                if (cur.left != null) cur = cur.left;
                else cur = cur.right;
            }
        }
    
    public void addRightBoundary(Treenode root, ArrayList < Integer > res) 
    {
            Treenode cur = root.right;
            ArrayList < Integer > tmp = new ArrayList < Integer > ();
            while (cur != null) {
                if (isLeaf(cur) == false) tmp.add(cur.data);
                if (cur.right != null) cur = cur.right;
                else cur = cur.left;
            }
            int i;
            for (i = tmp.size() - 1; i >= 0; --i) {
                res.add(tmp.get(i));
            }
        }
    
    public void addLeaves(Treenode root, ArrayList < Integer > res) 
    {
            if (isLeaf(root)) 
            {
                res.add(root.data);
                return;
            }
            if (root.left != null) addLeaves(root.left, res);
            if (root.right != null) addLeaves(root.right, res);
        }
    
    public ArrayList <Integer> printBoundary(Treenode node) //boundary traversal
     {
            ArrayList < Integer > ans = new ArrayList < Integer > ();
            if (isLeaf(node) == false) ans.add(node.data);
            addLeftBoundary(node, ans);
            addLeaves(node, ans);
            addRightBoundary(node, ans);
            return ans;
        }
    
    public void printVertical(Treenode root)
    {
         Map<Integer,List<Integer>> map = new TreeMap<>();
         printVertical(root);
        for (List<Integer> set: map.values())
            System.out.println(set);
    }
  
    public List<List<Integer>> verticalTraversal(Treenode root) //vertical traversal 
    {
        TreeMap<Integer, TreeSet<int[]>> map = new TreeMap<>();
        List<List<Integer>> res = new LinkedList<>();

        vertcal_movement(root, 0, 0, map);

        for (int i : map.keySet()) 
        {
            List<Integer> list = new LinkedList<>();
            for (int[] j : map.get(i))
                list.add(j[0]);
            res.add(list);
        }

        return res;
    }

    public void vertcal_movement(Treenode root, int order, int level , Map<Integer, TreeSet<int[]>> map) 
    {
        if (root == null) return;

        if (!map.containsKey(order))
            map.put(order, new TreeSet<int[]>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]));

        map.get(order).add(new int[]{root.data, level});
        vertcal_movement(root.left, order - 1, level + 1 , map);
        vertcal_movement(root.right, order + 1, level + 1, map);
    }

    public ArrayList<Integer> topView(Treenode root) //top view of binary tree
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)
        return ans;
        Map<Integer , Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(root , 0));
        while(!q.isEmpty())
        {
            Pair it = q.remove();
            int hd = it.second;
            Treenode temp = it.first;
            if(map.get(hd) == null)
                map.put (hd , temp.data);
            if(temp.left != null)
                q.add(new Pair(temp.left , hd-1));
            if(temp.right != null)
                q.add(new Pair(temp.right , hd+1));
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            ans.add(entry.getValue());
        }
        return ans;
    }

    public ArrayList<Integer> bottomView(Treenode root)
    {
        ArrayList<Integer> res = new ArrayList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair obj = q.remove();
                map.put(obj.second,obj.first.data);
                if(obj.first.left != null)q.add(new Pair(obj.first.left,obj.second-1));
                if(obj.first.right != null)q.add(new Pair(obj.first.right,obj.second+1));
            }
        }
        for(int key : map.keySet())
            res.add(map.get(key));
        return res;
    }

    public List<Integer> rightsideView(Treenode root)
    {
        List<Integer> result = new ArrayList<>();
        rightView(root , result , 0);
        return result;
    }

    public void rightView(Treenode curr , List<Integer> result , int curdepth)
    {
        if(curr == null)
        return ;

        if(curdepth == result.size())
        result.add(curr.data);

        rightView(curr.right, result, curdepth+1);
        rightView(curr.left, result, curdepth+1);
    }

    public static boolean hasPath(Treenode root, ArrayList<Integer> arr, int x)
    {
        if (root==null)
            return false;
        arr.add(root.data);  
        if (root.data == x)    
            return true;
        if (hasPath(root.left, arr, x) ||
            hasPath(root.right, arr, x))
            return true;   
        arr.remove(arr.size()-1);
        return false;            
    }
 
    public static void printPath(Treenode root, int x)
    {
        ArrayList<Integer> arr=new ArrayList<>();
        if (hasPath(root, arr, x))
        {
            for (int i=0; i<arr.size()-1; i++)    
                System.out.print(arr.get(i)+"->");
            System.out.print(arr.get(arr.size() - 1));   
        }
        else
            System.out.print("No Path");
    }

    public Treenode lowestCommmonAncester(Treenode root , int n1 , int n2) //Lowest common ancestor
    {
        if (root == null)
            return null;
        if (root.data == n1 || root.data == n2)
            return root;
        Treenode left_lca = lowestCommmonAncester(root.left, n1, n2);
        Treenode right_lca = lowestCommmonAncester(root.right, n1, n2);
        if (left_lca != null && right_lca != null)
            return root;
        return (left_lca != null) ? left_lca : right_lca;
    }

    public int getMaxWidth(Treenode root) // GEtting Maximum width
    {
        if(root==null)
         return 0;
        Queue<Treenode>q=new LinkedList<>();
        q.offer(root);
        int ans=0;
        while(!q.isEmpty())
        {
                int size=q.size();
                int count=0;
                for(int i=0;i<size;i++)
                {
                       if(q.peek().left!=null)
                       q.offer(q.peek().left);
                       if(q.peek().right!=null)
                       q.offer(q.peek().right);
                       count++;
                       q.poll();
                }
                ans=Math.max(ans,count);
        }
        return ans;
    }

    public void changeTree(Treenode root) //child sum Tree
    {
        if(root == null)
            return;
        int child = 0;
        if(root.left != null)
            child += root.left.data;
        if(root.right != null)
            child += root.right.data;
        
        if(child >= root.data)
            root.data = child;
        else
        {
            if(root.left != null)
                root.left.data = root.data;
            else if(root.right != null)
                root.right.data = root.data;
        }

        changeTree(root.left);
        changeTree(root.right);

        int tot = 0;
        if(root.left != null)
            tot+= root.left.data;
        if(root.right != null)
            tot+= root.right.data;
        if(root.left != null || root.right != null)
            root.data = tot;
    }

    public void  markParent(Treenode root , Map<Treenode , Treenode> parent_track , Treenode target )
    {
        Queue<Treenode> queue = new LinkedList<Treenode>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            Treenode curr = queue.poll();
            if(curr.left != null)
            {
                parent_track.put(curr.left , curr);
                queue.offer(curr.left);
            }
            if(curr.right != null)
            {
                parent_track.put(curr.right , curr);
                queue.offer(curr.right);
            }
        }
    }
   
    public List<Integer> distK(Treenode root , Treenode target , int k) //nodes at a distance k
    {
        Map<Treenode , Treenode> parent_track = new HashMap<>();
        markParent(root, parent_track, root);
        Map<Treenode , Boolean> visited = new HashMap<>();
        Queue<Treenode> queue = new LinkedList<Treenode>();
        queue.offer(target);
        visited.put(target, true);
        int curr_level = 0 ;
        while(!queue.isEmpty())
        { 
            int size = queue.size();
            if(curr_level == k)
            break;

            curr_level++;
            for(int i = 0 ; i < size ; i++)
            {
                Treenode current = queue.poll();
                if(current.left != null && visited.get(current.left) == null)
                {
                    queue.offer(current.left);
                    visited.put(current.left , true);
                }
                if(current.right != null && visited.get(current.right) == null)
                {
                    queue.offer(current.right);
                    visited.put(current.right , true);
                }
                if(parent_track.get(current) != null  && visited.get(parent_track.get(current)) == null)
                {
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current) , true);
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty())
        {
            Treenode curr = queue.poll();
            result.add(curr.data);
        }
        return result;
    }

    public void getparent(Treenode root, Treenode parent,Map<Treenode, Treenode> map)
	{
		if (root == null)
			return;

		map.put(root, parent);
		getparent(root.left, root, map);
		getparent(root.right, root, map);

		return;
	}
    
    Treenode n1 = null;
    
    public void getnode(Treenode root, int a)
	{
		if (root == null)
			return;

		if (root.data == a)
			n1 = root;

		getnode(root.left, a);
		getnode(root.right, a);

		return;
	}

    public int getmaxdis(Treenode target, int dis,Map<Treenode, Integer> vis,Map<Treenode, Treenode> map)
	{
		if (target == null)
			return dis - 1;

		if (vis.containsKey(target))
			return Integer.MIN_VALUE;
		vis.put(target, 1);

		int a1 = Integer.MIN_VALUE;
		int a2 = Integer.MIN_VALUE;
		int a3 = Integer.MIN_VALUE;
		// if(a->left!=NULL)
		a1 = getmaxdis(target.left, dis + 1, vis,map); // left child

		// if(a->right!=NULL)
		a2 = getmaxdis(target.right, dis + 1, vis,map); // right child

		// if(map[a] != NULL)
		a3 = getmaxdis(map.get(target), dis + 1, vis,map); // parent

		return Math.max(Math.max(a1, a2), a3);
	}

    public int minTime(Treenode root, int target) //minimum time to burn a tree
	{
		Map<Treenode, Treenode> par = new HashMap<>();
		getparent(root, null, par);

		getnode(root, target);
		Map<Treenode, Integer> vis = new HashMap<>();

		return getmaxdis(n1, 0, vis, par);
	}

    public int left_height(Treenode node)
    {
        int ht = 0;
        while (node!=null) 
        {
            ht++;
            node = node.left;
        }
        return ht;
    }
    
    public int right_height(Treenode node)
    {
        int ht = 0;
        while (node!=null) 
        {
            ht++;
            node = node.right;
        }
        return ht;
    }

    public int TotalNodes(Treenode root) //  count total number of nodes in a tree inless than O(n) time 
    {
        if (root == null)
            return 0;
        int lh = left_height(root);
        int rh = right_height(root);
        if (lh == rh)
            return (1 << lh) - 1;
        return 1 + TotalNodes(root.left)+ TotalNodes(root.right);
    }

    public Treenode buildtree(int[] preorder , int[] inorder) // making a tree from pre and in 
    {
        Map<Integer, Integer> inmap = new HashMap<Integer , Integer>();
        for(int i = 0 ; i < inorder.length ; i++)
            inmap.put(inorder[i] , i);
        Treenode root = buildTree(preorder , 0 , preorder.length - 1 , inorder , 0 , inorder.length - 1 , inmap);
        return root ;
    }
    
    public Treenode buildTree(int[] preorder , int prestart , int preend , int[] inorder , int instart , int inend , Map<Integer , Integer> inmap)
    {
        if(prestart > preend || instart > inend)
        return null;
        Treenode root  =  new Treenode(preorder[prestart]);
        int inroot = inmap.get(root.data);
        int  numleft = inroot - instart;
        root.left = buildTree(preorder, prestart+1 , prestart + numleft , inorder , instart , inroot-1 , inmap);
        root.left = buildTree(preorder, prestart + numleft + 1, preend , inorder , inroot+1 , inend , inmap);
        return root;
    }
     
    public Treenode buildtree1(int[] inorder , int[] postorder) // making a tree from in and post 
    {
        if(inorder == null || postorder == null || inorder.length != postorder.length)
        return null;
        Map<Integer, Integer> hm = new HashMap<Integer , Integer>();
        for(int i = 0 ; i < inorder.length ; ++i)
        hm.put(inorder[i] , i);
        Treenode root = buildTree1(inorder , 0 , inorder.length - 1 , postorder , 0 , postorder.length - 1 , hm);
        return root ;
    }
    
    public Treenode buildTree1(int[] inorder , int is , int ie , int[] postorder , int ps , int pe , Map<Integer , Integer> inmap)
    {
        if(ps > pe || is > ie)
            return null;
        Treenode root  =  new Treenode(postorder[ps]);
        int inroot = inmap.get(postorder[pe]);
        int  numleft = inroot - is;
        root.left = buildTree1(inorder, is , inroot -1 , postorder , ps , ps + numleft-1 , inmap);
        root.left = buildTree1(inorder, inroot + 1, ie , postorder ,  ps + numleft , pe -1  , inmap);
        return root;
    }

    // we cant make tree from post and pre 

    public String serialize(Treenode root) //serialize a tree
    {
        if (root == null)
         return "";
        Queue<Treenode> q = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        q.add(root);
        while (!q.isEmpty()) 
        {
        Treenode node = q.poll();
        if (node== null)
        {
        res.append("n ");
        continue;
        }
        res. append(node.data + " ");
        q.add(node.left);
        q.add(node.right);
        }
    return res. toString();
    }

    public Treenode deserialize(String data) //deserilize a tree
    {
        if(data == "") 
            return null;
        Queue<Treenode> q = new LinkedList<>();
        String[] values = data.split(" ");
        Treenode root = new Treenode(Integer.parseInt(values[0]));
        q.add(root);
        for(int i = 1 ; i < values.length ; i++)
        {
            Treenode parent = q.poll();
            if (!values[i].equals("n"))
            {
                Treenode left = new Treenode(Integer.parseInt(values[i]));
                parent.left = left;
                q.add(left);
            }
            if (!values[++i].equals("n"))
            {
                Treenode right = new Treenode(Integer.parseInt(values[i]));
                parent.right = right;
                q.add(right);
            }
        }
        return root;
    }

    public void MorrisTraversal(Treenode root) //Morris traversal for inorder
    {
        Treenode current, pre;
 
        if (root == null)
            return;
 
        current = root;
        while (current != null)
        {
            if (current.left == null)
            {
                System.out.print(current.data + " ");
                current = current.right;
            }
            else 
            {
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;
                if (pre.right == null) 
                {
                    pre.right = current;
                    current = current.left;
                }
                else
                {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                } 
            }
        } 
    }

    public void flatten(Treenode root)
  {
    while (root != null) {
      if (root.left != null) 
      {
        Treenode curr = root.left;
        while (curr.right != null)
        {
          curr = curr.right;
        }
        curr.right = root.right;
        root.right = root.left;
        root.left = null;
      }
      root = root.right;
    }
  }

    public void flatten1(Treenode node)
  {
      if (node == null)
          return;
      if (node.left == null && node.right == null)
          return;
      if (node.left != null) 
      {
          flatten(node.left);
          Treenode tempNode = node.right;
          node.right = node.left;
          node.left = null;
          Treenode curr = node.right;
          while (curr.right != null)
              curr = curr.right;
          curr.right = tempNode;
      }
      flatten(node.right);
  }

    public void delete(Treenode root, int key) //delete a node
  {
      if (root == null)
          return;

      if (root.left == null && root.right == null) 
      {
          if (root.data == key) 
          {
              root = null;
              return;
          }
          else
              return;
      }

      Queue<Treenode> q = new LinkedList<Treenode>();
      q.add(root);
      Treenode temp = null, keyNode = null;
      while (!q.isEmpty()) 
      {
          temp = q.peek();
          q.remove();

          if (temp.data == key)
              keyNode = temp;

          if (temp.left != null)
              q.add(temp.left);

          if (temp.right != null)
              q.add(temp.right);
      }

      if (keyNode != null) 
      {
          int x = temp.data;
          deleteDeepest(root, temp);
          keyNode.data = x;
      }
  }

    public void deleteDeepest(Treenode root, Treenode delNode)
  {
      Queue<Treenode> q = new LinkedList<Treenode>();
      q.add(root);

      Treenode temp = null;
      while (!q.isEmpty()) 
      {
          temp = q.peek();
          q.remove();

          if (temp == delNode)
          {
              temp = null;
              return;
          }
          if (temp.right != null) 
          {
              if (temp.right == delNode) 
              {
                  temp.right = null;
                  return;
              }
              else
                  q.add(temp.right);
          }

          if (temp.left != null) 
          {
              if (temp.left == delNode) 
              {
                  temp.left = null;
                  return;
              }
              else
                  q.add(temp.left);
          }
      }
  }

    public static void main (String args[]) // main method 
    {
      binary_tree bt = new binary_tree();
      bt.createbinaryTree();
      System.out.println("\nTypes of Depth first search in binary tree");
      System.out.print("Recursive Way preOrder: -- ");
      bt.preOrder(bt.root);
      System.out.println();
      
      System.out.print("Iterative Way preOrder: -- ");
      bt.preOrder();
      System.out.println();
      
      System.out.print("Recursive Way inOrder: -- ");
      bt.inOrder(bt.root);
      System.out.println();
      
      System.out.print("Iterative Way inOrder: -- ");
      bt.inOrder();
      System.out.println();
      
      System.out.print("Recursive Way postOrder: -- ");
      bt.postOrder(bt.root);
      System.out.println();
      
      System.out.print("Iterative Way postOrder 1 stack: -- ");
      bt.postOrder();
      System.out.println();
      
      System.out.print("Iterative Way postOrder 2 stack: -- ");
      bt.postorder();
      System.out.println();
      System.out.println();

      System.out.println("All traversal using a single stack");
      bt.allTraversal(bt.root);
      System.out.println();

      System.out.print("Breadth first Search :-- ");
      bt.levelOrder();
      
      System.out.println();
      System.out.println();
      System.out.println("Zigzag reaversal is" + bt.zigZagTraversal(bt.root));
      
      System.out.println();
      System.out.println("Boudary treaversal is" + bt.printBoundary(bt.root));

      System.out.println();
      System.out.println("Vertical treaversal is" + bt.verticalTraversal(bt.root));

      System.out.println();
      System.out.println("Top view of binary tree is" + bt.topView(bt.root));
      
      System.out.println();
      System.out.println("Bottom view of binary tree is" + bt.bottomView(bt.root));

      System.out.println();
      System.out.println("Right view of binary tree is" + bt.rightsideView(bt.root));

      System.out.println();
      System.out.println("Largest Element is : " +bt.findMax(bt.root));

      System.out.println();
      System.out.println("Depth of binary tree is "+bt.depth(bt.root));

      System.out.println();
      System.out.println("Is binary tree balanced :- "+bt.isBalanced(bt.root));

      System.out.println();
      System.out.println("Diameter of tree is "+bt.diameter(bt.root));

      System.out.println();
      System.out.println("Max path sum of tree is "+bt.maxpathsum(bt.root));
      
      System.out.println();
      System.out.print("Path from 5 to root is ");
      printPath(bt.root, 5);

      System.out.println();
      System.out.println();
      System.out.println("Is tree same " + bt.isSametree(bt.root, bt.root));
      
      System.out.println();
      System.out.println("lowest common ancestor of 3 and 5 is " + bt.lowestCommmonAncester(bt.root, 3 , 5).data);
      
      System.out.println();
      System.out.println("Max width of this binary tree is " + bt.getMaxWidth(bt.root));

      System.out.println();
      System.out.println("K th element are  " + bt.distK(bt.root , bt.root.left , 1));
      
      //   bt.changeTree(bt.root);
      //   System.out.print("Breadth first Search :-- ");
      //   bt.levelOrder();
      
      System.out.println();
      System.out.println("Minimum time to burn a tree " + bt.minTime(bt.root , 3));
      
      System.out.println();
      System.out.println("Total nodes in binary tree is " + bt.TotalNodes(bt.root));
      
        //   System.out.println();
        //   int in[] = {15, 25, 28, 30, 35, 40, 45, 50, 55, 60, 70};
        //   int pre[] =  { 40, 30, 25, 15, 28, 35, 50, 45, 60, 55, 70 };
        //   Treenode root1 = bt.buildtree(pre , in);

        
        //   System.out.println();
        //   int in[] = {15, 25, 28, 30, 35, 40, 45, 50, 55, 60, 70};
        //   int post[] =  {15, 28, 25, 35, 30, 45, 55, 70, 60, 50, 40};
        //   Treenode root1 = bt.buildtree(in , post);
      
        System.out.println();
        System.out.println("Serilize node " + bt.serialize(bt.root));
        
        System.out.println();
        System.out.println("Deserilize node " + bt.deserialize("1 2 3 4 5 n n n n n n ").data);
        
        System.out.println();
        System.out.print("Morris Traversal inorder --  ");
        bt.MorrisTraversal(bt.root);

        System.out.println();
        System.out.println("Flatten binary tree : ");
        bt.flatten1(bt.root);
        bt.inOrder();

        System.out.println();
        System.out.println("Deleting 2 from tree");
        bt.delete(bt.root , 2);
        bt.inOrder();
    }

}
  
