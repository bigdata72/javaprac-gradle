/**
 * package: collections
 * ====================
 * pgms from Ch:20 Lists, Stacks, Queues, and Priority Queues
 * 1) CollectionTest.testCollection
 * 	tests methods on Collection interface using
 * 	ArrayList, LinkedList,
 * 	HashSet, TreeSet, LinkedHashSet, Stack, Vector
 * 	Methods: contains, remove, size, addAll(union), retainAll(set intersection),
 * 	removeAll(set minus),
 *
 *  package: src.main.Test
 *  1) CollectionsUtilTest
 *  	- Methods on Collections class
 *  2) ComparatorTest
 *
 * 	package: list
 * 	=============
 * 	pgms from Ch:20 Lists
 *
 * 	1) ListMethods - methods on ArrayList and linkedList
 *
 * 	2) StackJavaUtilTest - tests method implementations using the Java.util.Stack implementation
 * 	based off Vector
 * 	search() uses lastIndexOf and then returns size() -1
 * 	peek() uses : len = size() and then returns elementAt(len -1)
 * 	to return the last element that was added
 * 	pop() uses : len = size() anf then returns removeElementAt(len -1) to return
 * 	the last element that was added
 *
 * 	3) QueueTest
 * 	uses ArrayDeque disallows null but a LinkedList allows null
 * 	test for element based equality - queues do not have element based equality
 *
 *	4) PriorityQTest
 * natural ordering priority and using a comparator
 *
 *  5) ExpressionEvaluator
 *  using two stacks.
 *  Algorithm need to understand better. pgm works
 *
 *  6) IterateLinkedList
 *  get(i) of linked list is not efficient. better iterator
 *  prove with a linked list having 5 million integers
 */
package topic.collections.book.liang;