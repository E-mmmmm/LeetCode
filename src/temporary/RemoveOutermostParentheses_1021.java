package temporary;

/*
 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，
 其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。

如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），
其中 A 和 B 都是非空有效括号字符串。

给出一个非空有效字符串 S，考虑将其进行原语化分解，
使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。

对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。

 

示例 1：

输入："(()())(())"
输出："()()()"
解释：
输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
示例 2：

输入："(()())(())(()(()))"
输出："()()()()(())"
解释：
输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
示例 3：

输入："()()"
输出：""
解释：
输入字符串为 "()()"，原语化分解得到 "()" + "()"，
删除每个部分中的最外层括号后得到 "" + "" = ""。
 */
public class RemoveOutermostParentheses_1021 {
	public static void main(String[] args) {
		String S = "()()";
		String result = removeOuterParentheses(S);
		System.out.println(result);
	}
	/*
	 * 1、将字符串转化为字符数组
	 * 2、遍历字符数组，每遇到一个"("，lCount+1,若为第一个'('，则记录其位置；每遇到一个")"，lCount-1
	 * 3、重复1至3，若遍历到")"且lCount-1 = 0时，将第一个"("和当前的")"之间的所有字符接到结果字符串中
	 * 4、从当前位置的下一个字符开始继续遍历数组，重复2-6，直到遍历过字符数组中的所有元素
	 * 5、返回结果字符串
	 */
	public static String removeOuterParentheses(String S) {
		//结果字符串
		StringBuilder result = new StringBuilder();
		
		//第一个位置
		int lLoc = -1;
		
		//当前位置
		int cur = 0;
		
		//遍历到的'('数
		int lCount = 0;
				
		//1、将字符串转化为字符数组
		char[] charS = S.toCharArray();
        
		for(Character i : charS) {
        	if(i.equals('(')) {
        		if(lCount == 0) {
        			//记录第一个"("的位置，并使lCount+1
        			lLoc = cur;
        		}
        		//每遇到一个"("，lCount+1
        		lCount++;
        		cur++;
        	} else {
        		//每遇到一个")"，lCount-1
        		lCount--;
        		//若遍历到")"且lCount-1 = 0时，将第一个"("和当前的")"之间的所有字符接到结果字符串中
        		if(lCount == 0) {
        			result = result.append(S.substring(lLoc+1, cur));
        		}
        		cur++;
        	}
        }
		
		return result.toString();
    }
}
