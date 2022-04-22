import java.util.ArrayList;

public class Administration {

    /**
     * returns an array of students whose last name begins with the given character
     * @param class1 class whose students we are inspecting
     * @param start character we are concerned with
     */
    public ArrayList<Student> listStudents(UniClass class1, char start){
        ArrayList<Student> list = new ArrayList<>();
        //TODO: Write the method described above
        
        for (Student stud1: class1.getStudents()) {
        	int lastIndex = stud1.getName().indexOf(" ") + 1;
        	char initial = stud1.getName().charAt(lastIndex);
        	
        	if (initial == start) {
        		list.add(stud1);
        	}
        }

        return list;
    }

    /**
     * compares two lists of students and returns the common students (or set intersection)
     * @param class1 list of students
     * @param class2 second list of students
     */
    public ArrayList<Student> intersection(Student[] class1,Student[] class2){
        ArrayList<Student> list = new ArrayList<>();
        //TODO: alter this method to conform to the expected test result in AdministrationTest in the case of an empty list
        
        for (Student stud1: class1){
            for (Student stud2: class2){

                if(stud1.equals(stud2) && !list.contains(stud1)){
                    list.add(stud1);
                }
            }
        }
        
        if (list.size() == 0)
        	list = null;

        return list;
    }
}
