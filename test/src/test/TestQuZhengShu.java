package test;

public class TestQuZhengShu {
	public static String tirerNumber(String str) {
	    
    	str=str.trim();
    	String str2="";
    	if(str != null && !"".equals(str)){
    	for(int i=0; (i< str.length());i++){
    	if (str.charAt(i)==32)
    		break;
    	else if(str.charAt(i)>=48 && str.charAt(i)<=57){
    	str2+=str.charAt(i);
    	}
    	}

    	}
    	return(str2);
    	}
	
	
	public static void main(String[] args){
		System.out.println(tirerNumber("\"_ \"235ss ss23"));
	}
}
