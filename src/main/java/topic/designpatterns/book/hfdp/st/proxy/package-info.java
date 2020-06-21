/**
 * Proxy provides a surrogate or placeholder to the actual object to control access to it.
 *
 * Exmple demo shows a protection proxy using Java's dynamic proxy and InvocationHandler
 *
 * Pgm: MatchMakingDriver
 * The proxy should allow the owner to update its interest but not its rating.
 * The proxy should allow non-owners to update rating but not their interests
 * 		Interface: Person
 * 		Impl : PersonBean
 * 		InvocationHandlers: OwnerInvocationHander, NonOwnerInvocationHander
 */
package topic.designpatterns.book.hfdp.st.proxy;