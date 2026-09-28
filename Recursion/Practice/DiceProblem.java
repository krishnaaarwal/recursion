
import java.util.ArrayList;
import java.util.List;

public class DiceProblem {
    public static void main(String[] args) {
        ArrayList<String> ans= new ArrayList<>();
        dice("",4,ans);
        System.out.println(ans);
    }

    static List<String> dice(String processed,int target,ArrayList<String> ans){
        if(target>6){
            return ans;
        }

        if(target==0){
            ans.add(processed);
            return ans;
        }


        for(int i=1;i<=target;i++) {
            dice(processed + i, target - i,ans);
        }
        return ans;
    }
}
