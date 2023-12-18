package week4.opgaveFacade;

public class Main {
    public static void main(String[] args) {
        ListMap<Integer, String> membersMap = new ListMap<>();

        // Leden toevoegen
        membersMap.put(232, "Henk");
        membersMap.put(184, "Els");
        membersMap.put(481, "Joe");
        membersMap.put(232, "Hariet");

        // Lid opvragen
        String memberName1=membersMap.get(184);
        System.out.println(memberName1); // Els

        String memberName2=membersMap.get(232);
        System.out.println(memberName2); // Hariet

        String memberName3=membersMap.get(164);
        System.out.println(memberName3); // null

        ListMap<String, Integer> membersToIdMap = new ListMap<>();

        // Leden toevoegen
        membersToIdMap.put("Hariet", 192);
        membersToIdMap.put("Els", 184);
        membersToIdMap.put("Joe", 481);
        membersToIdMap.put("Hariet", 232);

        // Lid opvragen
        int membersToIdMap1=membersToIdMap.get("Els");
        System.out.println(memberName1); // 184

        int membersToIdMap2=membersToIdMap.get("Hariet");
        System.out.println(memberName2); // 232

        //null does not work with int and trows a null pointer exception
        //int membersToIdMap3=membersToIdMap.get("Kees");
        //System.out.println(memberName3); // null
    }
}
