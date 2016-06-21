import java.util.*; 

class AverageTime {

 private ArrayList<Long> al;

AverageTime() {
    // Create an array list. 
    al = new ArrayList<Long>(); 
	} 
	
public void Add(Long AvTime) {
	Long AT = AvTime;
	al.add(AT);
	}
public Long calculateAverage() {
    long sum = 0;
    for (Long al2 : al) {
        sum += al2;
    }
    return sum / al.size();
}

}