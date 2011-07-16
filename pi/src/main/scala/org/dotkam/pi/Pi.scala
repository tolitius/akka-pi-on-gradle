package org.dotkam.pi

import akka.actor.{Actor}
import Actor._

import java.util.concurrent.CountDownLatch

/**
 * <p>TODO: Document Me</p>
 * 
 * @author http://akka.io/docs/akka/1.1.2/intro/getting-started-first-scala.html#getting-started-first-scala
 */

object Pi extends App {

  calculate( nrOfWorkers = 8, nrOfElements = 10000, nrOfMessages = 10000 )

  def calculate( nrOfWorkers: Int, nrOfElements: Int, nrOfMessages: Int ) {

    // this latch is only plumbing to know when the calculation is completed
    val latch = new CountDownLatch(1)

    // create the master
    val master = actorOf( new Master( nrOfWorkers, nrOfMessages, nrOfElements, latch ) ).start()

    // start the calculation
    master ! Calculate

    // wait for master to shut down
    latch.await()
  }
}