/*Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

        Examples:
        Input: S = "a1b2"
        Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

        Input: S = "3z4"
        Output: ["3z4", "3Z4"]

        Input: S = "12345"
        Output: ["12345"]
        Note:

        S will be a string with length at most 12.
        S will consist only of letters or digits.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _784_LetterCasePermutation {
}
class Solution {
    public List<String> letterCasePermutation(String S) {

        int metadata[]= new int[S.length()];
        int count=0;
        for(int i=0;i<S.length();i++){
            if(Character.isLetter(S.charAt(i))){
                metadata[i]=count;
                count++;
            }else{
                metadata[i]=-1;
            }
        }
        System.out.println(Arrays.toString(metadata));
        ArrayList<char[]> permutation = printAllBinaryUpToLength(count);
        ArrayList<String> al= new ArrayList<>();
        for(char[] c:permutation){
            String str="";
            for(int j=0;j<metadata.length;j++){
                if(metadata[j]!=-1){
                    if(c[metadata[j]]=='0'){ str=str+((S.charAt(j)+"").toLowerCase());}
                    else{str=str+((S.charAt(j)+"").toUpperCase());}
                }else{
                    str=str+S.charAt(j);
                }
            }
            System.out.println(str);
            al.add(str);
        }
        return al;
    }

    ArrayList<char[]> printAllBinaryUpToLength(final int length) {
        ArrayList<char[]> al= new ArrayList<>();
        if (length >= 63)
            throw new IllegalArgumentException("Current implementation supports only a length < 63. Given: " + length);
        final long max = 1 << length;
        for (long i = 0; i < max; i++) {
            long currentNumber = i;
            final char[] buffer = new char[length];
            int bufferPosition = buffer.length;
            while (bufferPosition > 0) {
                buffer[--bufferPosition] = (char) (48 + (currentNumber & 1));
                currentNumber >>>= 1;
            }

            al.add(buffer);
            System.out.println(buffer);
        }
        return al;
    }
}