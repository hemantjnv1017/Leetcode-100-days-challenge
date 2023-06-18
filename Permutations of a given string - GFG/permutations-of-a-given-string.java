//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public void helper(String S, String T, TreeSet<String> ans)
    {
        //Base Case - when String S becomes empty
        if(S.equals(""))
        {
            ans.add(T);
            return;
        }
        
        //Faith:
        
        for(int i=0; i<S.length(); i++)
        {
            char ch = S.charAt(i);
            String left = S.substring(0, i);
            String right = S.substring(i+1);
            
            String rem = left + right;
            
            helper(rem, T + ch, ans);
        }
    }
    public List<String> find_permutation(String S) 
    {
        // create a string array which store the all permutations of string
        TreeSet<String> ans = new TreeSet<>();
        
        // call helper function
        helper(S, "", ans);
        
        ArrayList<String> res = new ArrayList<>();
        
        for(var key : ans)
        {
            res.add(key);
        }
        
        return res;
    }
}