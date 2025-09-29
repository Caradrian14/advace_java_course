// University.java (clase sin nombre en Java 21)
import java.util.*;

// Record para representar un profesor
record LecturerRecord(String name, int age, String faculty, String dept) {}

        // Clases para departamentos y facultades
        class SoftwareEngineeringDept {}
        class EngineeringFaculty {}
        class AccountingDept {}
        class BusinessFaculty {}
        class SocialCareDept {}
        class HumanitiesFaculty {}

        void main() {
            seqColl();
            seqSet();
            seqMap();

            SoftwareEngineeringDept softwareEngDept = new SoftwareEngineeringDept();
            EngineeringFaculty engineeringFaculty = new EngineeringFaculty();
            LecturerRecord mike = new LecturerRecord("Mike Bloggs", 44, "Engineering", "Software Engineering");
            recordPatterns(mike); // (age < 64)

            AccountingDept accountingDept = new AccountingDept();
            BusinessFaculty businessFaculty = new BusinessFaculty();
            LecturerRecord alan = new LecturerRecord("Alan Austin", 64, "Business", "Accounting");
            recordPatterns(alan); // Imprime detalles

            SocialCareDept socialCareDept = new SocialCareDept();
            HumanitiesFaculty humanitiesFaculty = new HumanitiesFaculty();
            LecturerRecord lisa = new LecturerRecord("Lisa Bloggs", 65, "Humanities", "Social Care");
            recordPatterns(lisa); // Imprime detalles
        }

        // SequencedCollection
        void seqColl() {
            SequencedCollection<LecturerRecord> collection = new ArrayList<>();
            LecturerRecord jane = new LecturerRecord("Jane Bloggs", 24, "Engineering", "Software Engineering");
            LecturerRecord anne = new LecturerRecord("Dr. Anne Bloggs", 35, "Engineering", "Software Engineering");
            LecturerRecord joe = new LecturerRecord("Joe Bloggs PhD", 54, "Engineering", "Software Engineering");

            collection.addFirst(jane);
            collection.addFirst(anne);
            collection.addLast(joe);

            System.out.println(collection);

            System.out.println("getFirst() : " + collection.getFirst());
            System.out.println("getLast() : " + collection.getLast());

            LecturerRecord removed = collection.removeLast();
            System.out.println("removeLast() : " + removed);

            System.out.println(collection);

            System.out.println("Iterando de inicio a fin:");
            for (LecturerRecord lecturer : collection) {
                System.out.println(lecturer);
            }

            System.out.println("Iterando de fin a inicio:");
            List<LecturerRecord> reversedList = new ArrayList<>(collection);
            Collections.reverse(reversedList);
            for (LecturerRecord lecturer : reversedList) {
                System.out.println(lecturer);
            }
        }

        void seqSet() {
            SequencedSet<LecturerRecord> set = new LinkedHashSet<>();
            LecturerRecord janeAustin = new LecturerRecord("Jane Austin", 24, "Business", "Accounting");
            LecturerRecord charlotte = new LecturerRecord("Dr. Charlotte Bronte", 35, "Business", "Accounting");
            LecturerRecord anneBronte = new LecturerRecord("Anne Bronte PhD", 54, "Business", "Accounting");

            set.addFirst(janeAustin);
            set.addFirst(janeAustin);
            set.addFirst(janeAustin);
            set.addFirst(charlotte);
            set.addLast(janeAustin);
            set.addLast(anneBronte);

            System.out.println(set);

            System.out.println("getFirst() : " + set.getFirst());
            System.out.println("getLast() : " + set.getLast());

            LecturerRecord removedFirst = set.removeFirst();
            System.out.println("removeFirst() : " + removedFirst);

            System.out.println(set);

            System.out.println("Iterando de inicio a fin:");
            for (LecturerRecord lecturer : set) {
                System.out.println(lecturer);
            }

            System.out.println("Iterando de fin a inicio:");
            List<LecturerRecord> reversedList = new ArrayList<>(set);
            Collections.reverse(reversedList);
            for (LecturerRecord lecturer : reversedList) {
                System.out.println(lecturer);
            }
        }

        void seqMap() {
            SequencedMap<LecturerRecord, String> map = new LinkedHashMap<>();
            LecturerRecord goneril = new LecturerRecord("Goneril", 55, "Humanities", "Social Care");
            LecturerRecord regan = new LecturerRecord("Regan", 50, "Humanities", "Social Care");
            LecturerRecord cordelia = new LecturerRecord("Cordelia", 45, "Humanities", "Social Care");
            LecturerRecord kingLear = new LecturerRecord("King Lear", 88, "Humanities", "Social Care");

            map.putFirst(regan, "Middle");
            map.putFirst(goneril, "Eldest");
            map.putLast(cordelia, "Youngest");
            map.putLast(kingLear, "Father");

            System.out.println(map);

            System.out.println("firstEntry() : " + map.firstEntry());
            System.out.println("lastEntry() : " + map.lastEntry());

            Map.Entry<LecturerRecord, String> removedEntry = map.pollLastEntry();
            System.out.println("pollLastEntry() : " + removedEntry);

            System.out.println(map);

            System.out.println("Iterando de inicio a fin:");
            for (Map.Entry<LecturerRecord, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + "; " + entry.getValue());
            }

            System.out.println("Iterando de fin a inicio:");
            List<Map.Entry<LecturerRecord, String>> entries = new ArrayList<>(map.entrySet());
            Collections.reverse(entries);
            for (Map.Entry<LecturerRecord, String> entry : entries) {
                System.out.println(entry.getKey() + "; " + entry.getValue());
            }
        }

        void recordPatterns(Object obj) {
            String output = switch (obj) {
                case LecturerRecord lecturer when lecturer.age() >= 64 ->
                        """
                        Name: %s,
                        Age: %d,
                        Faculty: %s,
                        Department: %s
                        """.formatted(lecturer.name(), lecturer.age(), lecturer.faculty(), lecturer.dept());
                case null, default -> "";
            };
            System.out.println(output);
        }
