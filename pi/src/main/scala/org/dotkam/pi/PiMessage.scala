package org.dotkam.pi

/**
 * <p>TODO: Document Me</p>
 * 
 * @author http://akka.io/docs/akka/1.1.2/intro/getting-started-first-scala.html#getting-started-first-scala
 */

sealed trait PiMessage

case object Calculate extends PiMessage

case class Work( start: Int, nrOfElements: Int ) extends PiMessage

case class Result( value: Double ) extends PiMessage