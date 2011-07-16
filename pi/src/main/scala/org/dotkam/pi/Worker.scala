package org.dotkam.pi

import akka.actor.Actor

/**
 * <p>TODO: Document Me</p>
 *
 * @author http://akka.io/docs/akka/1.1.2/intro/getting-started-first-scala.html#getting-started-first-scala
 */

class Worker extends Actor {
  def receive = {

    case Work( start, nrOfElements ) =>
      self reply Result( calculatePiFor( start, nrOfElements ) ) // perform the work
  }

  def calculatePiFor(start: Int, nrOfElements: Int): Double = {

    var acc = 0.0

    for ( i <- start until ( start + nrOfElements ) )
      acc += 4.0 * ( 1 - ( i % 2 ) * 2 ) / ( 2 * i + 1 )

    acc
  }
}