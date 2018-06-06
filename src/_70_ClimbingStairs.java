public class _70_ClimbingStairs {


    _70_ClimbingStairs(){
        Solution solution= new Solution();
        solution.climbStairs(2);
    }

    class Solution {
        public int climbStairs(int n) {
            if(n<=0) return 0;
            int[] arr= new int[n+1];
            for(int i=0;i<arr.length;i++){
                arr[i]=-1;
            }

            arr[0]=0;
            if(n>=1)
                arr[1]=1;
            if(n>=2)
                arr[2]=2;

            for(int i=3;i<arr.length;i++){
                arr[i]=arr[i-1]+arr[i-2];
            }
            return arr[n];

            // Node node=buildPath(n);
            // return numberOfLeaves(node);
        }

//     class Node{
//         int val;
//         Node left;
//         Node right;
//         Node(int val){
//             this.val=val;
//         }
//     }
//
//     private Node buildPath(int val ){
//         if(val<0) return null;
//         Node node= new Node(val);
//         Node left=null;
//         Node right=null;
//         if(val-1>=0){
//            left= buildPath(val-1);
//         }
//         node.left=left;
//         if(val-2>=0){
//            right= buildPath(val-2);
//         }

//         node.right=right;
//         return node;


//     }
//     private int numberOfLeaves(Node node){
//         if(node== null) return 0;
//         if(node.left==null && node.right==null) return 1;
//         int left= numberOfLeaves(node.left);
//         int right =numberOfLeaves(node.right);
//         return left+right;
//     }



    }
}
