package MathsForDsa;

public class SQRTDecomposition {

    public int fun(int[] arr){
        int N = arr.length;
        int n = (int)Math.sqrt(N);

        int blocks_id = -1;
        int[] blocks = new int[n+1];

        for (int i = 0; i < N; i++) {
            //new block is starting
            if(i % n == 0){
                blocks_id++;
            }

            blocks[blocks_id] += arr[i];
        }
        return query(blocks,arr,2,7,n);
    }

    private int query(int[] blocks,int[] arr,int l,int r,int sqrt){
        int ans = 0;

        //LEFT PART
        while(l % sqrt !=0 && l < r && l != 0){
            ans +=arr[l++];
        }

        //MIDDLE PART
        while (l + sqrt <= r){
            ans += blocks[l/sqrt];

            l = l+sqrt;
        }

        //RIGHT PART
        while (l <= r){
            ans +=arr[l++];
        }

        return ans;
    }

    public void update(int[] blocks,int[] arr,int i,int value,int sqrt){
        int block_id = i/sqrt;

        blocks[block_id] += value - arr[i];
        arr[i] = value;
    }
}
