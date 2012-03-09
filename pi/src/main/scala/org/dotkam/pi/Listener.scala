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

class Listener extends Actor {
  def receive = {
    case PiApproximation( pi, duration ) =>
      println( "\n\tPi approximation: \t%s\n\tCalculation time: \t%s".format( pi, duration ) )
      context.system.shutdown()
  }
}