package ru.ponomaryov.se;

public class App {

    private static final double BACKPACK_CAPACITY = 25.0; //максимальная вместимость рюкзака в килограммах

    //Коллекция предметов
    //Все предметы из этой коллекции будут рассматриваться при подборе наиболее дорого варианта наполнения рюкзака
    private static ItemCollectionImpl iCollection = new ItemCollectionImpl();

    private static Item[] workArray;    //рабочий массив
    private static Item[] bestArray;    //массив фиксирующий наилучшее состояние подбора
    private static double bestCost = 0; //наилучшая цена
    private static int callCount = 0;   //количество рекурсивных вызовов функции calcArray

    public static void main(String[] args) {

        iCollection.addItem("Ноутбук", 7.0, 8.05);
        iCollection.addItem("Книга", 1.2, 1.88);
        iCollection.addItem("Бинокль", 4.0, 4.75);
        iCollection.addItem("Аптечка", 1.0, 1.19);
        iCollection.addItem("Котелок", 2.0, 2.37);

        int maxItems = calcMaxItems(iCollection);

        System.out.println("Backpack capacity: " + BACKPACK_CAPACITY);
        System.out.println("Max items: " + maxItems);

        workArray = new Item[maxItems];
        bestArray = new Item[maxItems];

        for (int i = 0; i < workArray.length; i++) {
            bestArray[i] = null;
            workArray[i] = null;
            i++;
        }

        calcArray(0);

        System.out.println();
        System.out.println("Best cost: $" + bestCost);
        System.out.println("Best weight: " + calcTotalWeight(bestArray) + "kg");
        for (Item item : bestArray) {
            if (item != null) {
                System.out.println(item.name + " [" + item.weight + "kg/$" + item.cost + "]");
            }
        }
        //общее количество вызовов функции calcArray
        System.out.println("Total recursion call: " + callCount);
    }

    //Вычисление максимально выгодного состояния.
    // Если состояние выгоднее, чем предыдущее - оно запоминается
    private static void calcIfBestArray() {
        double c = calcTotalCost(workArray);
        double w = calcTotalWeight(workArray);
        if (c > bestCost && w <= BACKPACK_CAPACITY) {
            bestArray = workArray.clone();
            bestCost = c;
        }
    }

    //Вычисление максимально возможного количества предметов
    //Внимание! Глубина рекурсии равна максимально возможному количеству предметов
    private static int calcMaxItems(ItemCollectionImpl iCollect) {
        double minWeight = 10000000.0;
        //Поиск самого маленького предмета в коллекции
        for (int i = 0; i < iCollect.getCount(); i++) {
            if (iCollect.getItem(i).weight < minWeight) {
                minWeight = iCollect.getItem(i).weight;
            }
        }
        Double d = BACKPACK_CAPACITY / minWeight;
        return d.intValue();
    }

    //Вычисление суммы из массива предметов
    private static double calcTotalCost(Item[] wArray) {
        double summ = 0;
        for (Item item : wArray) {
            if (item != null) {
                summ += item.cost;
            }
        }
        return summ;
    }

    //Вычисление массы из массива предметов
    private static double calcTotalWeight(Item[] wArray) {
        double summ = 0;
        for (Item item : wArray) {
            if (item != null) {
                summ += item.weight;
            }
        }
        return summ;
    }

    //Рекурсивная функция поиска наибольшей стоимости вмещаемых в рюкзак предметов из коллекции
    private static void calcArray(int index) {
        //Если индекс больше, чем количество предметов - нам тут делать нечего
        //Если текущий вес больше, чем максимальный - нам тут тоже делать нечего
        if (index >= workArray.length || calcTotalWeight(workArray) > BACKPACK_CAPACITY) {
            return;
        }
        callCount++;
        //Перебираем коллекцию предметов
        for (int i = 0; i < iCollection.getCount(); i++) {
            calcArray(index + 1); //Рекурсивно вызываем следующий индекс
            //Делаем рекурсию с самого начала, чтобы просчитать пустые места
            workArray[index] = iCollection.getItem(i); //обновляем в текущем индексе предмет
            calcIfBestArray(); //Проверка на максимально лучшее состояние
        }
    }
}
