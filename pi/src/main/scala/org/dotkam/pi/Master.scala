package org.dotkam.pi

import akka.actor.{Actor, Props, ActorRef}
import akka.routing.RoundRobinRouter
import akka.util.duration._

/**
 * TODO: Document Me
 * 
 * @author http://akka.io/docs/akka/2.0/intro/getting-started-first-scala.html
 */

class Master( nrOfWorkers: Int, nrOfMessages: Int, nrOfElements: Int, listener: ActorRef )
  extends Actor {

  var pi: Double = _
  var nrOfResults: Int = _
  val start: Long = System.currentTimeMillis

  val workerRouter = context.actorOf(
    Props[Worker].withRouter(RoundRobinRouter(nrOfWorkers)), name = "workerRouter")

  def receive = {
    case Calculate =>
      for (i ← 0 until nrOfMessages) workerRouter ! Work(i * nrOfElements, nrOfElements)
    case Result(value) =>
      pi += value
      nrOfResults += 1
      if (nrOfResults == nrOfMessages) {
        // Send the result to the listener
        listener ! PiApproximation(pi, duration = ( System.currentTimeMillis - start ).millis )
        // Stops this actor and all its supervised children
        context.stop(self)
      }
  }

}