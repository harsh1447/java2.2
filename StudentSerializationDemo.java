import java.io.*;

// Student class must implement Serializable
class Student implements Serializable {
    private static final long serialVersionUID = 1L; // Good practice
    private int studentID;
    private String name;
    private String grade;

    public Student(int studentID, String name, String grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student {ID=" + studentID + ", Name='" + name + "', Grade='" + grade + "'}";
    }
}

public class StudentSerializationDemo {
    public static void main(String[] args) {
        String filename = "student.ser";

        // Create a Student object
        Student s1 = new Student(101, "Alice", "A");

        // --- Serialization ---
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(s1);
            System.out.println("✅ Student object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // --- Deserialization ---
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Student s2 = (Student) ois.readObject();
            System.out.println("✅ Student object deserialized successfully.");
            System.out.println("Student Data: " + s2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
