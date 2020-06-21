/**
 * parent package for example.starbuzz
 * Decorator pattern attaches additional responsibility to an object
 * dynamically. It provides a flexible alternative to subclassing for extending functionality.
 *
 * Pgm: 1) StarBuzzMain
 * 	Beverage is abstract component
 * 	DarkRoast, Decaf, Espresso are concrete components
 * 	CondimentDecorator is the decorater
 * 	Soy, Mocha, SteamedMilk are the concrete decorators
 *
 * 	Pgm 2) UpperToLowerCase
 * 	Converts Upper case characters to Lower case from System input
 * 	The decorator extends FilterInputStream and uses a BufferedInputStream to read from System.in
 */
package topic.designpatterns.book.hfdp.st.decorator;