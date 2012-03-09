/**
 * Copyright (C) 2009-2012 Typesafe Inc. <http://www.typesafe.com>
 */
package org.dotkam.pi

import akka.actor._

/**
 * TODO: Document Me
 * 
 * @author http://akka.io/docs/akka/2.0/intro/getting-started-first-scala.html
 */

object Pi extends App {

  calculate( nrOfWorkers = 4, nrOfElements = 10000, nrOfMessages = 10000 )

  def calculate( nrOfWorkers: Int, nrOfElements: Int, nrOfMessages: Int ) {
    // Create an Akka system
    val system = ActorSystem( "PiSystem" )

    // create the result listener, which will print the result and shutdown the system
    val listener = system.actorOf( Props[Listener], name = "listener" )

    // create the master
    val master = system.actorOf( Props( new Master(
      nrOfWorkers, nrOfMessages, nrOfElements, listener ) ),
      name = "master" )

    // start the calculation
    master ! Calculate
  }
}