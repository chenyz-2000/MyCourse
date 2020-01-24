import java.util.Date;

class StopWatch {
	private Date startTime,endTime;
	
	StopWatch(){
		startTime = new Date();
	}
	
	void start() {
		startTime = new Date();
	}
	void stop() {
		endTime = new Date();
	}
	long getElapsedTime() {
		return endTime.getTime()-startTime.getTime();
	}
}

public class E03 {
	static int[] creatRandomArray(int len,int range) {
		int res[] = new int[len];
		for(int i = 0;i<len;i++)res[i]=(int)(Math.random()*range);
		return res;
	}
	
	static void selectionSort(int[] x) { //选择排序
        for(int i = 0; i < x.length - 1; i++) {
            int k = i;
            for(int j = k + 1; j < x.length; j++){
                if(x[j] < x[k]) { k = j;}//记录最小值所在的位置
            }
            if(i != k){  //交换
                int t = x[i];
                x[i] = x[k];
                x[k] = t;
            }    
        }
    }
	
	public static void main(String[] args) {
		int arr[] = creatRandomArray(100000,100000);
		StopWatch a = new StopWatch();
		selectionSort(arr);
		a.stop();
		System.out.println("执行时间为"+a.getElapsedTime()+"ms");
	}
}