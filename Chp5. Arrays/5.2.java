static public void getNextNumber2(List<Integer> l) {
	boolean resizeArray = false;
	for(int i = l.size() - 1; i >= 0; i--) {
	  int currentDigit = l.get(i);  // 8 of index 1
	  if(currentDigit == 9) {
	    l.set(i, 0);
	    
	    if(i == 0) {            
	      resizeArray = true;
	    }
	  }
	  else {
	      l.set(i, l.get(i) + 1);
	      break;
	  }
	}

	if(resizeArray) {
	  l.set(0, 1);
	  l.add(0);
	}
}

