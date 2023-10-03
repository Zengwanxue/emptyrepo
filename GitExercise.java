import java.util.*;

public class GitExercise {
    public static void main(String[] args) {
        System.out.println("==============================");
        System.out.println("     欢迎使用密码加密解密系统");
        System.out.println("==============================");
        System.out.println("1.加密\n2.解密\n3.退出");
        System.out.println("请选择操作(输入序号)：");
        Scanner sc = new Scanner(System.in);//输入序号
        int sn = sc.nextInt();
        if(sn==1){
            System.out.println("请输入要加密的数字密码：");
            Scanner s = new Scanner(System.in);
            int number = s.nextInt();
            try{
                check(number);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            int count = getLen(number);
            System.out.println("加密后的结果：");
            jiaMi(number,count);
        }else if (sn==2){
            System.out.println("请输入要解密的数字密码：");
            Scanner s = new Scanner(System.in);
            int number = s.nextInt()/2;
            try{
                check(number);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            int count = getLen(number);
            System.out.println("解密后的结果：");
            jieMi(number,count);
        }else if (sn==3){
            System.out.println("        退出加密解密系统！");
            System.out.println("==============================");
        }else {
            System.out.println("您输入的序号非法!!");
        }
    }

    //判断密码是否符合要求
    public static void check(int number) throws Exception{
        if (number <=0){
            throw new Exception("输入的数字小于或等于0，不符合要求");
        }
    }

    //判断密码位数
    public static int getLen(int number){
        int count = 0;
        while (number!=0){
            number=number/10;
            count++;
        }
        return count;
    }

    //加密操作
    public static void jiaMi(int number,int count){
        int [] arr = new int[count];
        arr [0] = number%10;
        for (int i =1; i< arr.length; i++) {
            arr[1] = (int) ((number / Math.pow(10, i)));
        }
        for (int i =0; i< arr.length; i++){
            if (number!=0){
                int ge = number%10;
                number = number/10;
                arr[i] = ge;
            }else {
                break;
            }
        }
        int swap = arr[0];
        arr[0] = arr[1];
        arr[1] = swap;
        for (int i =0; i<count; i++){
            arr[i] = ((arr[i] +5)%10)*2;
        }
        for (int i =0; i<count; i++){
            if (arr[i]>10){
                arr[i] -=10;
                arr[i+1] +=1;
            }
        }
        for (int i =0; i<count; i++){
            System.out.print(arr[i]);
        }
    }

    //解密操作
    public static void jieMi(int number,int count){
        int [] arr = new int[count];
        arr [0] = number%10;
        for (int i =1; i< arr.length; i++) {
            arr[1] = (int) ((number / Math.pow(10, i)));
        }
        for (int i =0; i< arr.length; i++){
            if (number!=0){
                int ge = number%10;
                number = number/10;
                arr[i] = ge;
            }else {
                break;
            }
        }
        int swap = arr[count-2];
        arr[count-2] = arr[count-1];
        arr[count-1] = swap;
        for (int i =0; i<count; i++){
            System.out.print(arr[i]);
        }
    }
}
