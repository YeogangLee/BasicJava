for(int i = 0; i < arr.length; i++){
	boolean flag = false;
	for(int j = 0; j < temp.length; j++){
		if(arr[i] != temp[j]){
			flag = true;
		}				
	}
	if(flag){
		temp[count++] = arr[i];
	}
}