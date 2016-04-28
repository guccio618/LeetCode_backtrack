import java.util.ArrayList;
import java.util.List;


public class Le_093_Restore_IP_Addresses {
	public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<String>();
        if(s == null || s.length() < 4){
            return ans;
        }
        
        int n = s.length();
        List<String> list = new ArrayList<String>();
        backtrack(ans, list, s, 0);
        return ans;
    }
    
    public void backtrack(List<String> ans, List<String> solution, String s, int startIndex){
        if(solution.size() == 4){
            if(startIndex == s.length()){
                StringBuffer builder = new StringBuffer();
                builder.append(solution.get(0));
                for(int i = 1; i < solution.size(); i++){
                    builder.append(".").append(solution.get(i));
                }
                ans.add(builder.toString());
            }
            return;
        }
        
        for(int endIndex = startIndex; endIndex < startIndex + 3 && endIndex < s.length(); endIndex++){
        	if(s.charAt(startIndex) == '0' && startIndex != endIndex){
        		break;
        	}
        	
            String newStr = s.substring(startIndex, endIndex + 1);
            if(Integer.parseInt(newStr) <= 255){
                solution.add(newStr);
                backtrack(ans, solution, s, endIndex + 1);
                solution.remove(solution.size() - 1);
            }
        }
    }

    
    
    public static void main(String[] args){
    	Le_093_Restore_IP_Addresses t = new Le_093_Restore_IP_Addresses();
//    	String ip = "010010";
    	String ip = "19216811";
    	List<String> ans = t.restoreIpAddresses(ip);
    	for(String str : ans){
    		System.out.print(str + ", ");
    	} 
    }
}
