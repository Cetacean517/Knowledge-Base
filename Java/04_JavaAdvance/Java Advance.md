# Advanced in Java

## I. Generics in Java 泛型

### 1.1 Intro of Generics

Generics is a way to tell compiler what kind of object(对象) a collection can contain.

- Compiler 可以检测数据类型，更安全
- 不需要对Object 进行 类型cast

```java
// Example without Generics
    List names = new ArrayList();
    names.add("Kelly");        
    String name = (String) names.get(0); 	// 2. need to cast type 
    System.out.println("First name: " + name);
	names.add(7);		// 1. int type can be add to ArrayList
```

```java
// Example with Generics
    List<String> names2 = new ArrayList();
    names2.add("Kelly");        
    String name2 = names2.get(0);			// 2. do not need cast type
    System.out.println("First name: " + name2);
    names2.add(7);		// 1. can only add String type to List
```



### 1.2 Generic Methods

- Specify the type of the parameter, can get compiler run time error.
- Compared to Generic methods, using Objects instead is not safe.

Use Object Type.

```java
public class GenericMethods {

    static Character[] charArray = {'h', 'e', 'l', 'l', 'o'};
    static Integer[] intArray = {1, 2, 3, 4, 5};
    static Boolean[] boolArray = {true, false, true};
	
    // 使用Object父类，去接收参数
    public static List arrayToList(Object[] array, List<Object> list) {
        for (Object object : array) {
            list.add(object);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Character> charList = arrayToList(charArray, new ArrayList<>());
        List<Boolean> boolList = arrayToList(boolArray, new ArrayList<>());
        List<Integer> intList = arrayToList(intArray, new ArrayList<>());
        // 即使类型不一致，使用Object的情况，也不会产生compiler runtime error.
        List<String> intList = arrayToList(intArray, new ArrayList<>());
    }

}
```

Use Generic Methods

```java
public class GenericMethods {

    static Character[] charArray = {'h', 'e', 'l', 'l', 'o'};
    static Integer[] intArray = {1, 2, 3, 4, 5};
    static Boolean[] boolArray = {true, false, true};

    // 使用泛型。 注意泛型的写法。指定类型一致，对于不一致的情况，会产生运行时错误。
    public static <T> List<T> arrayToList(T[] array, List<T> list) {
        for (T object : array) {
            list.add(object);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Character> charList = arrayToList(charArray, new ArrayList<>());
        List<Boolean> boolList = arrayToList(boolArray, new ArrayList<>());
        List<Integer> intList = arrayToList(intArray, new ArrayList<>());
        System.out.println(intList.get(0));
    }

}
```



### 1.3 Varargs

Varargs, means variable-length arguments.  

- Varargs can put all arguments in an array for developer.
- Gramma: `String...`

```java
private static void printShoppingList(String... items){
    System.out.println("SHOPPING LIST");
    for (int i =0; i< items.length; i++){
        System.out.println(i + 1 + ": " + items[i]);
    }
    System.out.println();
}
```



### 1.4 Liskov Subsitution principle

**Liskov Subsitution principle**:

- If you have a variable of a given type, you can assign it to a value that is a subtype of that type. 
- But it won't work with List type.
- （如果函数可以接受一个父类参数，就可以接受它的子类参数，但对于列表不适用）

```java
// Building 父类，Office 子类； 两个类仅覆写了toString方法。 
public static void main(String[] args) {
        Building building = new Building();        
        Office office = new Office();
        build(building);	// 会输出building
        build(office);		// 会输出office
        
        static void build(Building building) {
        System.out.println("Constructing a new " + building.toString());
    }
    
    	// Building 类型的List，会正常输出
        List<Building> buildings = new ArrayList();
        buildings.add(new Building());
        buildings.add(new Office());
        printBuildings(buildings);
        
    	// Office 类型的List，不能被printBuildings接受。因为该原则对列表不适用。
        List<Office> offices = new ArrayList();
        offices.add(new Office());
        offices.add(new Office());
        printBuildings(offices);
        
    }
    
    
    static void printBuildings(List<Building> buildings) {
        for(int i = 0; i < buildings.size(); i++) {
            System.out.println(i + 1 + ": " + buildings.get(i).toString());
        }
}
```



### 1.5 Wildcards in generic programming

Wildcards support to pass a certain type of arguments to a method.

- Support wildcards in two types: extends and super
- Use extends: invariable , the argument is an source data to the method.
- Use `super`: outvariable, the arguments are additional input to the method.

```java
    public static void main(String[] args) {
        
        // List of buildings
        List<Building> buildings = new ArrayList();
        buildings.add(new Building());
        buildings.add(new Building());
        printBuildings(buildings);
        
        // List of offices
        List<Office> offices = new ArrayList();
		// ...
        printBuildings(offices);

        // List of houses
        List<House> houses = new ArrayList();
		// ...
        printBuildings(houses);
        
        addHouseToList(houses);
        addHouseToList(buildings);        
        
    }

	// 1. 可以接受所有building的子类型    
    static void printBuildings(List<? extends Building> buildings) {
        for(int i = 0; i < buildings.size(); i++) {
            System.out.println(buildings.get(i).toString() + " " + (i + 1));
        }
        System.out.println();
    }
    
    // 2. 可以接受House以及它的父类型
    static void addHouseToList(List<? super House> buildings) {
        buildings.add(new House());
        System.out.println();
    }
}
```

