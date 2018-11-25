package com.wsw;

import com.wsw.modle.User;

import java.lang.reflect.Array;
import java.util.*;

public class CollectionPractice {

    public static void main(String[] args) {
/*
        ArrayList<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.iterator().forEachRemaining(item -> item=item+"是学生");
        System.out.println(list.toString());
        System.out.println(Arrays.toString(list.toArray()));
        list.removeIf(item -> item.contains("1"));
        System.out.println(list.toString());
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("6");list2.add("5");
        list.removeAll(list2);
        System.out.println(list.toString());
*/
        /**
         * linkList
         */
/*
        LinkedList<String> list = new LinkedList<>();
        list.add("王");
        list.add("世");
        list.add("伟");
        list.add("艾");
        list.add("红");
        list.add("香");

        list.iterator().forEachRemaining(item ->System.out.print(item));
        System.out.println(list instanceof  RandomAccess);
        Iterator<String> iterator = list.iterator();//这个iterator没有add方法
        ListIterator<String> iterator1 = list.listIterator();

        while (iterator1.hasNext()){
            iterator1.next();
            System.out.println(iterator1.nextIndex());
            if(iterator1.nextIndex()==3){
                iterator1.add("爱");
            };
        }
        list.iterator().forEachRemaining(item ->System.out.print(item));
*/

      /*  ArrayList<Object> list = new ArrayList<>();
        list.add("王");
        list.add("世");
        list.add("伟");
        list.add("艾");
        list.add("红");
        list.add("香");
        list.add(3,"爱");
        System.out.println(list instanceof RandomAccess);
        list.iterator().forEachRemaining(item->System.out.print(item));*/

        /**
         * 对象的某个字段排序
         */
        User user1 = new User(1, "11", "111");
        User user2 = new User(2, "22", "222");
        User user3 = new User(3, "33", "333");
        User user4 = new User(4, "44", "444");
        ArrayList<User> users = new ArrayList<>();
        users.add(user2);users.add(user1);users.add(user3);users.add(user4);
        /*users.sort(Comparator.comparing(User::getPassword));
        users.iterator().forEachRemaining(item->System.out.println(item.getPassword()));
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getUserId()-o2.getUserId();
            }
        });*/
        /*Collections.shuffle(users);
        users.iterator().forEachRemaining(item->System.out.println(item.getUserId()));
        User max = Collections.max(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getUserId()-o2.getUserId();
            }
        });*/
       // System.out.println(max.getUserId());
        /**
         * 数组和集合的转换
         */
        User[] users1 = users.toArray(new User[users.size()]);
        List<User> users2 = Arrays.asList(users1);
        User[] users3 = Arrays.asList(users1).toArray(new User[users1.length]);
        System.out.println("users1"+users1.toString());
        System.out.println(users1.toString());
        System.out.println("users3");
        System.out.println(users3.toString());
        System.out.println(Thread.currentThread().getState());
    }
}