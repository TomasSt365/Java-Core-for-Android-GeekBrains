package Lessons.Lesson10;


import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> listArr = new ArrayList<>(Arrays.asList
                ("1","2","3","10","23","23","12","43","12","2"));

        PrintUniqueElements(listArr);
        PrintElementsAndTheirNumber(listArr);

        Map<String, String> phonebook = new HashMap<>();
        phonebook.put("124325423","Janovich");
        phonebook.put("243552155225","Demidov");
        phonebook.put("44352343532", "Vasilev");
        phonebook.put("234435", "Demidov");
        phonebook.put("332435445", "Janovich");

        PrintNumbersBySearchingLastName(phonebook,"Janovich");

    }

    public static void PrintUniqueElements(List<String> list){

        for (String element : list) {
            if(getNumberOfEqualsElementsOfList(element, list) == 1){
                System.out.println(element);
            }
        }
    }

    public static void PrintElementsAndTheirNumber(List<String> list){
        for (String element : list){
            System.out.println("(Element;Number): (" + element + ";" +
                    getNumberOfEqualsElementsOfList(element, list) + ")");
        }
    }

    public static int getNumberOfEqualsElementsOfList
            (String checkedElement, List<String> list) {

        int NumberOfEqualsElements = 0;

        for (String element : list){

            if(element.equals(checkedElement)){
                NumberOfEqualsElements++;
            }

        }
        return NumberOfEqualsElements;
    }

    public static void PrintNumbersBySearchingLastName
            (Map<String, String> phonebook, String searchingLastName) {
        int numberOfPrints = 0;
        Set<Map.Entry<String, String>> entries = phonebook.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            if (entry.getValue().equalsIgnoreCase(searchingLastName)) {
                System.out.println(entry.getKey());
                numberOfPrints++;
            }
        }
        if (numberOfPrints == 0) {
            System.out.println("No results were found for your search");
        }
    }

}

