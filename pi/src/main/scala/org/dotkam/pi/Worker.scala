/**
 * Copyright (C) 2009-2012 Typesafe Inc. <http://www.typesafe.com>
 */
package org.dotkam.pi

import akka.actor.Actor

/**
 * TODO: Document Me
 *
 * @author http://akka.io/docs/akka/2.0/intro/getting-started-first-scala.html
 */

class Worker extends Actor {

  def calculatePiFor( start: Int, nrOfElements: Int ): Double = {
    var acc = 0.0
    for (i ← start until ( start + nrOfElements ) )
      acc += 4.0 * ( 1 - ( i % 2 ) * 2 ) / ( 2 * i + 1 )
    acc
  }

  def receive = {
    case Work( start, nrOfElements ) =>
      sender ! Result( calculatePiFor( start, nrOfElements ) ) // perform the work
  }
}
